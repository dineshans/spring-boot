package com.kafka.consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaMessageListener {

    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "javatechie-demo-6", groupId = "jt-group")
    public void consume1(String message){

        logger.info("Consumer1 " + message);

    }

    /* Multiple consumer assigned to a group id */

    @KafkaListener(topics = "javatechie-demo-6", groupId = "jt-group")
    public void consume2(String message){

        logger.info("Consumer2 " + message);

    }

    @KafkaListener(topics = "javatechie-demo-6", groupId = "jt-group")
    public void consume3(String message){

        logger.info("Consumer3 " + message);

    }

    @KafkaListener(topics = "javatechie-demo-6", groupId = "jt-group")
    public void consume4(String message){

        logger.info("Consumer4 " + message);

    }

}
