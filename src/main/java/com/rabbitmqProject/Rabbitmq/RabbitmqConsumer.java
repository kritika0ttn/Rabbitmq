package com.rabbitmqProject.Rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitmqConsumer.class);

    @RabbitListener(queues="${rabbitmq.queue.name}")
    public  void consume(String message){
        LOGGER.info(String.format("Received message-> %s", message));

    }

    @RabbitListener(queues={"${rabbitmq.queue1.name}","${rabbitmq.queue2.name}","${rabbitmq.queue3.name}"})
    public  void consumeFanQ(String message){
        LOGGER.info(String.format("Received message-> %s", message));

    }
//
//    @RabbitListener(queues="${rabbitmq.queue1.a}")
//    public  void consumeFadnQ(String message){
//        LOGGER.info(String.format("Received message-> %s", message));
//
//    }

}
