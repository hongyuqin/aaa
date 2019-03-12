package com.kingdee.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午1:51
 */
@Getter
@Setter
public class RuleDto {
    @JsonProperty("work_num")
    private String workNum;
    private String eid;
    private String oid;
    @JsonProperty("on_off")
    private boolean onOff;
    private String date;
    @JsonProperty("begin_time")
    private String beginTime;
    @JsonProperty("end_time")
    private String endTime;
    @JsonProperty("position_cycle_time")
    private Integer positionCycleTime;
    @JsonProperty("upload_cycle_time")
    private Integer uploadCycleTime;
    private int operate;//操作
}
