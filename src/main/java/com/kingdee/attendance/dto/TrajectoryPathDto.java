package com.kingdee.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * @author hongyuqin
 * @since 2019/3/11  下午7:46
 */
@Getter
@Setter
public class TrajectoryPathDto {
    @JsonProperty("work_num")
    private String workNum;
    private String eid;
    private String oid;
    private Long longtitude;
    private Long latitude;
    private String address;
    private String remark;
    private String time;
}
