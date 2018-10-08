package com.yingzi.center.pi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author BigBao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthGrade {
    private Integer id;

    private Integer jobNumber;

    private Integer year;

    private Integer month;

    private String grade;

    private String money;

    private Date gmtCreated;

    private Date gmtModified;

    private Integer isDeleted;
}