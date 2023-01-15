package com.wizeline.onsite.services;

import com.wizeline.onsite.events.Event;
import com.wizeline.onsite.events.EventType;
import com.wizeline.onsite.events.UsuarioCreatedEvent;
import com.wizeline.onsite.models.UsuarioModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class UsuarioEventsService {

    private static Logger log = LoggerFactory.getLogger(UsuarioEventsService.class);
    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.customer.name:customers}")
    private String topicCustomer;

    public void publish(UsuarioModel usuario) {

        UsuarioCreatedEvent created = new UsuarioCreatedEvent();
        created.setData(usuario);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCustomer, String.valueOf(234),created);
    }


    @KafkaListener(
            topics = "${topic.customer.name:customers}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(UsuarioCreatedEvent.class)) {
            UsuarioCreatedEvent customerCreatedEvent = (UsuarioCreatedEvent) event;
            log.info("Received Customer created event .... with Id={}, data={}",
                    customerCreatedEvent.getId(),
                    customerCreatedEvent.getData().toString());
        }

    }
}
