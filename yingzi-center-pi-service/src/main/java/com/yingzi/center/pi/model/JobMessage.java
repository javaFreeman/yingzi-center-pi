package com.yingzi.center.pi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author BigBao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobMessage {
    private Integer id;

    private Integer jobNumber;

    private String post;

    private String entryTime;

    private Integer standing;

    private String baseMoney;

    private String multiple;

    private Date gmtCreated;

    private Date gmtModified;

    private Integer isDeleted;
}