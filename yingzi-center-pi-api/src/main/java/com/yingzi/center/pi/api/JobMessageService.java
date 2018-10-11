package com.yingzi.center.pi.api;

import com.yingzi.center.pi.vo.JobMessageVo;

import java.util.List;

/**
 * @author BaoGuoQiang
 */
public interface JobMessageService {
    /**
     * 新增员工工作信息
     * @param jobMessageVo
     * @return
     */
    JobMessageVo saveJob(JobMessageVo jobMessageVo);

    /**
     * 修改员工工作信息
     * @param jobMessageVo
     * @return
     */
    int updateJob(JobMessageVo jobMessageVo);

    /**
     * 获取员工工作信息
     * @param jobNumber
     * @return
     */
    List<JobMessageVo> getJob(Integer jobNumber);
}
