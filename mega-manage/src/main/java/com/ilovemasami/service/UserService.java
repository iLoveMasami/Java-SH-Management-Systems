package com.ilovemasami.service;

import com.ilovemasami.entity.Users;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public interface UserService {
  /**
   * 用户登录
   *
   * @param u
   * @return
   */
  boolean usersLogin(Users u);
}
