package com.yingzi.center.pi.gson;

import lombok.Data;

/**
 * @program: yingzi-app-pi
 * @description: 利用Gson的Serialization功能，将一个Java对象映射为相应的JSON表达方式
 * @author: BaoGuoQiang
 * @create: 2018-10-20 15:17
 **/
@Data
public class UserSimple {
    String name;
    String email;
    int age;
    boolean isDeveloper;
}