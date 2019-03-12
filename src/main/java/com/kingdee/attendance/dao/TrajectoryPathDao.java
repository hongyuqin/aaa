package com.kingdee.attendance.dao;

import com.kingdee.attendance.dao.BaseDao;
import com.kingdee.attendance.pojo.TrajectoryPath;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午1:47
 */
public interface TrajectoryPathDao  extends BaseDao<TrajectoryPath> {

    List<TrajectoryPath> find(String eid, LocalDateTime beginTime,LocalDateTime endTime, List<String> workNumList);

}
