package com.rabbitmqProject.Rabbitmq;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RabbitmqConfig {
    @Value("${rabbitmq.routing.key}")
    private String key;

    @Value("${rabbitmq.topic.exchange.name}")
    private String topicExchange;
    @Value("${rabbitmq.fanout.exchange.name}")
    private String fanoutExchange;

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.queue1.name}")
    private String queue1;


    @Value("${rabbitmq.queue2.name}")
    private String queue2;


    @Value("${rabbitmq.queue3.name}")
    private String queue3;


    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(topicExchange);
    }


    // binding btw queue and exchange using routing key
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange())
                .with(key);
    }


    //FANOUT-EXCHANGE



    @Bean
    public Queue queue1(){
        return new Queue(queue1);
    }

    @Bean
    public Queue queue2(){
        return new Queue(queue2);
    }

    @Bean
    public Queue queue3(){
        return new Queue(queue3);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(fanoutExchange);
    }

//    @Bean
//    public List<Binding> fanoutBinding() {
//
//        List<Binding> bindingList = new ArrayList<>();
//
//        bindingList.add(BindingBuilder.bind(queue1()).to(fanoutExchange()));
//        bindingList.add(BindingBuilder.bind(queue2()).to(fanoutExchange()));
//        bindingList.add(BindingBuilder.bind(queue3()).to(fanoutExchange()));
//
//        return bindingList;
//    }

    @Bean
    public Binding fanoutBiding(){
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }
    @Bean
    public Binding fanoutBidingB(){
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }
    @Bean
    public Binding fanoutBidingC(){
        return BindingBuilder.bind(queue3()).to(fanoutExchange());
    }


}
