package com.yingzi.center.pi.gson;

import lombok.Data;

/**
 * @program: yingzi-app-pi
 * @description: 用于展示嵌套结构的反序列化
 * @author: BaoGuoQiang
 * @create: 2018-10-20 16:24
 **/
@Data
public class Hotel {
    String name;
    HotelOwner owner;
    HotelStaff cook;
    HotelStaff waiter;
}