package com.yingzi.center.pi.kafka;

import com.google.gson.Gson;
import com.yingzi.center.pi.common.TopicConstant;
import com.yingzi.center.pi.model.message.MemberResponse;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @program: yingzi-app-pi
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-24 09:42
 **/
@Component
public class MemberReportPeriodService {

    private static final Logger logger = YZLogManager.getLogger(MemberReportPeriodService.class);

    @Autowired
    CommandLogSender commandLogSender;
    @Autowired
    Gson gson;

    private int j = 0;
    @Scheduled(cron = "${schedule.member.report.period}")
    public void MemberReport(){
        logger.info("------report start!---------");
        MemberResponse response = new MemberResponse();
        if ( j < 3){
            for (int i = 0; i < 5; i++) {
                response.setMsgId(Long.toString(System.currentTimeMillis()));
                response.setMsgType(UUID.randomUUID().toString());
                response.setName("王大山");
                response.setAge(35);
                response.setHobby("climb");
                logger.info("-------send message: {}-------",gson.toJson(response));
                commandLogSender.send(TopicConstant.MEMBER2CAPTAINPERIOD, response);
            }
            j++;
        }
        logger.info("++++++Member report end!+++++++");
    }

}