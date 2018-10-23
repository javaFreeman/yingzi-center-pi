package com.yingzi.center.pi.model.message;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * @program: yingzi-app-pi
 * @description: 回答的消息实体
 * @author: BaoGuoQiang
 * @create: 2018-10-22 15:45
 **/
@Data
public class MemberResponse {
    @SerializedName("msg_type")
    protected String msgType;
    @SerializedName("msg_id")
    protected String msgId;

    @SerializedName("status")
    protected Integer status;

    @SerializedName("name")
    protected String name;

    @SerializedName("age")
    protected int age;

    @SerializedName("hobby")
    protected String hobby;

}