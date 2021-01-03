package com.sxt.dao.impl;

import com.sxt.bean.GoodsType;
import com.sxt.dao.GoodsTypeDao;
import com.sxt.utils.DBUtils;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品类型数据库访问的实现类
 */
public class GoodsTypeDaoImpl implements GoodsTypeDao {
    @Override
    public List<GoodsType> queryAllGoodsType() {
        List<GoodsType> goodsTypes=new ArrayList<>();
        String sql="select * from tb_type";
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = DBUtils.prepareStatement(conn, sql, null);

        ResultSet rs = DBUtils.executeQuery(pstmt);
        try{
            while (rs.next()){
                goodsTypes.add(new GoodsType(rs.getInt("id"),rs.getString("name"),rs.getInt("status")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        DBUtils.close(rs);
        DBUtils.close(pstmt);
        DBUtils.close(conn);
        return goodsTypes;
    }
}
