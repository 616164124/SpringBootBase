package com.mikael.demo;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.*;
import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {
    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "queue01";

    @Test
    void contextLoads() throws JMSException {
        //1.创建连接工场,按照给定的URL地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工场，获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start(); //连上地址

        //3.创建会话session，
        // 两个参数，第一个参数叫：事物，第二个参数叫：签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地（具体是队列还是主题topic）
        //Destination destination = session.createQueue(QUEUE_NAME); 可以赋给目的地，而不直接赋给具体的队列还是主题，但是一般不建议这么做
        Queue queue = session.createQueue(QUEUE_NAME);
        //5.创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        //6.通过使用消息生产者messageProducer生产3条消息发送到MQ的队列里面
        for (int i = 1; i <= 3; i++) {
            //7.创建消息,好比学生按照老师的要求写好的面试题消息
            TextMessage textMessage = session.createTextMessage("msg---" + i);//理解为一个字符串
            //8.通过messageProducer发送给MQ
            messageProducer.send(textMessage);

        }
        //9.关闭资源
        messageProducer.close();
        session.close();
        connection.close();

        System.out.println("*****消息发布到MQ完成");
    }

    @Test
    void AcceptMSG() throws JMSException, IOException {
        System.out.println("***我是二号消费者");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageConsumer messageConsumer = session.createConsumer(queue);
        messageConsumer.setMessageListener(new MessageListener() {  //设置监听器，消费者监听消息，如果有消息就消费，如果没有消息就不管
            @Override
            public void onMessage(Message message) {  //该方法是盯着消息来监听的方法
                if (null != message && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("****消费者接收到消息:" + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();  //保证控制台不关
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
