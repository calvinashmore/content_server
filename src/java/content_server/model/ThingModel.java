package content_server.model;

import com.google.inject.Inject;
import content_server.db.Dao;
import content_server.db.Database;
import content_server.db.entity.ThingEntity;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class ThingModel {

  private final Database db;

  @Inject
  ThingModel(Database db) {
    this.db = db;
  }

  public void putThing(long id, String value) throws Database.DatabaseException {
    db.execute(Database.DbOperation.create("putThing", session -> {

      Dao<ThingEntity> dao = session.getDao(ThingEntity.class);

      ThingEntity thing = dao.read(id).orElseGet(() ->
          {
            ThingEntity newThing = new ThingEntity();
            newThing.setId(id);
            return dao.save(newThing);
          }
      );
      thing.setValue(value);

      return null;
    }));
  }

  public Optional<String> getThing(long id) throws Database.DatabaseException {
    return db.execute(Database.DbOperation.create("getThing",
        session -> session.getDao(ThingEntity.class).read(id).map(ThingEntity::getValue)));
  }

  public void clearThing(long id) {

  }
}
