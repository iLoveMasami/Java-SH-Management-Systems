package com.southeast.iLoveMasami.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	//ɾ��ѧ������
	public String delete()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		//��ô������Ĳ���
		String sid=request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	//���ѧ������
	public String add()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		Students s = new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		String dateString = request.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(dateString);
			s.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		s.setAddress(request.getParameter("address"));
		sdao.addStudents(s);
		return "add_success";
	}
	
	//�޸�ѧ������
	public String modify()
	{
		//���ѧ�����
		String sid=request.getParameter("sid");
		StudentsDao sdao=new StudentsDaoImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//���浽�Ự��
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	//�����޸ĵĶ���
	public String save()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		String dateString = request.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(dateString);
			s.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		s.setAddress(request.getParameter("address"));
		sdao.updateStudents(s);
		return "save_success";
	}
}
