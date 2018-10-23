package com.yingzi.center.pi.gson;

import com.google.gson.Gson;

/**
 * @program: yingzi-app-pi
 * @description: 为用户创建一个Java对象
 * @author: BaoGuoQiang
 * @create: 2018-10-20 15:22
 **/

public class UserObject {
    public static void main(String[] args){
        //基本的Java-JSON序列化
        UserSimple userSimple = new UserSimple();
        userSimple.setName("BigBao");
        userSimple.setEmail("222@qq.com");
        userSimple.setAge(13);
        userSimple.setDeveloper(true);
        Gson gson = new Gson();
        String userJson = gson.toJson(userSimple);
        System.out.println(userJson);

        //基本的JSON-Java反序列化
        String samJson = "{'age':26,'email':'norman@futurestud.io','isDeveloper':true,'name':'Norman'}";
        Gson gson2 = new Gson();
        UserSimple userSimple2 = gson2.fromJson(samJson,UserSimple.class);

        //嵌套对象的Java-JSON序列化
        UserAddress userAddress = new UserAddress();
        userAddress.setCountry("China");
        userAddress.setCity("Guangzhou");
        userAddress.setStreet("guangzhou Avenue");
        userAddress.setHouseNumber("22B");
        UserNested userNested = new UserNested();
        userNested.setName("张大林");
        userNested.setAge(18);
        userNested.setEmail("dadada@163.com");
        userNested.setDeveloper(false);
        userNested.setUserAddress(userAddress);
        Gson gson3 = new Gson();
        String userNestedJson = gson3.toJson(userNested);
        System.out.println(userNestedJson);
    }


}