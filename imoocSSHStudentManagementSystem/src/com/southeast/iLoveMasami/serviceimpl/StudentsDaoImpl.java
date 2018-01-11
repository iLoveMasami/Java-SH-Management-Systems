package com.southeast.iLoveMasami.serviceimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.southeast.iLoveMasami.db.MyHibernateSessionFactory;
import com.southeast.iLoveMasami.entity.Students;
import com.southeast.iLoveMasami.service.StudentsDao;
/**
 * ѧ��ҵ���߼��ӿ�ʵ����
 * @author iLoveMasami
 * @date   2018��1��11�� ����12:01:17
 */
public class StudentsDaoImpl implements StudentsDao {

	@Override
	public List<Students> queryAllStudents() {
		Transaction tx=null;
		List<Students> list=null;
		String hql="";
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			hql="from Students";
			Query query=session.createQuery(hql);
			list=query.list();
			//tx.commit();
			return list;
		}
		catch(Exception ex){
			ex.printStackTrace();
			//tx.commit();
			return list;
		}
		finally{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	@Override
	public Students queryStudentsBySid(String sid) {

		return null;
	}

	@Override
	public boolean addStudents(Students s) {

		return false;
	}

	@Override
	public boolean updateStudents(Students s) {

		return false;
	}

	@Override
	public boolean deleteStudents(String sid) {

		return false;
	}

}
