package com.sxt.service;

import com.sxt.bean.User;

public interface LoginService {
    User selectByUserName(String userName);
    Boolean insertNewUserByUserName(String userName);
}
