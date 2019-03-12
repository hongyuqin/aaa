package com.kingdee.attendance.dao.impl;

import com.kingdee.attendance.dao.TrajectoryRuleDao;
import com.kingdee.attendance.pojo.TrajectoryRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午1:42
 */
@Slf4j
@Service
public class TrajectoryRuleDaoImpl extends BaseDaoImpl<TrajectoryRule> implements TrajectoryRuleDao {
    @Override
    public void delete(String eid, String workNum, String date) {
        Query query = new Query();
        query.addCriteria(Criteria.where("eid").is(eid));
        query.addCriteria(Criteria.where("workNum").is(workNum));
        query.addCriteria(Criteria.where("date").is(date));
        this.delete(query);
    }

    @Override
    public List<TrajectoryRule> find(String date, List<String> workNumList) {
        Query query = new Query();
        query.addCriteria(Criteria.where("date").is(date));
        if(workNumList!=null) {
            query.addCriteria(Criteria.where("workNum").in(workNumList));
        }
        return this.find(query);
    }

    @Override
    public TrajectoryRule getOneRule(String eid, String oid, String date) {
        Map<String, Object> map = new HashMap<>();
        map.put("eid", eid);
        map.put("date", date);
        map.put("oid", oid);
        return this.findOne(map);
    }
}
