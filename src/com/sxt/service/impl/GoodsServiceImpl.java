package com.sxt.service.impl;

import com.sxt.bean.Goods;
import com.sxt.dao.GoodsDao;
import com.sxt.dao.impl.GoodsDaoImpl;
import com.sxt.dto.GoodsDto;
import com.sxt.service.GoodsService;

import java.util.List;

/**
 * 商品业务接口的实现类
 */
public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public List<Goods> queryAllGoods(GoodsDto goodsDto) {
        return this.goodsDao.queryAllGoods(goodsDto);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Goods> queryAllHotGoods() {
        return this.goodsDao.queryAllHotGoods();
    }

    @Override
    public List<Goods> queryAllNewGoods() {
        return this.goodsDao.queryAllNewGoods();
    }

    @Override
    public Goods selectByGoodsId(Integer goodsId) {

        Goods goods = goodsDao.selectByGoodsId(goodsId);

        return goods;
    }
}
