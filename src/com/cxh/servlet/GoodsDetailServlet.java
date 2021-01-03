package com.cxh.servlet;


import com.alibaba.fastjson.JSON;
import com.cxh.bean.Goods;
import com.cxh.service.GoodsService;
import com.cxh.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 商品详情的Servlet
 */
@WebServlet("/detail.do")
public class GoodsDetailServlet extends HttpServlet {

    //引入Service层
    private GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接受请求参数
        Integer goodsId = Integer.valueOf(req.getParameter("goodsId"));


        Goods goods = goodsService.selectByGoodsId(goodsId);


        //把类型集合转成json
        String json = JSON.toJSONString(goods);
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
