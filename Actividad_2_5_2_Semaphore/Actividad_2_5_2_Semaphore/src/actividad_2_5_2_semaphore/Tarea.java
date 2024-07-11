/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_2_5_2_semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author USER
 */
public class Tarea implements Runnable{
    private final Semaphore semaforo;


    public Tarea(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            // Adquirir un permiso del semáforo
            semaforo.acquire();
            
            // Acceder al recurso compartido
            RecursoCompartido.recurso++;
            

            // Simular alguna tarea con el recurso
            Thread.sleep(100);

            // Liberar el permiso del semáforo
            semaforo.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
