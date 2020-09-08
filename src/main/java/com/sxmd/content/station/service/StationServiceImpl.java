package com.sxmd.content.station.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxmd.base.BasePage;
import com.sxmd.base.PageBuilder;
import com.sxmd.base.PageStart;
import com.sxmd.base.RequestPage;
import com.sxmd.content.station.entity.StationEntity;
import com.sxmd.content.station.mapper.StationMapper;
import com.sxmd.content.station.model.*;
import com.sxmd.util.BeanUtil;
import com.sxmd.util.IdWorkerUil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Description: 测站信息 实现类
 *
 * @author sxmd
 * @date Version 1.0
 */
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, StationEntity> implements StationService {

    /**
     * Description:   新增
     *
     * @param model:
     * @author summit
     * @date
     */
    @Override
    public Long insertStation(StationAddModel model) {
        StationEntity entity = new StationEntity();
        BeanUtils.copyProperties(model, entity);
        entity.setId(IdWorkerUil.generateId());
        entity.setCreateTime(LocalDateTime.now());
        baseMapper.insert(entity);
        return entity.getId();
    }

    /**
     * Description:   批量新增
     *
     * @param model:
     * @author summit
     * @date
     */
    @Override
    public long batchInsertStation(List<StationAddModel> model) {
        // 先数据校验，通过后
        List<StationEntity> entityList = BeanUtil.copyPropertiesOfList(model, StationEntity.class);
        entityList.stream().forEach(x -> {
            x.setId(IdWorkerUil.generateId());
            x.setCreateTime(LocalDateTime.now());
        });
        return baseMapper.batchInsert(entityList);
    }

    /**
     * Description: 更新
     *
     * @param model:
     * @author summit
     * @date
     */
    @Override
    public void updateStation(StationEditModel model) {
        // 查询当前数据
        StationEntity entity = baseMapper.selectById(model.getId());
        baseMapper.updateById(entity);
    }

    /**
     * Description: 删除
     *
     * @param id: 主键
     * @author summit
     * @date
     */
    @Override
    public void deleteStation(Long id) {
        StationEntity entity = baseMapper.selectById(id);
        baseMapper.deleteById(id);
    }

    /**
     * Description: 删除
     *
     * @param ids: 主键数组
     * @author summit
     * @date
     */
    @Override
    public long batchDeleteStation(Long[] ids) {
        return baseMapper.batchDeleteByIds(ids);
    }


    /**
     * Description:   详情
     *
     * @param id: 主键
     * @author summit
     * @date
     */
    @Override
    public StationDetailsModel getStationDetailsById(Long id) {
        StationEntity entity = baseMapper.selectById(id);
        StationDetailsModel model = new StationDetailsModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    /**
     * Description: 列表
     *
     * @param listRequestModel: 参数
     * @author summit
     * @date
     */
    @Override
    public BasePage<StationListResponseModel> findPageStationList(StationListRequestModel listRequestModel, RequestPage requestPage) {
        PageStart<StationListResponseModel> objectPageStart = PageBuilder.builderPageStart(requestPage);
        List<StationListResponseModel> stationList = baseMapper.findStationList(objectPageStart, listRequestModel);
        BasePage<StationListResponseModel> stationListResponseModelBasePage = PageBuilder.builderResultPage(objectPageStart, stationList);
        BasePage<StationEntity> stationEntityBasePage = PageBuilder.basePageConversion(stationListResponseModelBasePage, StationEntity.class);
        return stationListResponseModelBasePage;
    }

    /**
     * Description: 获得所有数据
     *
     * @param :
     * @author summit
     * @date
     */
    @Override
    public List<StationListModel> findAllStationList() {
        return baseMapper.findAllList();
    }

}
