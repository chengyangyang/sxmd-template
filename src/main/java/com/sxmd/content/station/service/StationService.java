package com.sxmd.content.station.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sxmd.base.BasePage;
import com.sxmd.base.RequestPage;
import com.sxmd.content.station.entity.StationEntity;
import com.sxmd.content.station.model.*;

import java.util.List;

/**
 * Description: 测站信息接口
 *
 * @author summit
 * @date Version 1.0
 */
public interface StationService extends IService<StationEntity> {

    /**
     * Description:  测站信息-新增
     *
     * @param model:
     * @return
     * @author summit
     * @date
     */
    Long insertStation(StationAddModel model);


    /**
     * Description:  测站信息-批量新增新增
     *
     * @param model:
     * @return
     * @author summit
     * @date
     */
    long batchInsertStation(List<StationAddModel> model);

    /**
     * Description:  测站信息-更新
     *
     * @param model:
     * @author summit
     * @date
     */
    void updateStation(StationEditModel model);

    /**
     * Description:   测站信息-删除
     *
     * @param id: 主键
     * @author summit
     * @date
     */
    void deleteStation(Long id);

    /**
     * Description:   测站信息-删除
     *
     * @param ids: 主键数组
     * @author summit
     * @date
     */
    long batchDeleteStation(Long[] ids);

    /**
     * Description:   测站信息-详情
     *
     * @param id: 主键
     * @author summit
     * @date
     */
    StationDetailsModel getStationDetailsById(Long id);

    /**
     * Description:   测站信息-列表
     *
     * @param listRequestModel: 参数
     * @author summit
     * @date
     */
    BasePage<StationListResponseModel> findPageStationList(StationListRequestModel listRequestModel, RequestPage requestPage);

    /**
     * Description:   测站信息-所有数据
     *
     * @param :
     * @author summit
     * @date
     */
    List<StationListModel> findAllStationList();

}
