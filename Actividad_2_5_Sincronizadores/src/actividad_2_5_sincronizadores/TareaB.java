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
public class TareaB implements Runnable {
    private final Exchanger<String> exchanger;

    public TareaB(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            // Preparamospara mandar un mensage.
            String mensajeTareaB = "Mensaje desde TareaB";
            System.out.println("TareaB: Enviando mensaje - " + mensajeTareaB);

            // Intercambia mensages con tareaA
            String mensajeRecibido = exchanger.exchange(mensajeTareaB);

            System.out.println("TareaB: Recibido mensaje de TareaA - " + mensajeRecibido);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
