package com.sxt.service.impl;

import com.sxt.bean.User;
import com.sxt.dao.UserDao;
import com.sxt.dao.impl.UserDaoImpl;
import com.sxt.service.LoginService;

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
