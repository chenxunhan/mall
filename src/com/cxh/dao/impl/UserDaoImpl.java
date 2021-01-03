package com.cxh.dao.impl;

import com.cxh.bean.User;
import com.cxh.dao.UserDao;
import com.cxh.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectByUserName(String userName) {
        User user=null;

        String sql="select * from tb_user where user_name= ? ";

        ResultSet rs=DBUtils.executeQuery(sql,userName);
        try {
            //用户id
            Integer userId;
            //用户名
            String userName_;
            //用户密码
            String userPassword;
            while(rs.next()){
                userId=rs.getInt("user_id");
                userName_=rs.getString("user_name");
                userPassword=rs.getString("user_pwd");
                user=new User(userId,userName_,userPassword);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtils.close(rs);

        return user;
    }

    @Override
    public Boolean insertNewUserByUserName(String userName) {
        boolean insertIsOk=false;
        List<Object> args=new ArrayList<>();
        StringBuffer sql=new StringBuffer("insert into tb_user (user_name,user_pwd) values(?,?)");
        args.add(userName);
        args.add(userName);

        int rows=DBUtils.executeUpdate(sql.toString(),args.toArray());
        if(rows>0){
            insertIsOk=true;
        }
        return insertIsOk;
    }
}
