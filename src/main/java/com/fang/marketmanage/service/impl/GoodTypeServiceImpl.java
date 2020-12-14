package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodTypeMapper;
import com.fang.marketmanage.entity.GoodType;
import com.fang.marketmanage.service.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品类型服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@Service
public class GoodTypeServiceImpl implements GoodTypeService {
    /**
     * 商品类型映射器
     */
    @Autowired
    private GoodTypeMapper goodTypeMapper;

    /**
     * 添加新的商品类型
     *
     * @param goodType 商品类型
     * @return int
     */
    @Override
    public int addNewGoodType(GoodType goodType) {
        return goodTypeMapper.addNewGoodType(goodType);
    }

    /**
     * 商品列表
     *
     * @return {@link List<GoodType>}
     */
    @Override
    public List<GoodType> findGoodTypeList() {
        return goodTypeMapper.findGoodTypeList();
    }

}
