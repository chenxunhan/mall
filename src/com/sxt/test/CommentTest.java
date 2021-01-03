package com.sxt.test;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class CommentTest {

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {

            String username = UUID.randomUUID().toString().substring(0, 5);
            String comment = "给女朋友买的，女朋友说非常好用。特别实惠，赞，五星好评";
            String comment_date = new Date().toLocaleString();
            Random random = new Random();
            int star = random.nextInt(5);


            String sql = "insert into tb_comment (user_img,username,comment,star,comment_date,goods_id)values('../res/layui/images/face/0.gif','"+username+"','"+comment+"',"+star+",'"+comment_date+"',1);";
            System.out.println(sql);
        }

    }

}
