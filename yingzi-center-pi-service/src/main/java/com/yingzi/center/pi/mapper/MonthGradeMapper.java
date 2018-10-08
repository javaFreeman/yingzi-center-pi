package com.yingzi.center.pi.mapper;

import com.yingzi.center.pi.model.MonthGrade;
/**
 * 员工月度绩效
 * @author baoguoqiang
 */
public interface MonthGradeMapper {
    /**
     * 根据id删除员工月度绩效
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增员工月度绩效
     * @param record
     * @return
     */
    int insert(MonthGrade record);
    /**
     * 字段不为null时新增员工月度绩效
     * @param record
     * @return
     */
    int insertSelective(MonthGrade record);
    /**
     * 根据id查询员工月度绩效
     * @param id
     * @return
     */
    MonthGrade selectByPrimaryKey(Integer id);
    /**
     * 字段不为null时，根据id新增员工月度绩效
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MonthGrade record);
    /**
     * 根据id新增员工月度绩效
     * @param record
     * @return
     */
    int updateByPrimaryKey(MonthGrade record);
}