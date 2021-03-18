package org.example.sendmsg;

import org.example.config.RabbitConfig;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MQSender {

  @Autowired private RabbitTemplate rabbitTemplate;

  final RabbitTemplate.ConfirmCallback confirmCallback =
      new RabbitTemplate.ConfirmCallback() {

        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
          System.out.println("correlationData: " + correlationData);
          System.out.println("ack: " + ack);
          if (!ack) {
            System.out.println("异常处理....");
          }
        }
      };

  final RabbitTemplate.ReturnCallback returnCallback =
      new RabbitTemplate.ReturnCallback() {

        @Override
        public void returnedMessage(
            Message message, int replyCode, String replyText, String exchange, String routingKey) {
          System.out.println(
              "return exchange: "
                  + exchange
                  + ", routingKey: "
                  + routingKey
                  + ", replyCode: "
                  + replyCode
                  + ", replyText: "
                  + replyText);
        }
      };

  public void sendLazy(Object message) {
    rabbitTemplate.setMandatory(true);
    rabbitTemplate.setConfirmCallback(confirmCallback);
    rabbitTemplate.setReturnCallback(returnCallback);
    // id + 时间戳 全局唯一
    CorrelationData correlationData = new CorrelationData("12345678909" + new Date());

    // 发送消息时指定 header 延迟时间
    rabbitTemplate.convertAndSend(
        RabbitConfig.LAZY_EXCHANGE,
        "lazy.boot",
        message,
        new MessagePostProcessor() {
          @Override
          public Message postProcessMessage(Message message) throws AmqpException {
            // 设置消息持久化
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
             message.getMessageProperties().setHeader("x-delay", "1000");
            //message.getMessageProperties().setDelay(6000);
            return message;
          }
        },
        correlationData);
  }
}
