package com.kingdee.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午3:21
 */
@Getter
@Setter
public class AppRuleDto {
    @JsonProperty("begin_time")
    private String beginTime;
    @JsonProperty("end_time")
    private String endTime;
    @JsonProperty("position_cycle_time")
    private Integer positionCycleTime;
    @JsonProperty("upload_cycle_time")
    private Integer uploadCycleTime;
}
