package com.yingzi.center.pi.api;

import com.yingzi.center.pi.vo.PersonInformationVo;

/**
 * @author BaoGuoQiang
 */
public interface PersonInformationService {
    /**
     * 保存员工个人信息
     * @param personInformationVo
     * @return PersonInformationVo
     */
    PersonInformationVo savePerson(PersonInformationVo personInformationVo);
}
