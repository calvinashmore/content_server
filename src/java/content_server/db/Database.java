package content_server.db;

import com.google.auto.value.AutoValue;
import com.google.inject.Inject;
import content_server.db.entity.ThingEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;

public class Database {

  private final SessionFactory sessionFactory;

  @Inject
  Database(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public <T> T execute(DbOperation<T> operation) throws DatabaseException {

    Session session = sessionFactory.openSession();
    try {
      Transaction transaction = session.beginTransaction();
      T result = operation.getCallable().execute(new DatabaseSession() {
        @Override
        public Session getSession() {
          return session;
        }
      });
      transaction.commit();
      return result;
    } catch (DatabaseException ex) {
      session.clear();
      throw ex;
    } finally {
      session.close();
    }
  }

  @AutoValue
  public static abstract class DbOperation<T> {
    public abstract String getName();
    public abstract DbCallable<T> getCallable();

    public static <T> DbOperation<T> create(String name, DbCallable<T> callable) {
      return new AutoValue_Database_DbOperation(name, callable);
    }
  }

  public abstract class DatabaseSession {
    public abstract Session getSession();

    public <T> Dao<T> getDao(Class<T> entityClass) {
      return new Dao<T>(getSession()) {
        @Override
        public Class<T> getEntityClass() {
          return entityClass;
        }
      };
    }
  }

  @FunctionalInterface
  public interface DbCallable<T> {
    T execute(DatabaseSession session) throws DatabaseException;
  }

  public class DatabaseException extends Exception {
  }

  public class RetriableDatabaseException extends DatabaseException {

  }
}
