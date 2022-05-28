package com.example.securityv1.controller;

import com.example.securityv1.model.vo.MessageVO;
import com.google.gson.Gson;
import com.rabbitmq.tools.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IndexController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/send/message")
    public ResponseEntity home(@Validated @RequestBody MessageVO messageVO) {

        rabbitTemplate.convertAndSend("test", new Gson().toJson(messageVO));

        return ResponseEntity.ok("OK");
    }


}
