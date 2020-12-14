package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.GoodType;
import com.fang.marketmanage.service.GoodTypeService;
import com.fang.marketmanage.util.RespUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 好型控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@Slf4j
@RestController
public class GoodTypeController {
    /**
     * 好的类型服务
     */
    @Autowired
    private GoodTypeService goodTypeService;

    /**
     * 找到好的类型列表
     *
     * @return {@link List<GoodType>}
     */
    @GetMapping("/goodtype")
    public List<GoodType> findGoodTypeList() {
        log.debug(String.format(new Date().toString()));
        return goodTypeService.findGoodTypeList();
    }

    /**
     * 添加新的好的类型
     *
     * @param goodType 好的类型
     * @return {@link RespUtil}
     */
    @PostMapping("/goodtype")
    @CustomLog(operation = "添加商品类型")
    public RespUtil addNewGoodType(GoodType goodType) {
        if (goodTypeService.addNewGoodType(goodType) == 1) {
            return RespUtil.success("添加成功！");
        }
        return RespUtil.error("添加失败");
    }

}
