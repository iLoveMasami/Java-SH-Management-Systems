package com.ilovemasami.action;

import com.ilovemasami.entity.Students;
import com.ilovemasami.service.StudentService;
import com.ilovemasami.service.impl.StudentServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class StudentAction extends SuperAction {
//  private static final long serialVersionUID = 1L;

  public String query() {
    StudentService studentService = new StudentServiceImpl();
    List<Students> list = studentService.queryAllStudents();
    //放进session中
    if (list != null && list.size() > 0) {
      session.setAttribute("students_list", list);
    }
    return "query_success";
  }

  //删除学生动作
  public String delete() {

    //获得传过来的参数
    String sid = request.getParameter("sid");
    if(sid == null || sid.isEmpty()) {
      return "delete_failure";
    }
    StudentService studentService = new StudentServiceImpl();
    studentService.deleteStudent(sid);
    return "delete_success";
  }

  //添加学生动作
  public String add() {
    StudentService studentService = new StudentServiceImpl();
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
    studentService.addStudent(s);
    return "add_success";
  }

  //修改学生动作
  public String modify() {
    //获得学生编号
    String sid = request.getParameter("sid");
    StudentService studentService = new StudentServiceImpl();
    Students s = studentService.queryStudentBySid(sid);
    //保存到会话中
    session.setAttribute("modify_students", s);
    return "modify_success";
  }

  //保存修改的动作
  public String save() {
    StudentService studentService = new StudentServiceImpl();
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
    studentService.updateStudent(s);
    return "save_success";
  }
}
