/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp;

import java.io.IOException;
import java.lang.System.Logger;

/**
 *
 * @author Usuario
 */
public class Ejemplo1Runtime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Runtime r =Runtime.getRuntime();
       String comando="notepad";
       Process p;
       try{
           p=r.exec(comando);
       }catch(IOException ex){
           System.out.println("Error en :" + comando);

       }
    }
    
}
