package com.cxh.service.impl;

import com.cxh.bean.User;
import com.cxh.dao.UserDao;
import com.cxh.dao.impl.UserDaoImpl;
import com.cxh.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public User selectByUserName(String userName) {
        User user=this.userDao.selectByUserName(userName);
        return user;
    }

    @Override
    public Boolean insertNewUserByUserName(String userName) {
        boolean insertIsOk=this.userDao.insertNewUserByUserName(userName);
        return insertIsOk;
    }
}
