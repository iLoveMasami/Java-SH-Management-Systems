package com.ilovemasami.service.impl;

import com.ilovemasami.entity.Students;
import com.ilovemasami.service.StudentService;

import java.util.List;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class StudentServiceImpl implements StudentService {
  @Override
  public List<Students> queryAllStudents() {
    return null;
  }

  @Override
  public Students queryStudentBySid(String sid) {
    return null;
  }

  @Override
  public boolean addStudent(Students s) {
    return false;
  }

  @Override
  public boolean updateStudent(Students s) {
    return false;
  }

  @Override
  public boolean deleteStudent(String sid) {
    return false;
  }
}
