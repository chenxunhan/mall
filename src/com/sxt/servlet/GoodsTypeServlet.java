package com.sxt.servlet;

import com.alibaba.fastjson.JSON;
import com.sxt.bean.GoodsType;
import com.sxt.service.GoodsTypeService;
import com.sxt.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 查询所有的商品类型
 */
@WebServlet("/goodsType.do")
public class GoodsTypeServlet extends HttpServlet {

    private GoodsTypeService goodsTypeService=new GoodsTypeServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有的商品类型集合
        List<GoodsType> goodsTypes = goodsTypeService.queryAllGoodsType();
        //把类型集合转成json
        String json = JSON.toJSONString(goodsTypes);
        //设置响应的数据类型
        resp.setContentType("application/json;charset=utf-8");
        //得到响应流
        PrintWriter writer = resp.getWriter();
        //向响应流里面写数据
        writer.print(json);
        //刷新响应流
        writer.flush();
        //关闭响应流
        writer.close();
    }


}
