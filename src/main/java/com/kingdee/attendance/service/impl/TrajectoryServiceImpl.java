package com.kingdee.attendance.service.impl;

import com.alibaba.fastjson.JSON;
import com.kingdee.attendance.dao.TrajectoryPathDao;
import com.kingdee.attendance.dao.TrajectoryRuleDao;
import com.kingdee.attendance.dto.*;
import com.kingdee.attendance.exception.TrajectoryException;
import com.kingdee.attendance.pojo.TrajectoryPath;
import com.kingdee.attendance.pojo.TrajectoryRule;
import com.kingdee.attendance.service.TrajectoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午2:02
 */
@Slf4j
@Service
public class TrajectoryServiceImpl implements TrajectoryService{

    public static final int CREATE = 0;
    public static final int UPDATE = 1;
    public static final int DELETE = 2;
    @Autowired
    private TrajectoryRuleDao trajectoryRuleDao;
    @Autowired
    private TrajectoryPathDao trajectoryPathDao;
    @Override
    public void setRule(RuleDto ruleDto) {
        log.info("set Rule :{}", JSON.toJSONString(ruleDto));
        //1.删除
        if (ruleDto.getOperate() == DELETE) {
            trajectoryRuleDao.delete(ruleDto.getEid(),ruleDto.getWorkNum(),ruleDto.getDate());
            return;
        }
        if (ruleDto.getOperate() == UPDATE) {
            TrajectoryRule rule = trajectoryRuleDao.getOneRule(ruleDto.getEid(), ruleDto.getWorkNum(), ruleDto.getDate());
            if (rule == null) {
                throw new TrajectoryException(500, "该记录不存在");
            }
            rule.setOnOff(ruleDto.isOnOff());
            rule.setBeginTime(ruleDto.getBeginTime());
            rule.setEndTime(ruleDto.getEndTime());
            rule.setPositionCycleTime(ruleDto.getPositionCycleTime());
            rule.setUploadCycleTime(ruleDto.getUploadCycleTime());
            rule.setUpdateTime(LocalDateTime.now());
            trajectoryRuleDao.save(rule);
            return;
        }
        if (ruleDto.getOperate() == CREATE) {
            TrajectoryRule oldRule = trajectoryRuleDao.getOneRule(ruleDto.getEid(), ruleDto.getWorkNum(), ruleDto.getDate());
            TrajectoryRule rule = new TrajectoryRule();
            if (oldRule != null) {
                rule.setId(oldRule.getId());
            }
            rule.setEid(ruleDto.getEid());
            rule.setOid(ruleDto.getOid());
            rule.setWorkNum(ruleDto.getWorkNum());
            rule.setDate(ruleDto.getDate());
            rule.setOnOff(ruleDto.isOnOff());
            rule.setBeginTime(ruleDto.getBeginTime());
            rule.setEndTime(ruleDto.getEndTime());
            rule.setPositionCycleTime(ruleDto.getPositionCycleTime());
            rule.setUploadCycleTime(ruleDto.getUploadCycleTime());
            rule.setUpdateTime(LocalDateTime.now());
            trajectoryRuleDao.save(rule);
        }
        return;
    }

    @Override
    public AppRuleDto appGetRule(String eid, String oid) {
        log.info("appGetRule :{},{}", eid, oid);
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(formatter);
        TrajectoryRule rule = trajectoryRuleDao.getOneRule(eid, oid, date);
        if (rule == null || !rule.isOnOff()) {
            return null;
        }
        AppRuleDto dto = new AppRuleDto();
        dto.setBeginTime(rule.getBeginTime());
        dto.setEndTime(rule.getEndTime());
        dto.setPositionCycleTime(rule.getPositionCycleTime());
        dto.setUploadCycleTime(rule.getUploadCycleTime());
        return dto;
    }

    @Override
    public List<TrajectoryRule> customGetRule(CustomGetRuleDto dto) {
        return trajectoryRuleDao.find(dto.getDate(), dto.getWorkNumList());
    }

    @Override
    public void uploadPath(TrajectoryPathDto dto) {
        TrajectoryPath path = new TrajectoryPath();
        path.setCreateTime(LocalDateTime.now());
        path.setWorkNum(dto.getWorkNum());
        path.setAddress(dto.getAddress());
        path.setEid(dto.getEid());
        path.setOid(dto.getOid());
        path.setLatitude(dto.getLatitude());
        path.setLongtitude(dto.getLongtitude());
        path.setRemark(dto.getRemark());
        LocalDateTime positionTime = LocalDateTime.parse(dto.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        path.setTime(dto.getTime());
        path.setPositionTime(positionTime);
        trajectoryPathDao.save(path);
    }

    @Override
    public List<TrajectoryPath> customGetPath(CustomGetPathDto dto) {
        log.info("customGetPath  :{}", JSON.toJSONString(dto));
        String beginTimeStr = dto.getBeginTime();
        String endTimeStr = dto.getEndTime();
        LocalDateTime beginTime = LocalDateTime.parse(beginTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        List<TrajectoryPath> paths = trajectoryPathDao.find(dto.getEid(), beginTime, endTime, dto.getWorkNumList());
        return paths;
    }

}
