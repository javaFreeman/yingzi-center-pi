package com.yingzi.center.pi.gson;

import lombok.Data;

/**
 * @program: yingzi-app-pi
 * @description: 用户住址信息
 * @author: BaoGuoQiang
 * @create: 2018-10-20 15:51
 **/
@Data
public class UserAddress {
    String street;
    String houseNumber;
    String city;
    String country;
}