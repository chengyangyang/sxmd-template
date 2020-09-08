package com.sxmd.content.station.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sxmd.base.BaseEntity;
import lombok.Data;
import lombok.ToString;


/**
 * Description: 测站信息实体
 *
 * @author summit
 * @date Version 1.0
 */
@Data
@ToString(callSuper = true)
@TableName("station")
public class StationEntity extends BaseEntity {

    /**
     *
     */
    @TableField(value = "STCD")
    private String STCD;

    /**
     *
     */
    @TableField(value = "STNM")
    private String STNM;

    /**
     *
     */
    @TableField(value = "LGTD")
    private double LGTD;

    /**
     *
     */
    @TableField(value = "LTTD")
    private double LTTD;

    /**
     *
     */
    @TableField(value = "STLC")
    private String STLC;


}
