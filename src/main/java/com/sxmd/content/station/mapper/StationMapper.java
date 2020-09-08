package com.sxmd.content.station.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxmd.base.PageStart;
import com.sxmd.content.station.entity.StationEntity;
import com.sxmd.content.station.model.StationListModel;
import com.sxmd.content.station.model.StationListRequestModel;
import com.sxmd.content.station.model.StationListResponseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Description: 测站信息 dao接口
 *
 * @author summit
 * @date Version 1.0
 */
@Mapper
public interface StationMapper extends BaseMapper<StationEntity> {

    /**
     * Description: 列表查询
     *
     * @param listRequestModel:
     * @return java.util.List
     * @author summit
     * @date
     */
    List<StationListResponseModel> findStationList(PageStart<StationListResponseModel> page, StationListRequestModel listRequestModel);

    /**
     * Description: 获得所有数据
     *
     * @param :
     * @return java.util.List
     * @author summit
     * @date
     */
    List<StationListModel> findAllList();

    /**
     * Description: 批量新增
     *
     * @param entityList:
     * @return long
     * @author summit
     * @date
     */
    long batchInsert(List<StationEntity> entityList);


    /**
     * Description: 批量新增
     *
     * @param ids:
     * @return long
     * @author summit
     * @date
     */
    long batchDeleteByIds(Long[] ids);

}