package com.yingzi.center.pi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: yingzi-app-pi
 * @description: 员工个人信息
 * @author: BaoGuoQiang
 * @create: 2018-10-07 11:20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("员工个人信息")
public class PersonInformationVo {
    @ApiModelProperty(name = "id",value = "主键id，新增为null",example = "1",dataType = "int",notes = "新增为null")
    private Integer id;
    @ApiModelProperty(name = "name",value = "姓名",example = "章子怡",dataType = "String",required = true)
    private String name;
    @ApiModelProperty(name = "age",value = "年龄",example = "26",dataType = "Integer")
    private Integer age;
    @ApiModelProperty(name = "height",value = "身高，单位m",example = "1.81",dataType = "BigDecimal")
    private BigDecimal height;
    @ApiModelProperty(name = "weight",value = "体重,单位kg",example = "67",dataType = "BigDecimal")
    private BigDecimal weight;
    @ApiModelProperty(name = "hobby",value = "爱好",example = "program",dataType = "String")
    private String hobby;
}