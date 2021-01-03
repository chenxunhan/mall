package com.cxh.dao;

import com.cxh.bean.GoodsType;

import java.util.List;

/**
 * 商品类型的数据库访问接口
 */
public interface GoodsTypeDao {

    /**
     * 查询所有商品类型
     */
    List<GoodsType> queryAllGoodsType();
}
