/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemariego;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class SistemaRiego implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaRiego sr=new SistemaRiego();
        ScheduledExecutorService stp = Executors.newSingleThreadScheduledExecutor();
        stp.scheduleAtFixedRate(sr, 1, 2, TimeUnit.SECONDS) ;
        System.out.println("Sistema de riego configurado.");
    }

    @Override
    public void run() {
        System.out.println("Regando...");
    }
    
}
