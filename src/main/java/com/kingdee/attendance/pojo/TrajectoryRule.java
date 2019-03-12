package com.kingdee.attendance.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午1:30
 */
@Getter
@Setter
@Document(collection = "T_TrajectoryRule")
public class TrajectoryRule extends BasePojo{

    @JsonProperty("work_num")
    private String workNum;
    private String oid;
    private String eid;
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
}
