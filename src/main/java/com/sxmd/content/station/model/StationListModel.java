package com.sxmd.content.station.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Description: 测站信息所有数据列表实体
 *
 * @author summit
 * @date Version 1.0
 */
@Data
@ApiModel(value = "测站信息所有数据列表", description = "接收参数body")
@JsonIgnoreProperties({""})
public class StationListModel extends StationAddModel {

}