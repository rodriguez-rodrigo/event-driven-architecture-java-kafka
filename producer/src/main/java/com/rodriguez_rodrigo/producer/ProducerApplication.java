package com.rodriguez_rodrigo.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@KafkaListener(id="ProducerConsumer", topics = "producer-connector.public.outbox_events")
	public void listen(String message) {
		System.out.println("Received Message in group ProducerConsumer: " + message);
	}

}
