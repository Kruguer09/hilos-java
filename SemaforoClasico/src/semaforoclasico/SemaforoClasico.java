/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semaforoclasico;

import java.util.concurrent.Semaphore;

/**
 *
 * @author USER
 */
public class SemaforoClasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        RecursoCompartido recurso = new RecursoCompartido();

        Incrementador incrementador = new Incrementador(recurso);
        Decrementador decrementador = new Decrementador(recurso);

        incrementador.start();
        decrementador.start();
    }
    
    
}
class RecursoCompartido {
    private int valor = 50;
    private Semaphore semaphore = new Semaphore(3);

    public void incrementar() throws InterruptedException {
        semaphore.acquire();
        valor++;
        System.out.println("Incrementado: " + valor);
        semaphore.release();
    }

    public void decrementar() throws InterruptedException {
        semaphore.acquire();
        valor--;
        System.out.println("Decrementado: " + valor);
        semaphore.release();
    }
}

class Incrementador extends Thread {
    private RecursoCompartido recurso;

    public Incrementador(RecursoCompartido recurso) {
        this.recurso = recurso;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                recurso.incrementar();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Decrementador extends Thread {
    private RecursoCompartido recurso;

    public Decrementador(RecursoCompartido recurso) {
        this.recurso = recurso;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                recurso.decrementar();
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
