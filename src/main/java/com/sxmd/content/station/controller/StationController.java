package com.sxmd.content.station.controller;


import com.sxmd.base.BaseController;
import com.sxmd.base.BasePage;
import com.sxmd.base.JsonResult;
import com.sxmd.constant.ConstantWeb;
import com.sxmd.content.station.model.*;
import com.sxmd.content.station.service.StationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Description: 测站信息 控制器
 *
 * @author summit
 * @date Version 1.0
 */
@RestController
@Api(value = "测站信息 controller", tags = "测站信息")
@RequestMapping("station")
public class StationController extends BaseController {

    @Autowired
    private StationService service;


    /**
     * Description:   测站信息-列表
     *
     * @param listRequestModel: 参数
     * @author summit
     * @date
     */
    @ApiOperation(value = "分页列表", notes = "测站信息")
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult<BasePage<StationListResponseModel>> page(StationListRequestModel listRequestModel) {
        return success(service.findPageStationList(listRequestModel, null));
    }

    /**
     * Description:   测站信息-所有数据
     *
     * @param :
     * @author summit
     * @date
     */
    @ApiOperation(value = "所有数据", notes = "获得所有测站信息数据")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public JsonResult<List<StationListModel>> all() {
        return success(service.findAllStationList());
    }


    /**
     * Description:   测站信息-详情
     *
     * @param id: 主键
     * @author summit
     * @date
     */
    @ApiOperation(value = "详情", notes = "根据测站信息ID获取单条测站信息")
    @ApiImplicitParam(name = "id", value = "主键id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult<StationDetailsModel> get(@PathVariable("id") Long id) {
        return success(service.getStationDetailsById(id));
    }


    /**
     * Description:   测站信息-新增
     *
     * @param model:
     * @author summit
     * @date
     */
    @ApiOperation(value = "新增", notes = "新增测站信息")
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult insert(@RequestBody @Valid StationAddModel model) {
        service.insertStation(model);
        return success(ConstantWeb.SAVE_MSEEAGE);
    }

    @ApiOperation(value = "批量新增", notes = "批量新增测站信息")
    @RequestMapping(value = "batch/insert", method = RequestMethod.POST)
    public JsonResult batchInsert(@RequestBody @Valid List<StationAddModel> model) {
        long result = service.batchInsertStation(model);
        return success("批量新增" + result + "条记录");
    }


    /**
     * Description:   测站信息-修改
     *
     * @param model:
     * @author summit
     * @date
     */
    @ApiOperation(value = "修改", notes = "根据id更新测站信息")
    @RequestMapping(method = RequestMethod.PUT)
    public JsonResult update(@RequestBody @Valid StationEditModel model) {
        service.updateStation(model);
        return success(ConstantWeb.UPDATE_MSEEAGE);
    }


    /**
     * Description:   测站信息-删除
     *
     * @param id:
     * @author summit
     * @date
     */
    @ApiOperation(value = "删除", notes = "根据Id删除测站信息")
    @ApiImplicitParam(name = "id", value = "主键 id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delete(@PathVariable("id") Long id) {
        service.deleteStation(id);
        return success(ConstantWeb.DELETE_MSEEAGE);
    }


    /**
     * Description:   测站信息-批量删除
     *
     * @param ids:
     * @author summit
     * @date
     */
    @ApiOperation(value = "批量删除", notes = "根据Id数组删除测站信息")
    @RequestMapping(value = "/ids", method = RequestMethod.DELETE)
    public JsonResult batchDelete(@RequestBody Long[] ids) {
        long result = service.batchDeleteStation(ids);
        return success("批量删除" + result + "条记录");
    }

}
