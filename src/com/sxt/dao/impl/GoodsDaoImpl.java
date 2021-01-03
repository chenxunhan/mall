package com.sxt.dao.impl;

import com.sxt.bean.Goods;
import com.sxt.bean.GoodsType;
import com.sxt.dao.GoodsDao;
import com.sxt.dto.GoodsDto;
import com.sxt.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询商品信息的数据访问接口实现类
 */
public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<Goods> queryAllGoods(GoodsDto goodsDto) {
        List<Goods> goodsList=new ArrayList<>();
        //创建一个集合去存放占位符的数据
        List<Object> args=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select * from tb_goods where status=1 ");
        if(goodsDto.getKeywords()!=null&&!goodsDto.getKeywords().equals("")){
            sql.append(" and goods_name like concat('%',?,'%') ");
            args.add(goodsDto.getKeywords());
        }
        //如果商品类型ID不为空，也不为0[全部] 就应该使用类型进行过滤
        if(goodsDto.getTypeId()!=null&&!goodsDto.getTypeId().equals(0)){
            sql.append(" and type_id=? ");
            args.add(goodsDto.getTypeId());
        }
        //如果价格排序规则不为空，也不为0[默认] 就应该使用价格进行排序
        if(goodsDto.getPriceSortType()!=null&&!goodsDto.getPriceSortType().equals(0)){
            //1 价格升序  2 价格降序
            sql.append(" order by goods_price "+(goodsDto.getPriceSortType().equals(1)?" asc":" desc"));
        }

        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = DBUtils.prepareStatement(conn, sql.toString(), args.toArray());

        ResultSet rs = DBUtils.executeQuery(pstmt);
        try{
            while (rs.next()){
                Integer goodsId=rs.getInt("goods_id");
                String goodsName=rs.getString("goods_name");
                String goodsImg=rs.getString("goods_img");
                Integer status=rs.getInt("status");
                Integer saleNum=rs.getInt("sale_num");
                Integer typeId=rs.getInt("type_id");
                Double goodsPrice=rs.getDouble("goods_price");
                Integer isHot=rs.getInt("is_hot");
                Integer isNew=rs.getInt("is_new");
                Goods goods=new Goods(goodsId,goodsName,goodsImg,status,saleNum,typeId,goodsPrice,isHot,isNew);
                goodsList.add(goods);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        DBUtils.close(rs);
        DBUtils.close(pstmt);
        DBUtils.close(conn);
        return goodsList;
    }

    @Override
    public List<Goods> queryAllHotGoods() {
        List<Goods> goodsList=new ArrayList<>();
        //创建一个集合去存放占位符的数据
        List<Object> args=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select * from tb_goods where status=1 and is_hot=1");
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = DBUtils.prepareStatement(conn, sql.toString(), args.toArray());
        ResultSet rs = DBUtils.executeQuery(pstmt);
        try{
            while (rs.next()){
                Integer goodsId=rs.getInt("goods_id");
                String goodsName=rs.getString("goods_name");
                String goodsImg=rs.getString("goods_img");
                Integer status=rs.getInt("status");
                Integer saleNum=rs.getInt("sale_num");
                Integer typeId=rs.getInt("type_id");
                Double goodsPrice=rs.getDouble("goods_price");
                Integer isHot=rs.getInt("is_hot");
                Integer isNew=rs.getInt("is_new");
                Goods goods=new Goods(goodsId,goodsName,goodsImg,status,saleNum,typeId,goodsPrice,isHot,isNew);
                goodsList.add(goods);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        DBUtils.close(rs);
        DBUtils.close(pstmt);
        DBUtils.close(conn);
        return goodsList;
    }

    @Override
    public List<Goods> queryAllNewGoods() {
        List<Goods> goodsList=new ArrayList<>();
        //创建一个集合去存放占位符的数据
        List<Object> args=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select * from tb_goods where status=1 and is_new=1");
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = DBUtils.prepareStatement(conn, sql.toString(), args.toArray());
        ResultSet rs = DBUtils.executeQuery(pstmt);
        try{
            while (rs.next()){
                Integer goodsId=rs.getInt("goods_id");
                String goodsName=rs.getString("goods_name");
                String goodsImg=rs.getString("goods_img");
                Integer status=rs.getInt("status");
                Integer saleNum=rs.getInt("sale_num");
                Integer typeId=rs.getInt("type_id");
                Double goodsPrice=rs.getDouble("goods_price");
                Integer isHot=rs.getInt("is_hot");
                Integer isNew=rs.getInt("is_new");
                Goods goods=new Goods(goodsId,goodsName,goodsImg,status,saleNum,typeId,goodsPrice,isHot,isNew);
                goodsList.add(goods);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        DBUtils.close(rs);
        DBUtils.close(pstmt);
        DBUtils.close(conn);
        return goodsList;
    }

    @Override
    public Goods selectByGoodsId(Integer goodsId) {

        String sql = "select * from tb_goods where goods_id = ?";

        ResultSet rs = DBUtils.executeQuery(sql,goodsId);

        try {
            if(rs.next()){

                String goodsName=rs.getString("goods_name");
                String goodsImg=rs.getString("goods_img");
                Integer status=rs.getInt("status");
                Integer saleNum=rs.getInt("sale_num");
                Integer typeId=rs.getInt("type_id");
                Double goodsPrice=rs.getDouble("goods_price");
                Integer isHot=rs.getInt("is_hot");
                Integer isNew=rs.getInt("is_new");


                Goods goods=new Goods(goodsId,goodsName,goodsImg,status,saleNum,typeId,goodsPrice,isHot,isNew);

                String goods_imgs = rs.getString("goods_imgs");//null
                if(goods_imgs!=null){
                    goods.setGoodsImgs(goods_imgs.split(","));
                }
                return  goods;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
