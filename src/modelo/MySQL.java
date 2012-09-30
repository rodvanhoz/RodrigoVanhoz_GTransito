package modelo;

import java.sql.*;

public class MySQL {

    String DRIVER_JDBC;
    String DATABASE;
    String table;
    public Connection connection = null;
    public Statement  statement  = null;

    public MySQL (String table){
      this.table = table;
      this.DRIVER_JDBC = "com.mysql.jdbc.Driver";
      this.DATABASE    = "jdbc:mysql://localhost/gtransito";
    }

    public MySQL (String table, String st1, String st2){
      this.DRIVER_JDBC = st1;
      this.DATABASE    = st2;
    }

    public void abrebanco () {
      try
      {
        Class.forName(DRIVER_JDBC);
        connection = DriverManager.getConnection(DATABASE,"root","rootroot");
        statement = connection.createStatement();
      } catch (ClassNotFoundException classNotFound) {
        classNotFound.printStackTrace();
      } catch (SQLException exception) {
        exception.printStackTrace();
      }
    }

    public ResultSet consultar(){

      try {
        return statement.executeQuery("SELECT * FROM "+this.table);
      } catch (SQLException exception){
        exception.printStackTrace();
        return null;
      }
    }

   public ResultSet consultar(String SQL){

      try {
        return statement.executeQuery(SQL);
      } catch (SQLException exception){
        exception.printStackTrace();
        return null;
      }
    }

    public int tamanho(){

      try {
        ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS NRO FROM "+this.table);
        rs.first();
        return rs.getInt("NRO");

      } catch (SQLException exception){

          exception.printStackTrace();
          return 0;
      }
    }

    public void fechabanco () {

      try {
        if (statement  != null) statement.close ();
        if (connection != null) connection.close();
      }
      catch (Exception exception) {
        exception.printStackTrace();
        System.exit(1);
      }
    }

}
