package com.yingzi.center.pi.kafka;

import com.yingzi.center.pi.mapper.PersonInformationMapper;
import com.yingzi.center.pi.model.PersonInformation;
import com.yingzi.center.pi.model.message.MemberResponse;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: yingzi-app-pi
 * @description: 处理消息
 * @author: BaoGuoQiang
 * @create: 2018-10-22 15:37
 **/
@Component
public class CaptainHandler implements MessageHandler<MemberResponse>{
    private static final Logger logger = YZLogManager.getLogger(CaptainHandler.class);
    @Resource
    private PersonInformationMapper informationMapper;

    @Override
    public void handler(String topic, MemberResponse response){
        PersonInformation information = new PersonInformation();
        information.setName(response.getName());
        information.setAge(response.getAge());
        information.setHobby(response.getHobby());
        informationMapper.insertSelective(information);
        logger.info("-+-+-+-+-+-+-+-+-+-已经保存你的信息！^-^");
    }
}