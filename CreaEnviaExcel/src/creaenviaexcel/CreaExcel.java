package creaenviaexcel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import parametro.Parametro;
public class CreaExcel
{
  private String archivoRuta;
  public CreaExcel(String archivo) {
     
    this.archivoRuta = archivo;
    
  }  
  
    public boolean buscar()
  {
    boolean resultado = false;
    String ArcPara = this.archivoRuta + "Parametros/ParExcel.txt";
    try
    {
      Parametro variable = new Parametro(); 
      String nombre = variable.leer(ArcPara,"NOMARCHIVO");
      File archivo = new File(nombre);
      if (archivo.exists()) {
        archivo.delete();
        System.out.println("Archivo Anterior Eliminado ");
      }
      Connection cnx = Conexion.getConnection(this.archivoRuta);
      String SP = variable.leer(ArcPara,"SP");
      PreparedStatement smt = cnx.prepareStatement(SP);
      ResultSet res = smt.executeQuery();
      BufferedWriter escritura = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombre), "ISO-8859-1"));
      int larExl = Integer.parseInt(variable.leer(ArcPara,"LAREXL"));
      String campos="";
      for(int i=1;i<=larExl;i++){
          campos = campos + variable.leer(ArcPara,"CAMEXCEL",i)+ "; ";
      }
      //System.out.println(campos);
      escritura.write(campos);
      escritura.newLine();
      while (res.next()) {
        resultado = true;
        String cambd="";
        for(int i=1;i<=larExl;i++){
          cambd = cambd + res.getString(variable.leer(ArcPara,"CAMBD",i))+ ";";
        }
        //System.out.println(cambd);
        escritura.write(cambd);
        escritura.newLine();
      }
      escritura.close();

      res.close();
      smt.close();
      cnx.close();
      System.out.println(" Reporte de Proyectos con desviación Creado Satisfactoriamente");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return resultado;
  }
    
    
}