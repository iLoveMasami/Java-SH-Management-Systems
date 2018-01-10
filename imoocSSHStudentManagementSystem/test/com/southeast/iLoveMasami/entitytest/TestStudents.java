package com.southeast.iLoveMasami.entitytest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudents {
	@Test
	public void testSchemaExport() {
		// �������ö���
		Configuration config = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		// ����sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//����session����
		Session session=sessionFactory.getCurrentSession();
		//����SchemaExport����
		SchemaExport export=new SchemaExport(config);
		export.create(true, true);
		
	}
}
