package com.cxh.service;

import com.cxh.bean.User;

public interface LoginService {
    User selectByUserName(String userName);
    Boolean insertNewUserByUserName(String userName);
}
