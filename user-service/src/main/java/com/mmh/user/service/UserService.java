package com.mmh.user.service;

import com.mmh.user.domain.enitiy.User;
import com.mmh.user.domain.dto.UserDto;

/**
 * @author mmh
 * @date 2022-09-06 16:28
 */
public interface UserService {
    /**
     * 根据id查找用户
     * @param id id
     * @return User
     */
    User findById(Integer id);

    /**
     * 用户登录方法
     * @param userDto 登录入参
     * @return 登录用户信息
     */
    User login(UserDto userDto);
}
