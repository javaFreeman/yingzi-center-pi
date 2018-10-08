package com.yingzi.center.pi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author BigBao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInformation {
    private Integer id;

    private String name;

    private Integer age;

    private BigDecimal height;

    private BigDecimal weight;

    private String hobby;

    private Date gmtCreated;

    private Date gmtModified;

    private Integer isDeleted;
}