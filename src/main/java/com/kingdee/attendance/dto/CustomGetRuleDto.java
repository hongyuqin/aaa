package com.kingdee.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hongyuqin
 * @since 2019/3/11  下午3:51
 */
@Getter
@Setter
public class CustomGetRuleDto {
    private String date;
    @JsonProperty("work_num_list")
    private List<String> workNumList;
}
