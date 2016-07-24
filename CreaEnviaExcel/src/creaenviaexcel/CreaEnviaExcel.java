package creaenviaexcel;

/**
 * @author sgomez
 */
public class CreaEnviaExcel {
    public static void main(String[] args) {
        CreaExcel op = new CreaExcel(args[0]);
        op.buscar();
        EnviaExcel.enviarCorreo(args[0]); 
    }
}
