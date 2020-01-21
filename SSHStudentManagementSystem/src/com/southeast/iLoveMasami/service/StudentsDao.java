package com.southeast.iLoveMasami.service;

import java.util.List;

import com.southeast.iLoveMasami.entity.Students;

/**
 * 学生的业务逻辑接口
 * 
 * @author iLoveMasami
 * @date 2018年1月11日 上午11:55:46
 */
public interface StudentsDao {
	// 查询所有学生
	public List<Students> queryAllStudents();

	// 根据学生编号查询学生资料
	public Students queryStudentsBySid(String sid);

	// 添加学生资料
	public boolean addStudents(Students s);

	// 修改学生资料
	public boolean updateStudents(Students s);

	// 删除学生资料
	public boolean deleteStudents(String sid);
}
