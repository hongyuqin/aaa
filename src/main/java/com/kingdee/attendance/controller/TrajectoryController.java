package com.kingdee.attendance.controller;

import com.kingdee.attendance.dto.*;
import com.kingdee.attendance.exception.TrajectoryException;
import com.kingdee.attendance.service.TrajectoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午3:44
 */
@Controller
@RequestMapping("/trajectory/")
@Slf4j
public class TrajectoryController {
    @Autowired
    private TrajectoryService trajectoryService;

    @PostMapping("setRule")
    @ResponseBody
    public APIResponseJson setRule(@RequestBody RuleDto ruleDto) {
        try {
            trajectoryService.setRule(ruleDto);
        } catch (TrajectoryException e) {
            return APIResponseJson.error(e.getErrorCode(), e.getErrorMsg());
        } catch (Exception e) {
            log.error("setRule unknown :",e);
            return APIResponseJson.error(500, "未知异常");
        }
        return APIResponseJson.success();
    }

    @PostMapping("appGetRule")
    @ResponseBody
    public APIResponseJson appGetRule(@RequestBody AppGetRuleDto appGetRuleDto) {
        AppRuleDto appRuleDto = trajectoryService.appGetRule(appGetRuleDto.getEid(),appGetRuleDto.getOid());
        return APIResponseJson.success(appRuleDto);
    }

    @PostMapping("customGetRule")
    @ResponseBody
    public APIResponseJson customGetRule(@RequestBody CustomGetRuleDto customGetRuleDto) {
        return APIResponseJson.success(trajectoryService.customGetRule(customGetRuleDto));
    }

    @PostMapping("uploadPath")
    @ResponseBody
    public APIResponseJson uploadPath(@RequestBody TrajectoryPathDto trajectoryPathDto) {
        trajectoryService.uploadPath(trajectoryPathDto);
        return APIResponseJson.success();
    }

    @PostMapping("customGetPath")
    @ResponseBody
    public APIResponseJson customGetPath(@RequestBody CustomGetPathDto dto) {
        return APIResponseJson.success(trajectoryService.customGetPath(dto));
    }
}
