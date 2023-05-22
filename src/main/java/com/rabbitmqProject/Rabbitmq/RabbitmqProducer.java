package com.rabbitmqProject.Rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqProducer {

    @Value("${rabbitmq.fanout.exchange.name}")
    private String fanoutExchange;

    @Value("${rabbitmq.topic.exchange.name}")
    private String topicExchange;
    @Value("${rabbitmq.routing.key}")
    private String key;

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitmqProducer.class);
    private RabbitTemplate rabbitTemplate;

    public RabbitmqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s", message));
        rabbitTemplate.convertAndSend(topicExchange,key,message);
    }

    public void sendFanMessage(String message){
        LOGGER.info(String.format("message show : %s ", message));
        rabbitTemplate.convertAndSend(fanoutExchange,"",message);
    }

}
