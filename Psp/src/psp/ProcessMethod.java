/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class ProcessMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        //arrancamos proceso
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe");
        Process p = pb.start();
        //verificar que está en ejecucion
        System.out.println(p.isAlive());
        //conocer id
        System.out.println(p.pid());
        //esperar 10 sg
        p.waitFor(10, TimeUnit.SECONDS);
        p.destroy();
        System.out.println(p.exitValue());
                
        
    }
    
}
