package com.sxt.dao;

import com.sxt.bean.Goods;
import com.sxt.bean.GoodsType;
import com.sxt.dto.GoodsDto;

import java.util.List;

/**
 * 商品的数据库访问接口
 */
public interface GoodsDao {

    /**
     * 查询所有商品
     */
    List<Goods> queryAllGoods(GoodsDto goodsDto);

    /**
     * 查询所有热销的商品
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
