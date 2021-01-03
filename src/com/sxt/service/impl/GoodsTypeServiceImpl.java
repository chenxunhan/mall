package com.sxt.service.impl;

import com.sxt.bean.GoodsType;
import com.sxt.dao.GoodsTypeDao;
import com.sxt.dao.impl.GoodsTypeDaoImpl;
import com.sxt.service.GoodsTypeService;

import java.util.List;

/**
 * 商品类型的业务实现类的接口
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {

    private GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();

    @Override
    public List<GoodsType> queryAllGoodsType() {
        return this.goodsTypeDao.queryAllGoodsType();
    }
}
