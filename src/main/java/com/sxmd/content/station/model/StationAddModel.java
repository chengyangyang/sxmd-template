package com.sxmd.content.station.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;


/**
 * Description: 添加测站信息实体
 * 字段需要修改，需移至EditModel中
 *
 * @author summit
 * @date Version 1.0
 */
@Data
@ApiModel(value = "新增测站信息实体", description = "接收参数body")
@JsonIgnoreProperties({"id"})
public class StationAddModel extends StationEditModel {


}