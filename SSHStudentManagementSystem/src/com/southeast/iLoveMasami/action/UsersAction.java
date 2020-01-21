package com.southeast.iLoveMasami.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.southeast.iLoveMasami.entity.Users;
import com.southeast.iLoveMasami.service.UsersDao;
import com.southeast.iLoveMasami.serviceimpl.UsersDaoImpl;

/**
 * �û���Action��
 * 
 * @author iLoveMasami
 * @date 2018��1��10�� ����8:45:22
 */
public class UsersAction extends SuperAction implements ModelDriven<Users> {
	private static final long serialVersionUID = 1L;
	private Users user = new Users();

	// �û���¼����
	public String login() {
		UsersDao uDao = new UsersDaoImpl();
		if (uDao.usersLogin(user)) {
			// ��session�б����¼�ɹ����û���
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}

	}
    @SkipValidation
	// �û�ע������
	public String logout() {
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	@Override
	public void validate() {
		//�û�������Ϊ��
		if("".equals(user.getUsername()))
		{
			this.addFieldError("usernameError", "�û�������Ϊ�գ���");			
		}
		//�ж�������Ϣ
		if(user.getPassword().length()<4)
		{
			this.addFieldError("passwordLengthError", "���볤�Ȳ�������4λ����");
		}
	}

	@Override
	public Users getModel() {

		return this.user;
	}

}
