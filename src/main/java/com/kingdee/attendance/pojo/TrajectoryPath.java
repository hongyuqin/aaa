package com.kingdee.attendance.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


/**
 * @author hongyuqin
 * @since 2019/3/11  下午1:37
 */
@Getter
@Setter
@Document(collection = "T_TrajectoryPath")
public class TrajectoryPath extends BasePojo {
    private String eid;
    private String oid;
    @JsonProperty("work_num")
    private String workNum;
    private Long longtitude;
    private Long latitude;
    private String address;
    private String remark;
    private LocalDateTime positionTime;
    private String time;
}
