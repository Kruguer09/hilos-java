/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassTimer;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Usuario
 */
public class SistemaRiego extends TimerTask {
    private static final int MAX_EJECUCIONES = 10;
    private int contadorEjecuciones = 0;

    @Override
    public void run() {
        contadorEjecuciones++;
        System.out.println("Regando...");

        if (contadorEjecuciones == MAX_EJECUCIONES) {
            // Cancela la tarea después de 10 ejecuciones
            cancel();
            System.out.println("Tarea de riego cancelada después de 10 ejecuciones.");
        }
    }

    public static void main(String[] args) {
        Timer temporizador = new Timer();
        temporizador.schedule(new SistemaRiego(), 1000, 2000);
    }
}
