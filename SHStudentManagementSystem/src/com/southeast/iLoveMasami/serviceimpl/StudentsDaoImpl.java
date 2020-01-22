package com.southeast.iLoveMasami.serviceimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.southeast.iLoveMasami.db.MyHibernateSessionFactory;
import com.southeast.iLoveMasami.entity.Students;
import com.southeast.iLoveMasami.service.StudentsDao;
/**
 * 学生业务逻辑接口实现类
 * @author iLoveMasami
 * @date   2018年1月11日 下午12:01:17
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

		Transaction tx=null;
		Students s = null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			s = (Students) session.get(Students.class, sid);			
			
			return s;
		}
		catch(Exception ex){
			ex.printStackTrace();
			
			return s;
		}
		finally{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	@Override
	public boolean addStudents(Students s) {
		Transaction tx=null;
		s.setSid(getNewSid());//设置学生的学号
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		finally{
			if(tx!=null)
				tx=null;
		}
	}

	@Override
	public boolean updateStudents(Students s) {

		Transaction tx=null;		
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null)
				tx=null;
		}
	}
	

	@Override
	public boolean deleteStudents(String sid) {
		Transaction tx=null;
		try{
			//获得会话对象
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Students s=(Students) session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null)
				tx=null;
		}
	}
	
	private String getNewSid()
	{
		Transaction tx=null;
		String hql="";
		String sid=null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			//获得当前学生的最大编号
			hql = "select max(id) from Students";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			if(sid==null||sid.isEmpty())
			{
				//给一个默认的最大编号
				sid = "S001";
			}
			else{
				int oldNum = Integer.parseInt(sid.substring(1));
				oldNum++;
				String newNum = String.valueOf(oldNum);
				int numLen = newNum.length();
				for(int i=0;i<3-numLen;++i)
				{
					newNum='0'+newNum;
				}
				sid = 'S' + newNum;
			}
			tx.commit();
			return sid;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return null;
		}
		finally{
			if(tx!=null)
				tx=null;
		}
	}

}
