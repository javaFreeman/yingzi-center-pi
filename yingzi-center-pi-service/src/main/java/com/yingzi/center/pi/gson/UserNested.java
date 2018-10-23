package com.yingzi.center.pi.gson;

import lombok.Data;

/**
 * @program: yingzi-app-pi
 * @description: 用户个人信息和住址对象，用于展示嵌套对象的序列化和反序列化
 * @author: BaoGuoQiang
 * @create: 2018-10-20 15:54
 **/
@Data
public class UserNested {
    String name;
    String email;
    boolean isDeveloper;
    int age;

    /**
     * 住址对象
     */
    UserAddress userAddress;
}