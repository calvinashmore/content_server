package content_server.db;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.util.EnumSet;

public class SchemaExporter {
  public static void main(String[] args) {
    SchemaExport schemaExport = new SchemaExport();

    StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
        .configure(DatabaseModule.HIBERNATE_CONFIG_FILE);
    MetadataSources metadataSources = new MetadataSources(registryBuilder.build());

    schemaExport.execute(EnumSet.of(TargetType.STDOUT), SchemaExport.Action.BOTH, metadataSources.buildMetadata());

  }
}
