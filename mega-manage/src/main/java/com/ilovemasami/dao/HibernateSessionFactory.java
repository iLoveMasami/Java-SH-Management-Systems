package com.ilovemasami.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class HibernateSessionFactory {
  private static SessionFactory sessionFactory;

  private HibernateSessionFactory() {
    if (sessionFactory == null) {
      Configuration config = new Configuration().configure();
      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
      sessionFactory = config.buildSessionFactory(serviceRegistry);
    }
  }

  private static class HibernateSessionInner {
    private static HibernateSessionFactory sessionFactory = new HibernateSessionFactory();
  }


  public static HibernateSessionFactory getInstance() {
    return HibernateSessionInner.sessionFactory;
  }

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

}
