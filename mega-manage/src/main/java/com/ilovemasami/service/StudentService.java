package com.ilovemasami.service;

import com.ilovemasami.entity.Students;
import java.util.List;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public interface StudentService {

  /**
   * 查询所有学生
   *
   * @return
   */
  List<Students> queryAllStudents();


  /**
   * 根据学生编号查询学生资料
   *
   * @param sid
   * @return
   */
  Students queryStudentBySid(String sid);

  /**
   * 添加学生资料
   *
   * @param s
   * @return
   */
  boolean addStudent(Students s);

  /**
   * 修改学生资料
   *
   * @param s
   * @return
   */
  boolean updateStudent(Students s);

  /**
   * 删除学生资料
   *
   * @param sid
   * @return
   */
  boolean deleteStudent(String sid);
}
