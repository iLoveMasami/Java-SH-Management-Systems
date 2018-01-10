package com.southeast.iLoveMasami.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ����Aciton�����ĸ���
 * 
 * @author iLoveMasami
 * @date 2018��1��10�� ����8:31:03
 */
public class SuperAction extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, ServletContextAware {
	/*ʵ�ֽӿ���Ϊ�˻�ȡ���ö���*/
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;// �������
	protected HttpServletResponse response;// ��Ӧ����
	protected HttpSession session;// �Ự����
	protected ServletContext application;// ȫ�ֶ���

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;

	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

}
