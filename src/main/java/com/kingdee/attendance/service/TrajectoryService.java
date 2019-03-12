package com.kingdee.attendance.service;

import com.kingdee.attendance.dto.*;
import com.kingdee.attendance.pojo.TrajectoryPath;
import com.kingdee.attendance.pojo.TrajectoryRule;

import java.util.List;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午1:54
 */
public interface TrajectoryService {
    /**
     * 客户设置规则  有问题直接抛异常
     * @param ruleDto
     */
    void setRule(RuleDto ruleDto);

    AppRuleDto appGetRule(String eid, String oid);

    List<TrajectoryRule> customGetRule(CustomGetRuleDto dto);

    void uploadPath(TrajectoryPathDto dto);

    List<TrajectoryPath> customGetPath(CustomGetPathDto dto);
}
