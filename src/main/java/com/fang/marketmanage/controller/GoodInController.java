package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.GoodIn;
import com.fang.marketmanage.service.GoodInService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 商品入库控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class GoodInController {
    /**
     * 商品入库服务
     */
    @Autowired
    GoodInService goodInService;

    /**
     * 商品入库列表
     *
     * @return {@link List<GoodIn>}
     */
    @GetMapping("/goodin")
    @PreAuthorize("hasAuthority('/goodin/**;GET')")
    public List<GoodIn> findGoodInList() {
        return goodInService.findGoodInList();
    }

    /**
     * 添加新的商品入库
     *
     * @param goodIn 好
     * @return {@link RespUtil}
     */
    @PostMapping("/goodin")
    @PreAuthorize("hasAuthority('/goodin/**;POST')")
    @CustomLog(operation = "添加商品入库")
    public RespUtil addNewGoodIn(GoodIn goodIn) {
        if (goodInService.addNewGoodIn(goodIn) == 1) {
            return RespUtil.success("添加成功！");
        } else {
            return RespUtil.error("添加失败！");
        }
    }

    /**
     * 通过id商品入库记录
     *
     * @param id id
     * @return {@link RespUtil}
     */
    @DeleteMapping("/goodin/{id}")
    @PreAuthorize("hasAuthority('/goodin/**;DELETE')")
    @CustomLog(operation = "删除商品入库")
    public RespUtil deleteGoodInById(@PathVariable Integer id) {
        if (goodInService.deleteGoodInById(id) == 1) {
            return RespUtil.success("删除成功！");
        } else {
            return RespUtil.error("删除失败！");
        }
    }

    /**
     * 通过id更新商品入库
     *
     * @param goodIn 商品入库
     * @return {@link RespUtil}
     */
    @PutMapping("/goodin")
    @PreAuthorize("hasAuthority('/goodin/**;PUT')")
    @CustomLog(operation = "修改商品入库")
    public RespUtil updateGoodInById(GoodIn goodIn) {
        if (goodInService.updateGoodInById(goodIn) == 1) {
            return RespUtil.success("修改成功！");
        } else {
            return RespUtil.error("修改失败！");
        }
    }

    /**
     * 绑定
     *
     * @param binder 绑定
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
