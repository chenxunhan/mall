package com.sxt.servlet;


import com.alibaba.fastjson.JSON;
import com.sxt.service.CommentService;
import com.sxt.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 商品评论的Servlet
 */
@WebServlet("/comment.do")
public class GoodsCommentServlet extends HttpServlet {

    //引入品论Service
    private CommentService commentService = new CommentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接受请求参数
        Integer goodsId = Integer.valueOf(req.getParameter("goodsId"));//商品id
        Integer page = Integer.valueOf(req.getParameter("page"));//页码
        Integer size = Integer.valueOf(req.getParameter("size"));//每页条数


        //查询对应商品的评论，包含当前页结果和总数
        Map<String,Object> result = commentService.selectCommentsByGoodsId(goodsId,page,size);


        //把类型集合转成json
        String json = JSON.toJSONString(result);
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
