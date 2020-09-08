package com.sxmd.content.station.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Description: 测站信息详情实体
 *
 * @author summit
 * @date Version 1.0
 */
@Data
@ApiModel(value = "测站信息详情实体")
public class StationDetailsModel {

    @ApiModelProperty(value = "")
    private String STCD;
    @ApiModelProperty(value = "")
    private String STNM;
    @ApiModelProperty(value = "")
    private double LGTD;
    @ApiModelProperty(value = "")
    private double LTTD;
    @ApiModelProperty(value = "")
    private String STLC;

}