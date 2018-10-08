package com.yingzi.center.pi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: yingzi-app-pi
 * @description: 员工月度绩效
 * @author: BaoGuoQiang
 * @create: 2018-10-07 11:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("员工月度绩效")
public class MonthGradeVo {
    @ApiModelProperty(name = "id",value = "主键id，新增为null",example = "1",dataType = "int",notes = "新增为null")
    private Integer id;
    @ApiModelProperty(name = "jobNumber",value = "工号，对应person_information中的id",example = "3",dataType = "Integer",required = true)
    private Integer jobNumber;
    @ApiModelProperty(name = "year",value = "年份",example = "2018",dataType = "Integer")
    private Integer year;
    @ApiModelProperty(name = "month",value = "月份",example = "10",dataType = "Integer")
    private Integer month;
    @ApiModelProperty(name = "grade",value = "绩效，小数，0<=分数<=1",example = "0.9",dataType = "String",required = true)
    private String grade;
    @ApiModelProperty(name = "bonus",value = "奖金",example = "3000",dataType = "String")
    private String bonus;
}