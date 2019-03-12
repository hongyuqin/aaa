package com.kingdee.attendance.dao.impl;

import com.kingdee.attendance.dao.TrajectoryPathDao;
import com.kingdee.attendance.pojo.TrajectoryPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午1:48
 */
@Slf4j
@Service
public class TrajectoryPathDaoImpl extends BaseDaoImpl<TrajectoryPath> implements TrajectoryPathDao {
    @Override
    public List<TrajectoryPath> find(String eid, LocalDateTime beginTime, LocalDateTime endTime, List<String> workNumList) {
        Query query = new Query();
        query.addCriteria(Criteria.where("eid").is(eid));
        query.addCriteria(new Criteria().andOperator(
                Criteria.where("positionTime").gte(beginTime),
                Criteria.where("positionTime").lte(endTime)));
        if (workNumList != null) {
            query.addCriteria(Criteria.where("workNum").in(workNumList));
        }
        return this.find(query);
    }
}
