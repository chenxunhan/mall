package com.cxh.service;

import com.cxh.bean.Goods;
import com.cxh.dto.GoodsDto;

import java.util.List;

/**
 * 商品的业务数据库访问接口
 */
public interface GoodsService {

    /**
     * 查询所有商品
     */
    List<Goods> queryAllGoods(GoodsDto goodsDto);

    /**
     * 查询所有的热销商品
     * @return
     */
    List<Goods> queryAllHotGoods();

    /**
     * 查询所有的新商品集合
     * @return
     */
    List<Goods> queryAllNewGoods();

    /**
     * 根据主键查询出对应的商品详情
     * @param goodsId 商品id
     * @return
     */
    Goods selectByGoodsId(Integer goodsId);
}
