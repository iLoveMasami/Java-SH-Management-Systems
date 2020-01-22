package com.southeast.iLoveMasami.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.southeast.iLoveMasami.entity.Users;
import com.southeast.iLoveMasami.service.UsersDao;
import com.southeast.iLoveMasami.serviceimpl.UsersDaoImpl;

/**
 * 用户的Action类
 * 
 * @author iLoveMasami
 * @date 2018年1月10日 下午8:45:22
 */
public class UsersAction extends SuperAction implements ModelDriven<Users> {
	private static final long serialVersionUID = 1L;
	private Users user = new Users();

	// 用户登录动作
	public String login() {
		UsersDao uDao = new UsersDaoImpl();
		if (uDao.usersLogin(user)) {
			// 在session中保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}

	}
    @SkipValidation
	// 用户注销动作
	public String logout() {
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	@Override
	public void validate() {
		//用户名不能为空
		if("".equals(user.getUsername()))
		{
			this.addFieldError("usernameError", "用户名不能为空！！");			
		}
		//判断密码信息
		if(user.getPassword().length()<4)
		{
			this.addFieldError("passwordLengthError", "密码长度不能少于4位！！");
		}
	}

	@Override
	public Users getModel() {

		return this.user;
	}

}
