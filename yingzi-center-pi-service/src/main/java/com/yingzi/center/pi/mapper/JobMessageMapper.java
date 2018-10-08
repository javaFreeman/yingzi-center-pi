package com.yingzi.center.pi.mapper;

import com.yingzi.center.pi.model.JobMessage;
import com.yingzi.center.pi.vo.JobMessageVo;

import java.util.List;

/**
 * 员工工作信息
 * @author baoguoqiang
 */
public interface JobMessageMapper {
    /**
     * 根据id删除员工工作信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增员工工作信息
     * @param record
     * @return
     */
    int insert(JobMessage record);
    /**
     * 字段不为null时新增员工工作信息
     * @param record
     * @return
     */
    int insertSelective(JobMessage record);
    /**
     * 根据id查询员工工作信息
     * @param id
     * @return
     */
    JobMessage selectByPrimaryKey(Integer id);
    /**
     * 字段不为null时，根据id新增员工工作信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(JobMessage record);
    /**
     * 根据id新增员工工作信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(JobMessage record);

    /**
     * 根据工号查询员工工作信息
     * @param jobNumber
     * @return List<JobMessageVo>
     */
    List<JobMessageVo> selectByJobNumber(Integer jobNumber);
}