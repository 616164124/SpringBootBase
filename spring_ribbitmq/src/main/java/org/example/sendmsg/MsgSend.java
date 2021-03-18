package org.example.sendmsg;

import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/** @author mikael */
@Component
public class MsgSend {

  private static final Logger log = LoggerFactory.getLogger(MsgSend.class);
  private static ConnectionFactory factory;
  @Autowired public AmqpTemplate amqpTemplate;

  public void send() {
    String context = "hello " + new Date();
    log.info("Sender:" + context);
    // hello 为 queue名
    amqpTemplate.convertAndSend("hello", context);
  }

  public void send1() {
    log.info("进入 send1");
    amqpTemplate.convertAndSend("dxl", "dxl-hello", "hhhhhhh" + new Date());
  }
}
