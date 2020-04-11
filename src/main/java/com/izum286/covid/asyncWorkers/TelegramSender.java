package com.izum286.covid.asyncWorkers;

import org.springframework.kafka.annotation.KafkaListener;

public class TelegramSender implements NotificationSender{
    @KafkaListener(topics = "Telegram")
    @Override
    public void send(Object o) {

    }
}
