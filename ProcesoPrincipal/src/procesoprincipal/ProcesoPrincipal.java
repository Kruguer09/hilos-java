/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesoprincipal;

/**
 *
 * @author Usuario
 */
public class ProcesoPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            String[] infoProceso ={"java","C:\\Users\\Usuario\\Documents\\NetBeansProjects\\ProcesoPrincipal\\src\\procesoprincipal\\ProcesoSecundario.java"};
            Process proceso = Runtime.getRuntime().exec(infoProceso) ;
            int valorRetorno = proceso.waitFor();
            if (valorRetorno==0) {
                System.out.println("El proceso se ha completado satisfactoriamente");
            }else{
                System.out.println("El proceso ha fallado, codigo de error"+valorRetorno);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
