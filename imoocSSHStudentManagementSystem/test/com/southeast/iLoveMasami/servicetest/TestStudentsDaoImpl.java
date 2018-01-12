package com.southeast.iLoveMasami.servicetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.southeast.iLoveMasami.entity.Students;
import com.southeast.iLoveMasami.service.StudentsDao;
import com.southeast.iLoveMasami.serviceimpl.StudentsDaoImpl;

import junit.framework.Assert;

public class TestStudentsDaoImpl {
	@Test
	public void testqueryAllStudents(){
		StudentsDao sDao = new StudentsDaoImpl();
		List<Students> list = sDao.queryAllStudents();
		for(Students students : list){
			System.out.println(students);
		}
	}
	@Test
	public void testGetNewSid()
	{
		StudentsDaoImpl sDao = new StudentsDaoImpl();
		//System.out.println(sDao.getNewSid());
	}
	@Test
	public void testAddStudents()
	{
		Students s = new Students();
		s.setSname("长泽雅美");
		s.setGender("女");
		String dateString = "1987-06-03";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(dateString);
			s.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		s.setAddress("静冈县");
		StudentsDao sDao = new StudentsDaoImpl();
		Assert.assertEquals(true, sDao.addStudents(s));
	}
	
}
