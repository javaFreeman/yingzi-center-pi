package com.yingzi.center.pi.service.impl;

import com.alibaba.boot.hsf.annotation.HSFProvider;
import com.yingzi.center.pi.api.JobMessageService;
import com.yingzi.center.pi.mapper.JobMessageMapper;
import com.yingzi.center.pi.model.JobMessage;
import com.yingzi.center.pi.vo.JobMessageVo;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: yingzi-app-pi
 * @description: 员工工作信息
 * @author: BaoGuoQiang
 * @create: 2018-10-07 16:46
 **/
//@Service("jobMessageServiceImpl")
@HSFProvider(serviceInterface = JobMessageService.class, serviceVersion = "${spring.hsf.pi.version:1.0.0}", serviceGroup = "${spring.hsf.pi.serviceGroup:HSF}")
public class JobMessageServiceImpl implements JobMessageService {
    private static final Logger logger = YZLogManager.getLogger(JobMessageService.class);

    @Resource
    JobMessageMapper jobMessageMapper;

    @Override
    public JobMessageVo saveJob(JobMessageVo jobMessageVo){
        JobMessage jobMessage = new JobMessage();
        BeanUtils.copyProperties(jobMessageVo,jobMessage);
        jobMessageMapper.insertSelective(jobMessage);
        return jobMessageVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateJob(JobMessageVo jobMessageVo){
        JobMessage jobMessage = new JobMessage();
        BeanUtils.copyProperties(jobMessageVo,jobMessage);
        return jobMessageMapper.updateByPrimaryKeySelective(jobMessage);
    }

    @Override
    public List<JobMessageVo> getJob(Integer jobNumber){
        try {
            List<JobMessageVo> jobMessageVos = jobMessageMapper.selectByJobNumber(jobNumber);
            return jobMessageVos;
        } catch (Exception e){
            logger.error("查询失败",e);
            return new ArrayList<>();
        }
    }
}