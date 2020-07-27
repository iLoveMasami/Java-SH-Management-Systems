package com.ilovemasami.action;

import com.ilovemasami.constant.MessageConstants;
import com.ilovemasami.entity.Users;
import com.ilovemasami.service.UserService;
import com.opensymphony.xwork2.ModelDriven;
import javax.inject.Inject;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class UserAction extends SuperAction implements ModelDriven<Users> {

  private Users user = new Users();

  private UserService userService;

  @Inject
  public UserAction(UserService userService) {
    this.userService = userService;
  }

  public String login() {
    if (userService.usersLogin(user)) {
      session.setAttribute("loginUserName", user.getUsername());
      return "login_success";
    } else {
      return "login_failure";
    }

  }

  @SkipValidation
  public String logout() {
    if (session.getAttribute("loginUserName") != null) {
      session.removeAttribute("loginUserName");
    }
    return "logout_success";
  }

  @Override
  public void validate() {
    if ((user.getUsername() == null) || "".equals(user.getUsername())) {
      this.addFieldError(MessageConstants.ErrorFiledName.usernameError,
          MessageConstants.getErrorTip(MessageConstants.ErrorFiledName.usernameError));
    }
    //判断密码信息
    if ((user.getPassword() == null)
        || user.getPassword().length() < MessageConstants.Constants.passwordMinLength) {
      this.addFieldError(MessageConstants.ErrorFiledName.passwordLengthError,
          MessageConstants.getErrorTip(MessageConstants.ErrorFiledName.passwordLengthError));
    }
  }

  @Override
  public Users getModel() {

    return this.user;
  }
}
