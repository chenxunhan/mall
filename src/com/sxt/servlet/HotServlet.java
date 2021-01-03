package com.sxt.servlet;

import com.alibaba.fastjson.JSON;
import com.sxt.bean.Goods;
import com.sxt.dto.GoodsDto;
import com.sxt.service.GoodsService;
import com.sxt.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 查询所条热销的商品
 */
@WebServlet("/hotGoods.do")
public class HotServlet extends HttpServlet {

    private GoodsService goodsService=new GoodsServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有的热销商品集合
        List<Goods> goodsList = goodsService.queryAllHotGoods();
        //把类型集合转成json
        String json = JSON.toJSONString(goodsList);
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
