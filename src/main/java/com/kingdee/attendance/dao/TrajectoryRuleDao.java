package com.kingdee.attendance.dao;

import com.kingdee.attendance.pojo.TrajectoryRule;

import java.util.List;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午1:42
 */
public interface TrajectoryRuleDao extends BaseDao<TrajectoryRule> {

    void delete(String eid, String workNum, String date);

    List<TrajectoryRule> find(String date, List<String> workNumList);

    TrajectoryRule getOneRule(String eid, String oid, String date);
}
