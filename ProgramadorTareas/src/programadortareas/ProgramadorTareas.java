/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programadortareas;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class ProgramadorTareas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un ScheduledExecutorService con un único hilo
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Crear una tarea que se ejecutará cada 5 segundos
        Runnable tarea = () -> {
            System.out.println("¡La tarea se está ejecutando!");
        };

        // Programar la tarea para ejecutarse inicialmente después de 0 segundos
        // y luego cada 5 segundos
        scheduler.scheduleAtFixedRate(tarea, 0, 5, TimeUnit.SECONDS);

        // Esperar unos minutos para permitir que la tarea se ejecute varias veces
        try {
            Thread.sleep(60000); // Esperar 60 segundos (60,000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Apagar el programador de tareas después de haber esperado
        scheduler.shutdown();
    }
    
    
}
