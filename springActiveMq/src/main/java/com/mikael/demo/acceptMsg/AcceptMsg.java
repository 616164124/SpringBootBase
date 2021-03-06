package com.mikael.demo.acceptMsg;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @version: V1.0
 * @author: mikael
 * @className: AcceptMsg
 * @packageName: com.mikael.demo.acceptMsg
 * @description:
 * @data: 2020-12-25
 **/
public class AcceptMsg {
    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {

        System.out.println("***我是二号消费者");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("first");
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
