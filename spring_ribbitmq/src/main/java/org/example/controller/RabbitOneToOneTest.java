package org.example.controller;

import org.example.sendmsg.MQSender;
import org.example.sendmsg.MsgSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 单生产者和单消费者
 *
 * @author mikael
 */
@RestController
public class RabbitOneToOneTest {
private static final Logger logger = LoggerFactory.getLogger(RabbitOneToOneTest.class);

  @Autowired private MsgSend msgSend;
  @Autowired private MQSender mqSender;

  @PostMapping("/hello")
  public void hello() {
    msgSend.send();
  }

  @PostMapping("/delay")
  public void delay() {
    String msg = "hello spring "+new Date();

    mqSender.sendLazy(msg + ":");
  }
  @PostMapping("/dxl")
  public void dxl() {
    String msg = "hello spring "+new Date();
    logger.info(msg);
    msgSend.send1();
  }
}
