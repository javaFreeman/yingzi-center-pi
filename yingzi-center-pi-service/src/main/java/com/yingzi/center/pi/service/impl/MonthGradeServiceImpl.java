package com.yingzi.center.pi.service.impl;

import com.alibaba.boot.hsf.annotation.HSFProvider;
import com.yingzi.center.pi.api.JobMessageService;
import com.yingzi.center.pi.api.MonthGradeService;
import com.yingzi.center.pi.mapper.MonthGradeMapper;
import com.yingzi.center.pi.model.MonthGrade;
import com.yingzi.center.pi.vo.JobMessageVo;
import com.yingzi.center.pi.vo.MonthGradeVo;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * @program: yingzi-app-pi
 * @description: 员工月度绩效实现
 * @author: BaoGuoQiang
 * @create: 2018-10-10 10:53
 **/
@HSFProvider(serviceInterface = MonthGradeService.class, serviceVersion = "${spring.hsf.pi.version:1.0.0}", serviceGroup = "${spring.hsf.pi.serviceGroup:HSF}")
public class MonthGradeServiceImpl implements MonthGradeService{
    private static final Logger logger = YZLogManager.getLogger(MonthGradeService.class);

    @Resource
    MonthGradeMapper monthGradeMapper;

    @Resource
    JobMessageService jobMessageService;

    @Override
    public MonthGradeVo addGrade(MonthGradeVo monthGradeVo){
        MonthGrade monthGrade = new MonthGrade();
        BeanUtils.copyProperties(monthGradeVo,monthGrade);
        Double bonus = Double.parseDouble(monthGradeVo.getBonus());
        List<JobMessageVo> jobMessageVos = jobMessageService.getJob(monthGradeVo.getJobNumber());
        Double money = 0.0;
        Double total = 0.0;
        for (int i = 0;i<jobMessageVos.size();i++){
            JobMessageVo messageVo =jobMessageVos.get(i);
            Double baseMoney = Double.parseDouble(messageVo.getBaseMoney());
            Double multiply =  Double.parseDouble(messageVo.getMultiple());
            String grade = monthGradeVo.getGrade();
            Double dGrade = Double.parseDouble(grade);
            money = baseMoney*multiply*dGrade;
            total +=money;
        }
        monthGrade.setMoney(String.valueOf(total+bonus));
        Calendar now = Calendar.getInstance();
        monthGrade.setYear(now.get(Calendar.YEAR));
        monthGrade.setMonth(now.get(Calendar.MONTH));
        /*List<Double> receiveMoney = jobMessageVos.forEach(money ->{
            Double baseMoney = Double.parseDouble(money.getBaseMoney());
            Double multiply =  Double.parseDouble(money.getMultiple());
            Double afterMoney = baseMoney*multiply;
            money.setBaseMoney(afterMoney.toString());
            JobMessageVo messageVo = new JobMessageVo();
            return messageVo ;
        } );*/
        monthGradeMapper.insertSelective(monthGrade);
        return monthGradeVo;
    }

}