/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package planificacionejercicios;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author USER
 */
public class PlanificacionEjercicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un temporizador
        Timer timer = new Timer();

        // Crear tarea programada para recordar al usuario cada 30 minutos
        TimerTask recordatorioTarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("¡Levántate y estira las piernas!");

                // Mostrar notificación del sistema operativo
                mostrarNotificacion("Ejercicio", "Levántate y estira las piernas");
            }
        };

        // Programar la tarea para ejecutarse cada 30 minutos (en milisegundos)
        timer.schedule(recordatorioTarea, 0, 30 * 60 * 1000);
    }

    // Método para mostrar notificación del sistema operativo
    private static void mostrarNotificacion(String titulo, String mensaje) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image icono = Toolkit.getDefaultToolkit().getImage("icono.png"); // Reemplaza con la ruta de tu icono

            TrayIcon trayIcon = new TrayIcon(icono, titulo);
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip(titulo);

            try {
                tray.add(trayIcon);
                trayIcon.displayMessage(titulo, mensaje, TrayIcon.MessageType.INFO);
            } catch (AWTException e) {
                System.err.println("Error al mostrar la notificación del sistema: " + e.getMessage());
            }
        } else {
            System.err.println("La funcionalidad de la bandeja del sistema no es compatible en este sistema.");
        }
    }
    
}
