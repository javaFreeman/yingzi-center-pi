package com.yingzi.center.pi.service.impl;

import com.alibaba.boot.hsf.annotation.HSFProvider;
import com.yingzi.center.pi.api.PersonInformationService;
import com.yingzi.center.pi.mapper.PersonInformationMapper;
import com.yingzi.center.pi.model.PersonInformation;
import com.yingzi.center.pi.vo.PersonInformationVo;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @program: yingzi-app-pi
 * @description: 员工个人信息
 * @author: BaoGuoQiang
 * @create: 2018-10-07 15:15
 **/
@HSFProvider(serviceInterface = PersonInformationService.class, serviceVersion = "${spring.hsf.pi.version:1.0.0}", serviceGroup = "${spring.hsf.pi.serviceGroup:HSF}")
public class PersonInformationServiceImpl implements PersonInformationService {
    private static final Logger logger = YZLogManager.getLogger(PersonInformationService.class);

    @Resource
    PersonInformationMapper personInformationMapper;

    @Override
    public PersonInformationVo savePerson(PersonInformationVo personInformationVo){
        PersonInformation personInformation = new PersonInformation();
        BeanUtils.copyProperties(personInformationVo, personInformation);
        personInformationMapper.insertSelective(personInformation);
        personInformationVo.setId(personInformation.getId());
        return personInformationVo;
    }
}