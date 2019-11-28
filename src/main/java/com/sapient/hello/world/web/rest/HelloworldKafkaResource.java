package com.sapient.hello.world.web.rest;

import com.sapient.hello.world.service.HelloworldKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/helloworld-kafka")
public class HelloworldKafkaResource {

    private final Logger log = LoggerFactory.getLogger(HelloworldKafkaResource.class);

    private HelloworldKafkaProducer kafkaProducer;

    public HelloworldKafkaResource(HelloworldKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
