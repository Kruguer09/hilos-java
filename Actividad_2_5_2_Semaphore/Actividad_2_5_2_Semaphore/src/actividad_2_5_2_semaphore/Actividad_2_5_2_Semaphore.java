/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad_2_5_2_semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author USER
 */
public class Actividad_2_5_2_Semaphore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creun semaforo con dos permisos de acceso
        Semaphore semaforo = new Semaphore(2);

        // Creo un grupo de 10 hilos
        Thread[] hilos = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Runnable tarea = new Tarea(semaforo);
            hilos[i] = new Thread(tarea);
            hilos[i].start();
        }

        // Para esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Salida cuando han terminado los hilos
        System.out.println("Todos los hilos han terminado de acceder al recurso.");
    }
    
    
}
