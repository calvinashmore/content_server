package content_server.db;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import content_server.db.entity.ThingEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DatabaseModule extends AbstractModule {

  static final String HIBERNATE_CONFIG_FILE = "java/content_server/db/hibernate.cfg.xml";

  @Override
  protected void configure() {
  }

  @Provides
  Configuration provideHibernateConfiguration() {
    return new Configuration()
        .configure(HIBERNATE_CONFIG_FILE);
  }

  @Provides
  public SessionFactory provideSessionFactory(Configuration configuration) {
    return configuration.buildSessionFactory();
  }
}
