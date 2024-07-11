/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesoprincipal;

import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class procesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ProcessBuilder pBuilder = new ProcessBuilder ("Notepad.exe");
        for (int i=0;i<5;i++) {
            String salida=pBuilder.toString();
            System.out.println(salida);
            
            pBuilder.start();
          
        }
    }
    
}
