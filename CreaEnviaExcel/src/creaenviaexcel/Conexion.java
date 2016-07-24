package creaenviaexcel;

import java.sql.Connection;
import java.sql.DriverManager;
import parametro.Parametro;
public class Conexion
{
    
  public static Connection getConnection(String ruta) throws Exception {
      String ArcPara = ruta + "Parametros/ParConx.txt";
      Parametro variable = new Parametro(); 
      String host = variable.leer(ArcPara,"HOST");
      String base = variable.leer(ArcPara,"BASE");
      String user = variable.leer(ArcPara,"USER");
      String cont = variable.leer(ArcPara,"CONT");
      Connection cnx = null;
      Class.forName("com.mysql.jdbc.Driver");
      cnx = DriverManager.getConnection("jdbc:mysql://" + host + "/" + base, user, cont);
      return cnx;
  }
} 