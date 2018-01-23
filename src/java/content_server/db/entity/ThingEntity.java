package content_server.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Thing")
public class ThingEntity {

  private long id;
  private String value;

  public ThingEntity() {}

  @Id
  @Column(name = "id", nullable = false)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
