package com.yingzi.center.pi.kafka;

import com.google.gson.Gson;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @program: yingzi-app-pi
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-22 15:56
 **/
@Component
public class CommandLogSender {
    @Autowired@Qualifier("internalKafkaTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private Gson gson;
    private static final Logger logger = YZLogManager.getLogger(CommandLogSender.class);
    /**
     * 将发送obj转换为json发送
     * @param topic
     * @param message
     */
    public void send(String topic, Object message) {
        try {
            logger.info("the message is: {}", gson.toJson(message));
            var future = kafkaTemplate.send(topic, gson.toJson(message));
            future.addCallback(consoleLog);
        } catch (Exception e) {
            logger.error("context", e);
        }
    }
    private final ListenableFutureCallback<? super SendResult<String, String>> consoleLog = new ListenableFutureCallback<SendResult<String, String>>() {
        @Override
        public void onFailure(Throwable ex) {
            logger.error("context", ex);
        }
        @Override
        @Transactional
        public void onSuccess(SendResult<String, String> result) {
            logger.info("send result is: {}", gson.toJson(result));
        }
    };

}