package com.izum286.covid.asyncWorkers;

import org.springframework.kafka.annotation.KafkaListener;

public class MailSender implements NotificationSender {
    @KafkaListener(topics = "Mail")
    @Override
    public void send(Object o) {

    }
}
