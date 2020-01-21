package com.southeast.iLoveMasami.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	//删除学生动作
	public String delete()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		//获得传过来的参数
		String sid=request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	//添加学生动作
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
	
	//修改学生动作
	public String modify()
	{
		//获得学生编号
		String sid=request.getParameter("sid");
		StudentsDao sdao=new StudentsDaoImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//保存到会话中
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	//保存修改的动作
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
