package com.yingzi.center.pi.gson;

import lombok.Data;

import java.util.List;

/**
 * @program: yingzi-app-pi
 * @description: 反序列化一个嵌套在一个对象中的列表
 * @author: BaoGuoQiang
 * @create: 2018-10-20 17:33
 **/
@Data
public class FounderGeneralInfo {
    String name;
    String website;
    List<Founder> founders;
}