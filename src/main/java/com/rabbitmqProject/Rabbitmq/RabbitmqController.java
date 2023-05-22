package com.rabbitmqProject.Rabbitmq;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RabbitmqController {

    public RabbitmqController(RabbitmqProducer producer) {
        this.producer = producer;
    }

    private  RabbitmqProducer producer;


    @GetMapping("/publish")
    public ResponseEntity<String> sendMesssage(@RequestParam ("message")String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("message sent to RabbiyMQ..... ");

    }

    @GetMapping("/fanout")
    public ResponseEntity<String> sendFanMesssage(@RequestParam ("message")String message){
        producer.sendFanMessage(message);
        return ResponseEntity.ok("Fanout It Is...><) ");

    }

    @GetMapping("/hello")
    private ResponseEntity<String> stringResponseEntity(){
        return ResponseEntity.ok("hello Kritika");
    }



}
