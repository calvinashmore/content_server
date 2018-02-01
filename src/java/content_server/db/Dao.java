package content_server.db;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public abstract class Dao<T> {

  private final Session session;

  Dao(Session session) {
    this.session = session;
  }

  public abstract Class<T> getEntityClass();

  // can be overridden
  public String getIdColumnName() {
    return "id";
  }

  // Everything has long IDs by de-facto
  public Optional<T> read(long id) {
    CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(getEntityClass());
    Root<T> root = query.from(getEntityClass());
    query.select(root).where(session.getCriteriaBuilder().equal(root.get(getIdColumnName()), id));

    Query<T> query1 = session.createQuery(query);
    return query1.list().stream().findAny();
  }

  public T save(T entity) {
    session.persist(entity);
    return entity;
  }
}
