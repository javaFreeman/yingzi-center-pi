package com.yingzi.center.pi.kafka;

import com.yingzi.center.pi.common.TopicConstant;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.regex.Pattern;

/**
 * @program: yingzi-app-pi
 * @description: 消息接收
 * @author: BaoGuoQiang
 * @create: 2018-10-22 15:27
 **/
@Component
public class CaptainService {
    private static final Logger logger = YZLogManager.getLogger(CaptainService.class);
    @Autowired@Qualifier("externalKafkaConsumerFactory")
    private ConsumerFactory<String,String> consumerFactory;
    @Resource
    private CaptainListener captainListener;

    /**
     * 订阅成员的个人信息
     */
    @PostConstruct
    public void subscription(){
        logger.info("------start listen Member personal information-------");
        var containerProps = new ContainerProperties(Pattern.compile(TopicConstant.MEMBER2CAPTAIN));
        containerProps.setMessageListener(captainListener);
        var container = new KafkaMessageListenerContainer<>(consumerFactory,containerProps);
        container.start();
    }
}