package com.yingzi.center.pi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: yingzi-app-pi
 * @description: 员工工作信息
 * @author: BaoGuoQiang
 * @create: 2018-10-07 11:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("员工工作信息")
public class JobMessageVo {
    @ApiModelProperty(name = "id",value = "主键id，新增为null",example = "1",dataType = "int",notes = "新增为null")
    private Integer id;
    @ApiModelProperty(name = "jobNumber",value = "工号，对应person_information中的id--新增必传字段",example = "3",dataType = "Integer",required = true)
    private Integer jobNumber;
    @ApiModelProperty(name = "post",value = "岗位",example = "Java后端",dataType = "String")
    private String post;
    @ApiModelProperty(name = "entryTime",value = "入职时间",example = "20180920",dataType = "Date",required = true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date entryTime;
    @ApiModelProperty(name = "standing",value = "工龄，不满一年，向下取整",example = "3",dataType = "Integer")
    private Integer standing;
    @ApiModelProperty(name = "baseMoney",value = "基本工资",example = "5000",dataType = "String")
    private String baseMoney;
    @ApiModelProperty(name = "multiple",value = "薪资加成",example = "1.1",dataType = "String")
    private String multiple;
}