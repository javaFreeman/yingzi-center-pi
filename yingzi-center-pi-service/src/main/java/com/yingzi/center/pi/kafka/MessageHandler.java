package com.yingzi.center.pi.kafka;

public interface MessageHandler<T> {
    void handler(String topic, T resp) throws Exception;
}