package com.sxt.dao;

import com.sxt.bean.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;
/**
 * 用户数据库访问接口
 */
public interface UserDao {

    /**
     * 根据用户名查询对应用户
     * @param userName 用户名
     * @return
     */
    User selectByUserName(String userName);

    /**
     * 插入数据
     * @param userName
     * @return
     */
    Boolean insertNewUserByUserName(String userName);
}
