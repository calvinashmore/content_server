package content_server;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseThing {

  public void connect() throws Exception {

    String databaseName = "stuff";
    String instanceConnectionName = "primal-gear-188300:us-central1:toast";
    String username = "root";
    String password = "rootrootroot";

    String jdbcUrl = String.format(
        "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
            + "socketFactory=com.google.cloud.sql.mysql.SocketFactory",
        databaseName,
        instanceConnectionName);

    Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

    System.out.println(connection.getSchema());
    connection.close();
  }
}
