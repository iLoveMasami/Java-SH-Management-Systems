package com.southeast.iLoveMasami.action;

import java.util.List;

import com.southeast.iLoveMasami.entity.Students;
import com.southeast.iLoveMasami.service.StudentsDao;
import com.southeast.iLoveMasami.serviceimpl.StudentsDaoImpl;

/**
 * 学生的动作类
 * @author iLoveMasami
 * @date   2018年1月11日 下午1:35:38
 */
public class StudentsAction extends SuperAction{

	private static final long serialVersionUID = 1L;

	//查询所有学生
	public String query()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		List<Students> list = sdao.queryAllStudents();
		//放进session中
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("students_list", list);					
		}
		return "query_success";
	}
}
