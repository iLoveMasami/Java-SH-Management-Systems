package com.ilovemasami.service.impl;

import com.ilovemasami.dao.HibernateSessionFactory;
import com.ilovemasami.entity.Users;
import com.ilovemasami.service.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class UserServiceImpl implements UserService {
  @Override
  public boolean usersLogin(Users u) {
    Transaction tx = null;
    String hql = "";
    try {
      Session session = HibernateSessionFactory.getInstance().getSessionFactory().getCurrentSession();
      tx = session.beginTransaction();
      // 占位符更新 https://blog.csdn.net/Z_Dalao/article/details/84891149
      hql = "from Users where username=?0 and password=?1";
      Query query = session.createQuery(hql);
      query.setParameter(0, u.getUsername());
      query.setParameter(1, u.getPassword());
      List list = query.list();
      tx.commit();
      if (list.size() > 0) {
        return true;
      } else {
        return false;
      }
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
