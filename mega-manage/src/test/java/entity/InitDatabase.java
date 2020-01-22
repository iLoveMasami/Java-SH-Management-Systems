package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import java.util.EnumSet;

/**
 * @author yuzhezhu
 * @date 2020/01/22
 **/
public class InitDatabase {

  @Test
  public void createDatabase() {
    // 创建配置对象
    Configuration config = new Configuration().configure();
    // 创建服务注册对象
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
    MetadataImplementor metadataImplementor = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();
    // 创建sessionFactory
    SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
    // 创建session对象
    Session session = sessionFactory.getCurrentSession();
    // 创建SchemaExport对象
    SchemaExport export = new SchemaExport();
    export.create(EnumSet.of(TargetType.DATABASE), metadataImplementor);
//    export.create(true, true);
  }
}
