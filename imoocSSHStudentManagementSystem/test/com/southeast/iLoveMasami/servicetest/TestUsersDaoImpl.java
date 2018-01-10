package com.southeast.iLoveMasami.servicetest;

import org.junit.Test;

import com.southeast.iLoveMasami.entity.Users;
import com.southeast.iLoveMasami.service.UsersDao;
import com.southeast.iLoveMasami.serviceimpl.UsersDaoImpl;

import junit.framework.Assert;

public class TestUsersDaoImpl {
	@Test
	public void testUsersLogin()
	{
		Users u= new Users(1,"iLoveMasami","1234");
		UsersDao uDao=new UsersDaoImpl();
		Assert.assertEquals(true, uDao.usersLogin(u));
	}
}
