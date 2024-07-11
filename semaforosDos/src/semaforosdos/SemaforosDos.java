/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforosdos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Usuario
 */
public class SemaforosDos {
    private static final Semaphore semaforoMetodo1 = new Semaphore(2);
    private static final Semaphore semaforoMetodo2 = new Semaphore(2);
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MetodoRunUno());
        Thread thread2 = new Thread(new MetodoRunUno());
        Thread thread3 = new Thread(new MetodoRunDos());
        Thread thread4 = new Thread(new MetodoRunDos());

        
        Thread thread5 = new Thread(new MetodoRunUno());
        Thread thread6 = new Thread(new MetodoRunUno());
        Thread thread7 = new Thread(new MetodoRunDos());
        Thread thread8 = new Thread(new MetodoRunDos());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
    }

    static class MetodoRunUno implements Runnable {
        @Override
        public void run() {
            try {
                semaforoMetodo1.acquire();
                System.out.println(Thread.currentThread().getName() + " ejecutando metodo 1");
                Thread.sleep(2000); // Simulate work
                System.out.println(Thread.currentThread().getName() + " metodo 1 terminado");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforoMetodo1.release();
            }
        }
    }

    static class MetodoRunDos implements Runnable {
        @Override
        public void run() {
            try {
                semaforoMetodo2.acquire();
                System.out.println(Thread.currentThread().getName() + " ejecutando metodo 2");
                Thread.sleep(2000); // Simulate work
                System.out.println(Thread.currentThread().getName() + " metodo 2 terminado");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforoMetodo2.release();
            }
        }
    }
    
}
