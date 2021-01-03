package com.cxh.servlet;


import com.alibaba.fastjson.JSON;
import com.cxh.utils.AlibabaSendMsgUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 商品评论的Servlet
 */
@WebServlet("/sendVerifyCode.do")
public class SendVerifyCodeServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接受请求参数
        String phone = req.getParameter("phone");


        //生成随机码
//        int randomCode = AlibabaSendMsgUtils.getRandom();
        String randomCode = String.format("%04d",AlibabaSendMsgUtils.getRandom());
        System.out.println(randomCode);

        //将随机码存储到Session中
        HttpSession session = req.getSession();
        session.setAttribute("randomCode",randomCode);


        //获取字符串
        String sendMsg = AlibabaSendMsgUtils.sendMsg(phone, randomCode);
        //将字符串转换成map集合
        Map map = JSON.parseObject(sendMsg, Map.class);

        //把类型集合转成json
        String json = JSON.toJSONString(map);
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
