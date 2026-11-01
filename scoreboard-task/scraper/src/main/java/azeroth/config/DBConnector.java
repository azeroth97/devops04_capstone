package azeroth.config;
import java.sql.*;

public class DBConnector {
  private String psqlDB = "jdbc:postgresql://database:5432/scoreboard";
  private String user = "postgres";
  private String password = "postgres";

  public Connection psqlConnect() throws SQLException{
    return DriverManager.getConnection(psqlDB, user, password);
  }
}
