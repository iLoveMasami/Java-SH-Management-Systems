package com.southeast.iLoveMasami.serviceimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.southeast.iLoveMasami.db.MyHibernateSessionFactory;
import com.southeast.iLoveMasami.entity.Users;
import com.southeast.iLoveMasami.service.UsersDao;

public class UsersDaoImpl implements UsersDao {

	@Override
	public boolean usersLogin(Users u) {

		// 创建事务对象
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			//提交事务
			tx.commit();
			if (list.size() > 0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
