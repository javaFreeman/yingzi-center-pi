package com.yingzi.center.pi.gson;

import lombok.Data;

import java.util.List;

/**
 * @program: yingzi-app-pi
 * @description: 用于展示数组和列表的序列化
 * @author: BaoGuoQiang
 * @create: 2018-10-20 16:54
 **/
@Data
public class RestaurantWithMenu {
    String name;

    List<RestaurantMenuItem> menu;
    //RestaurantMenuItem[] menu; // alternative, either one is fine
}