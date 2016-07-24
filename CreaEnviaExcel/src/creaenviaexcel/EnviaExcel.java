
package creaenviaexcel;

import enviocorreo.EnvioCorreo;
import java.io.File;
import parametro.Parametro;

public class EnviaExcel {
    public static void enviarCorreo(String ruta) {
        String ArcParaC = ruta + "Parametros/ParExcel.txt";
        String ArcPara  = ruta + "Parametros/ParCorreo.txt";
        Parametro variable = new Parametro(); 
        String asunto	= variable.leer(ArcPara,"ASUNTO");
        String para	= variable.leer(ArcPara,"PARA");
        String cuerpo	= variable.leer(ArcPara,"CUERPO");
        String[] copia	= variable.leer(ArcPara,"COPIA").split(",");
        String[] copiao	= variable.leer(ArcPara,"COPIAO").split(",");
        String[] archivo= variable.leer(ArcParaC,"NOMARCHIVO").split(",");
        System.out.println(cuerpo);
        EnvioCorreo correo = new EnvioCorreo(); 
        String respuesta = correo.Envio(asunto,para,cuerpo,copia,copiao,archivo);
        System.out.println("correo: "+ respuesta);
        
    }
    
}
