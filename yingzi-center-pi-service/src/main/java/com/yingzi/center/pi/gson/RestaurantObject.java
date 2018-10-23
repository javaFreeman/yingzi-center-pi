package com.yingzi.center.pi.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: yingzi-app-pi
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-20 16:57
 **/

public class RestaurantObject {
    public static void main(String[] args){
        //Arrays或者Lists数据的序列化
        List<RestaurantMenuItem> menuItems = new ArrayList<>();
        RestaurantMenuItem menuItem = new RestaurantMenuItem();
        menuItem.setDescription("Spaghetti");
        menuItem.setPrice(7.99f);
        menuItems.add(menuItem);

        menuItem.setDescription("Steak");
        menuItem.setPrice(12.99f);
        menuItems.add(menuItem);

        menuItem.setDescription("Salad");
        menuItem.setPrice(5.99f);
        menuItems.add(menuItem);

        RestaurantWithMenu restaurantWithMenu = new RestaurantWithMenu();
        restaurantWithMenu.setName("Future Studio Steak House");
        restaurantWithMenu.setMenu(menuItems);

        Gson gson = new Gson();
        String restaurantJson = gson.toJson(restaurantWithMenu);
        System.out.println(restaurantJson);

        //Arrays或者Lists数据的反序列化
        String founderJson = "[{'name': 'Christian','flowerCount': 1}, {'name': 'Marcus', 'flowerCount': 3}, {'name': 'Norman', 'flowerCount': 2}]";
        Gson gson2 = new Gson();
        Founder[] founderArray = gson2.fromJson(founderJson, Founder[].class);
        /**
         * 你不能直接传递List<Founder>给Gson。
         * 为了使Gson知道List的准确结构，你需要得到它的Type。
         * Gson有一个TypeToken类帮助你正确找到任何类的Type。
         * 我们的Founder类在一个ArrayList中
         */
        Type founderListType = new TypeToken<ArrayList<Founder>>(){}.getType();
        List<Founder> founderList = gson.fromJson(founderJson, founderListType);
    }
}