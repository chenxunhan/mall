package com.cxh.service.impl;

import com.cxh.bean.GoodsType;
import com.cxh.dao.GoodsTypeDao;
import com.cxh.dao.impl.GoodsTypeDaoImpl;
import com.cxh.service.GoodsTypeService;

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
