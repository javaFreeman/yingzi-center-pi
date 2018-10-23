package com.yingzi.center.pi.gson;

import com.google.gson.Gson;

/**
 * @program: yingzi-app-pi
 * @description: 嵌套结构的反序列化
 * @author: BaoGuoQiang
 * @create: 2018-10-20 16:31
 **/

public class HotelObject {
    public static void main(String[] args){
        String hotelJson = "{ 'name':'Future Studio Steak House', " +
                "'owner':{ 'name':'Christian', 'address':{ 'city':'Magdeburg', 'country':'Germany', 'houseNumber':'42', 'street':'Main Street'}}," +
                "'cook':{ 'age':18, 'name': 'Marcus', 'salary': 1500 }, " +
                "'waiter':{ 'age':18, 'name': 'Norman', 'salary': 1000}}";
        Gson gson1 = new Gson();
        Hotel hotelObject = gson1.fromJson(hotelJson,Hotel.class);
    }
}