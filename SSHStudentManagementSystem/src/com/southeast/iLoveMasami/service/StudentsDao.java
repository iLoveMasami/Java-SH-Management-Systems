package com.southeast.iLoveMasami.service;

import java.util.List;

import com.southeast.iLoveMasami.entity.Students;

/**
 * ѧ����ҵ���߼��ӿ�
 * 
 * @author iLoveMasami
 * @date 2018��1��11�� ����11:55:46
 */
public interface StudentsDao {
	// ��ѯ����ѧ��
	public List<Students> queryAllStudents();

	// ����ѧ����Ų�ѯѧ������
	public Students queryStudentsBySid(String sid);

	// ���ѧ������
	public boolean addStudents(Students s);

	// �޸�ѧ������
	public boolean updateStudents(Students s);

	// ɾ��ѧ������
	public boolean deleteStudents(String sid);
}
