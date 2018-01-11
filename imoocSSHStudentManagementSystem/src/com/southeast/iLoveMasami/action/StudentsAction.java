package com.southeast.iLoveMasami.action;

import java.util.List;

import com.southeast.iLoveMasami.entity.Students;
import com.southeast.iLoveMasami.service.StudentsDao;
import com.southeast.iLoveMasami.serviceimpl.StudentsDaoImpl;

/**
 * ѧ���Ķ�����
 * @author iLoveMasami
 * @date   2018��1��11�� ����1:35:38
 */
public class StudentsAction extends SuperAction{

	private static final long serialVersionUID = 1L;

	//��ѯ����ѧ��
	public String query()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		List<Students> list = sdao.queryAllStudents();
		//�Ž�session��
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("students_list", list);					
		}
		return "query_success";
	}
}
