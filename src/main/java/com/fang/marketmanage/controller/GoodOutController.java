package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.GoodOut;
import com.fang.marketmanage.service.GoodOutService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品出库控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class GoodOutController {
    /**
     * 商品出库服务
     */
    @Autowired
    GoodOutService goodOutService;

    /**
     * 商品出库列表
     *
     * @return {@link List<GoodOut>}
     */
    @GetMapping("/goodout")
    @PreAuthorize("hasAuthority('/goodout/**;GET')")
    public List<GoodOut> findGoodOutList() {
        return goodOutService.findGoodOutList();
    }

    /**
     * 添加新的商品出库
     *
     * @param goodOut 商品出库
     * @return {@link RespUtil}
     */
    @PostMapping("/goodout")
    @PreAuthorize("hasAuthority('/goodout/**;POST')")
    @CustomLog(operation = "添加商品出库")
    public RespUtil addNewGoodOut(GoodOut goodOut) {
        if (goodOutService.addNewGoodOut(goodOut) == 1) {
            return RespUtil.success("添加成功！");
        } else {
            return RespUtil.error("添加失败！");
        }
    }

    /**
     * 通过id删除商品出库记录
     *
     * @param id id
     * @return {@link RespUtil}
     */
    @DeleteMapping("/goodout/{id}")
    @PreAuthorize("hasAuthority('/goodout/**;DELETE')")
    @CustomLog(operation = "删除商品出库")
    public RespUtil deleteGoodOutById(@PathVariable Integer id) {
        if (goodOutService.deleteGoodOutById(id) == 1) {
            return RespUtil.success("删除成功！");
        } else {
            return RespUtil.error("删除失败！");
        }
    }

    /**
     * 通过id更新商品出库记录
     *
     * @param goodOut 商品出库
     * @return {@link RespUtil}
     */
    @PutMapping("/goodout")
    @PreAuthorize("hasAuthority('/goodout/**;PUT')")
    @CustomLog(operation = "修改商品出库")
    public RespUtil updateGoodOutById(GoodOut goodOut) {
        if (goodOutService.updateGoodOutById(goodOut) == 1) {
            return RespUtil.success("修改成功！");
        } else {
            return RespUtil.error("修改失败！");
        }
    }
}
