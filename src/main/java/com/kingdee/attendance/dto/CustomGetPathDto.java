package com.kingdee.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午8:08
 */
@Getter
@Setter
public class CustomGetPathDto {
    @JsonProperty("begin_time")
    private String beginTime;
    @JsonProperty("end_time")
    private String endTime;
    private String eid;
    @JsonProperty("work_num_list")
    private List<String> workNumList;
}
