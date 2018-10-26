package com.yingzi.center.pi.kafka;

import com.google.gson.Gson;
import com.taobao.pandora.boot.test.junit4.DelegateTo;
import com.taobao.pandora.boot.test.junit4.PandoraBootRunner;
import com.yingzi.center.pi.HSFProviderApplication;
import com.yingzi.center.pi.model.message.MemberResponse;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @program: yingzi-app-pi
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-23 17:12
 **/
@RunWith(PandoraBootRunner.class)
@DelegateTo(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {HSFProviderApplication.class, ReceiveTest.class })
public class ReceiveTest {
    private static final Logger logger = YZLogManager.getLogger(SenderTest.class);

    @Resource
    CaptainHandler captainHandler;
    @Resource
    Gson gson;

    @Test
    public void onMessage(){
        String topic = "topic.Member2Captain.person";
        String value = "{\"msg_type\":\"0101\",\"msg_id\":\"0527\",\"status\":1,\"name\":\"海子\",\"age\":25,\"hobby\":\"poem\"}";
        logger.info("---!!!!!!!!!!!!!!!!!!!!---Captain ack: the topic is {},value is {}", topic, value);
        MemberResponse informationResp = gson.fromJson(value,MemberResponse.class);
        try {
            captainHandler.handler(topic,informationResp);
        } catch (Exception e){
            logger.error("消息接收失败", e);
        }
    }
}