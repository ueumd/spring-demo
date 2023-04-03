package com.ueumd.tech.service.login;

import com.ueumd.tech.domain.ResponseResult;
import com.ueumd.tech.domain.login.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
