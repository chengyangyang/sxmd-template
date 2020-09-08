package com.sxmd.content.station.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Description: 编辑测站信息实体
 * 非修改字段需要移至 AddModel中
 *
 * @author summit
 * @date Version 1.0
 */
@Data
@ApiModel(value = "编辑测站信息实体", description = "接收参数body")
public class StationEditModel {

    @ApiModelProperty(name = "主键,新增不需要要，更新必填")
    private Long id;

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