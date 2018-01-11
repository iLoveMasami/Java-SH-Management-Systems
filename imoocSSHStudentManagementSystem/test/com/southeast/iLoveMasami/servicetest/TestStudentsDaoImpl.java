package com.southeast.iLoveMasami.servicetest;

import java.util.List;

import org.junit.Test;

import com.southeast.iLoveMasami.entity.Students;
import com.southeast.iLoveMasami.service.StudentsDao;
import com.southeast.iLoveMasami.serviceimpl.StudentsDaoImpl;

public class TestStudentsDaoImpl {
	@Test
	public void testqueryAllStudents(){
		StudentsDao sDao = new StudentsDaoImpl();
		List<Students> list = sDao.queryAllStudents();
		for(Students students : list){
			System.out.println(students);
		}
	}
	
}
