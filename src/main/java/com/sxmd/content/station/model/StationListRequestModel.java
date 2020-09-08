package com.sxmd.content.station.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * Description: 测站信息 列表参数
 *
 * @author summit
 * @date Version 1.0
 */
@Data
@ApiModel(value = "测站信息列表参数", description = "接收参数 query")
public class StationListRequestModel {

    @ApiModelProperty(value = "名称")
    private String name;


    @ApiModelProperty(value = "时间")
    private LocalDate time;
}