/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productorconsumidorclasico;

import java.util.LinkedList;

/**
 *
 * @author USER
 */
public class ProductorConsumidorClasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecursoCompartido recurso = new RecursoCompartido();

        Productor productor = new Productor(recurso);
        Consumidor consumidor = new Consumidor(recurso);

        productor.start();
        consumidor.start();
    }
    
}
class RecursoCompartido {
    private final int CAPACIDAD_MAXIMA = 1000;
    private LinkedList<Integer> buffer = new LinkedList<>();

    public synchronized void producir(int producto) throws InterruptedException {
        while (buffer.size() == CAPACIDAD_MAXIMA) {
            wait(); // Espera si el buffer está lleno
        }

        buffer.add(producto);
        System.out.println("Productor" +Thread.currentThread().getName()+" produce: " + producto + ", tamaño del buffer: " + buffer.size());

        notifyAll(); // Notifica a los consumidores que hay nuevos productos disponibles
    }

    public synchronized int consumir() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // Espera si el buffer está vacío
        }

        int producto = buffer.remove();
        System.out.println("Consumidor " +Thread.currentThread().getName()+"consume: " + producto + ", tamaño del buffer: " + buffer.size());

        notifyAll(); // Notifica a los productores que hay espacio disponible en el buffer

        return producto;
    }
}

class Productor extends Thread {
    private RecursoCompartido recurso;

    public Productor(RecursoCompartido recurso) {
        this.recurso = recurso;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                recurso.producir(i);
                Thread.sleep(50); // Simula la producción de un producto
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumidor extends Thread {
    private RecursoCompartido recurso;

    public Consumidor(RecursoCompartido recurso) {
        this.recurso = recurso;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                recurso.consumir();
                Thread.sleep(100); // Simula el consumo de un producto
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}