package com.example.securityv1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitListenService {

    @RabbitListener(queues = "test", concurrency = "8")
    public void onMessage(Message message){
      log.info("on Message : {}" , new String(message.getBody(), Charset.defaultCharset()));
    }


}
