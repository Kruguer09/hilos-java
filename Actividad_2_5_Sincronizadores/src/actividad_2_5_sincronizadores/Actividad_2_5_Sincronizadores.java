/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad_2_5_sincronizadores;

import java.util.concurrent.Exchanger;

/**
 *
 * @author USER
 */
public class Actividad_2_5_Sincronizadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Exchanger<String> exchanger = new Exchanger<>();

        // Crear instancias de TareaA y TareaB
        Runnable tareaA = new TareaA(exchanger);
        Runnable tareaB = new TareaB(exchanger);

        // Crear threads para ejecutar las tareas simultáneamente
        Thread threadA = new Thread(tareaA);
        Thread threadB = new Thread(tareaB);

        // Iniciar los threads
        threadA.start();
        threadB.start();
    }
    //utilizo las dos clases  runnables creadas para que creen e intercambien mensajes con la clase exchanger
    //en el resultado se ve como cada clase intercambia el  mensaje
}
