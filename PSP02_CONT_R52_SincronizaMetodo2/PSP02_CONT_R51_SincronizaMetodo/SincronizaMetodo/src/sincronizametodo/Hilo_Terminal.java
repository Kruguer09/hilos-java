/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sincronizametodo;

// @author IMCG

public class Hilo_Terminal extends Thread {
    private ServidorWeb[] servidores;
    private int numAccesos;

    public Hilo_Terminal(String nombre, ServidorWeb[] servidores, int numAccesos) {
        super(nombre);
        this.servidores = servidores;
        this.numAccesos = numAccesos;
    }

    @Override
    public void run() {
        for (int i = 1; i <= numAccesos; i++) {
            int servidorIndex = i % servidores.length; // Rotar entre los servidores
            servidores[servidorIndex].incrementaCuenta(getName());
            yield();
        }
    }
}
