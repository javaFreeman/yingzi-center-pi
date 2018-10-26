package com.yingzi.center.pi.kafka;

import com.google.gson.Gson;
import com.yingzi.center.pi.model.message.MemberResponse;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @program: yingzi-app-pi
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-22 15:34
 **/
@Component
public class CaptainListener implements MessageListener<String,String> {
    @Autowired
    private Gson gson;
    private static final Logger logger = YZLogManager.getLogger(CaptainListener.class);
    @Autowired
    private CaptainHandler captainHandler;

    @Override
    @KafkaListener(topics = {"zhisheng"})
    public void onMessage(ConsumerRecord<String,String> data){
        String topic = data.topic();
        String value = data.value();
        logger.info("---!!!!!!!!!!!!!!!!!!!!---Captain ack: the topic is {},value is {}", topic, value);
        MemberResponse informationResp = gson.fromJson(value,MemberResponse.class);
        try {
            captainHandler.handler(topic,informationResp);
        } catch (Exception e){
            logger.error("消息接收失败", e);
        }
    }
}