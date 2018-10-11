package com.yingzi.center.pi.api;

import com.yingzi.center.pi.vo.MonthGradeVo;

/**
 * @program: yingzi-app-pi
 * @description: 员工月度绩效
 * @author: BaoGuoQiang
 * @create: 2018-10-10 10:51
 **/

public interface MonthGradeService {
    MonthGradeVo addGrade(MonthGradeVo monthGradeVo);
}