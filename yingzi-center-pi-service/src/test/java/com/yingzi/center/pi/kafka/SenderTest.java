package com.yingzi.center.pi.kafka;

import com.taobao.pandora.boot.test.junit4.DelegateTo;
import com.taobao.pandora.boot.test.junit4.PandoraBootRunner;
import com.yingzi.center.pi.HSFProviderApplication;
import com.yingzi.center.pi.common.TopicConstant;
import com.yingzi.center.pi.model.message.MemberResponse;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.MessageFormat;

/**
 * @program: yingzi-app-pi
 * @description: 发消息测试
 * @author: BaoGuoQiang
 * @create: 2018-10-22 17:31
 **/
@RunWith(PandoraBootRunner.class)
@DelegateTo(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {HSFProviderApplication.class, SenderTest.class })
public class SenderTest {
    private static final Logger logger = YZLogManager.getLogger(SenderTest.class);

    @Autowired
    CommandLogSender commandLogSender;

    @Test
    public void handler(){
        MemberResponse memberResponse = new MemberResponse();
        memberResponse.setMsgType("0101");
        memberResponse.setStatus(0);
        memberResponse.setMsgId("0527");
        memberResponse.setName("海子");
        memberResponse.setAge(25);
        memberResponse.setHobby("poem");
        commandLogSender.send(TopicConstant.MEMBER2CAPTAIN,memberResponse);
    }
}