package org.example.receivermsg;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MsgReceiver {

  private static final Logger log = LoggerFactory.getLogger(MsgReceiver.class);

  // 监听器监听指定的Queue
  @RabbitListener(queues = "hello")
  public void process(String hello) {
    log.info("Receiver:" + hello);
  }

  @RabbitListener(queues = "MQ.LazyQueue")
  @RabbitHandler
  public void onLazyMessage(Message msg, Channel channel) throws IOException {
    long deliveryTag = msg.getMessageProperties().getDeliveryTag();

    channel.basicAck(deliveryTag, true);
    log.info("lazy receive " + new String(msg.getBody()));
  }
  @RabbitListener(queues = "dxl-hello")
  @RabbitHandler
  public void onLazyMessage1(Message msg, Channel channel) throws IOException {
    long deliveryTag = msg.getMessageProperties().getDeliveryTag();
    log.info("进入received");
    //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
    channel.basicAck(msg.getMessageProperties().getDeliveryTag(),false);
    log.info("dxl-hello receive " + new String(msg.getBody()));

  }
}
