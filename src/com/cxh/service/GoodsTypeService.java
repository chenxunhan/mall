package com.cxh.service;

import com.cxh.bean.GoodsType;

import java.util.List;

/**
 * 商品类型的业务接口
 */
public interface GoodsTypeService {

    /**
     * 查询所有商品类型
     */
    List<GoodsType> queryAllGoodsType();
}
