package com.cxh.servlet;


import com.alibaba.fastjson.JSON;
import com.cxh.bean.User;
import com.cxh.service.LoginService;
import com.cxh.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品评论的Servlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    private LoginService loginService=new LoginServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接受请求参数
        String phone = req.getParameter("phone");
        //接受请求参数： 用户输入验证码
        String verifyCode = req.getParameter("verifyCode");


        //从Session中获取验证码
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("randomCode");

        Map<String,Object> result = new HashMap<>();
        if(code!=null){

            if(verifyCode.equals(code)){
//                if(true){

                //TODO 待办任务 ，将手机号从数据库查询，如果有，不做任何操作，没有，登录手机号插入到数据库中（登录并注册一起完成）
                /**
                 * 思路
                 * 调用业务层（LoginService）方法
                 *  1，调用dao层根据手机号从数据库查询方法
                 *  2，判断
                 *      有：直接返回
                 *      没有：调用dao层新增用户数据方法，把手机号作为用户账号即可
                 */
                User user=this.loginService.selectByUserName(phone);
                if(user==null){
                    this.loginService.insertNewUserByUserName(phone);
                }

                result.put("code","200");
                result.put("msg","ok");

            }else{
                result.put("code","500");
                result.put("msg","验证码错误,请输入正确的验证码");
            }
        }

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
