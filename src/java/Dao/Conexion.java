package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

   private Connection cn;

   public void Conexion() {
       try {
           Class.forName("oracle.jdbc.OracleDriver");
           cn = DriverManager.getConnection("jdbc:oracle:thin:@35.237.73.4:1521:XE", "SOA", "vallegrande2018");
           System.out.println("Correcto");
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("Error: " + e);
       }
   }

   public void Cerrar() throws SQLException {      //Cerrar la coneccion
       if (cn != null) {
           if (cn.isClosed() == false) {
               cn.close();
           }
       }
   }

   public Connection getCn() {
       return cn;
   }

   public void setCn(Connection cn) {
       this.cn = cn;
   }

   public static void main(String[] args) {
       Conexion dao = new Conexion();
       dao.Conexion();
   }
}