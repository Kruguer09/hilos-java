/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_2_5_sincronizadores;

import java.util.concurrent.Exchanger;

/**
 *
 * @author USER
 */
public class TareaA implements Runnable{
    private final Exchanger<String> exchanger;

    public TareaA(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            /// Preparamospara mandar un mensage.            
            String mensajeTareaA = "Mensaje desde TareaA";
            System.out.println("TareaA: Enviando mensaje - " + mensajeTareaA);

            // Intercambia Intercambia mensages con tareaB
            String mensajeRecibido = exchanger.exchange(mensajeTareaA);

            System.out.println("TareaA: Recibido mensaje de TareaB - " + mensajeRecibido);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
