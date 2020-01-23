package service;

import com.ilovemasami.entity.Users;
import com.ilovemasami.service.UserService;
import com.ilovemasami.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class TestUserService {
  @Test
  public void testUsersLogin() {
    Users u = new Users(1, "admin", "admin");
    UserService userService = new UserServiceImpl();
    Assert.assertEquals(true, userService.usersLogin(u));
  }
}
