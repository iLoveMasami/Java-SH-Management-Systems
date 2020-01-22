package entity;

import com.ilovemasami.entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import java.util.Date;
import java.util.EnumSet;

/**
 * @author yuzhezhu
 * @date 2020/01/22
 **/
public class InitDatabase {

  @Test
  public void createDatabase() {
    // https://blog.csdn.net/weixin_38159114/article/details/81384758
    // https://blog.csdn.net/tangbin0505/article/details/81869707
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
    SchemaExport schemaExport = new SchemaExport();
    schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
  }

  @Test
  public void createStudents() {
    Configuration config = new Configuration().configure();
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
    SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
    Session session = sessionFactory.getCurrentSession();
    Transaction tx=session.beginTransaction();

    Students s2=new Students("S002","xiaozhuzhu","female",new Date(),"Japan");
    Students s1 = new Students("S001","yuzhezhu","male",new Date(),"China");
    session.save(s1);
    session.save(s2);
    tx.commit();
    sessionFactory.close();
  }
}
