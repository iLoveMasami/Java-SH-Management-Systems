package com.ilovemasami.service.impl;

import com.ilovemasami.dao.HibernateSessionFactory;
import com.ilovemasami.entity.Students;
import com.ilovemasami.service.StudentService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class StudentServiceImpl implements StudentService {

  @Override
  public List<Students> queryAllStudents() {
    Transaction tx = null;
    List<Students> list = null;
    String hql = "";
    try {
      Session session = HibernateSessionFactory.getInstance().getSessionFactory()
          .getCurrentSession();
      session.beginTransaction();
      hql = "from Students";
      Query query = session.createQuery(hql);
      list = query.list();
      return list;
    } catch (Exception ex) {
      ex.printStackTrace();
      return list;
    } finally {
      if (tx != null) {
        tx = null;
      }
    }
  }

  @Override
  public Students queryStudentBySid(String sid) {
    Transaction tx = null;
    Students s = null;
    try {
      Session session = HibernateSessionFactory.getInstance().getSessionFactory()
          .getCurrentSession();
      session.beginTransaction();
      s = (Students) session.get(Students.class, sid);
      return s;
    } catch (Exception ex) {
      ex.printStackTrace();
      return s;
    } finally {
      if (tx != null) {
        tx = null;
      }
    }
  }

  @Override
  public boolean addStudent(Students s) {
    Transaction tx = null;
    s.setSid(getNewSid());//设置学生的学号
    try {
      Session session = HibernateSessionFactory.getInstance().getSessionFactory()
          .getCurrentSession();
      tx = session.beginTransaction();
      session.save(s);
      tx.commit();
      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      tx.rollback();
      return false;
    } finally {
      if (tx != null) {
        tx = null;
      }
    }
  }

  @Override
  public boolean updateStudent(Students s) {
    Transaction tx = null;
    try {
      Session session = HibernateSessionFactory.getInstance().getSessionFactory()
          .getCurrentSession();
      tx = session.beginTransaction();
      session.update(s);
      tx.commit();
      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      tx.rollback();
      return false;
    } finally {
      if (tx != null) {
        tx = null;
      }
    }
  }

  @Override
  public boolean deleteStudent(String sid) {
    Transaction tx = null;
    try {
      Session session = HibernateSessionFactory.getInstance().getSessionFactory()
          .getCurrentSession();
      tx = session.beginTransaction();
      Students s = (Students) session.get(Students.class, sid);
      session.delete(s);
      tx.commit();
      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      tx.rollback();
      return false;
    } finally {
      if (tx != null) {
        tx = null;
      }
    }
  }

  private String getNewSid() {
    Transaction tx = null;
    String hql = "";
    String sid = null;
    try {
      Session session = HibernateSessionFactory.getInstance().getSessionFactory()
          .getCurrentSession();
      tx = session.beginTransaction();
      //获得当前学生的最大编号
      hql = "select max(id) from Students";
      Query query = session.createQuery(hql);
      sid = (String) query.uniqueResult();
      if (sid == null || sid.isEmpty()) {
        //给一个默认的最大编号
        sid = "S001";
      } else {
        int oldNum = Integer.parseInt(sid.substring(1));
        oldNum++;
        String newNum = String.valueOf(oldNum);
        int numLen = newNum.length();
        for (int i = 0; i < 3 - numLen; ++i) {
          newNum = '0' + newNum;
        }
        sid = 'S' + newNum;
      }
      tx.commit();
      return sid;
    } catch (Exception ex) {
      ex.printStackTrace();
      tx.rollback();
      return null;
    } finally {
      if (tx != null) {
        tx = null;
      }

    }
  }
}
