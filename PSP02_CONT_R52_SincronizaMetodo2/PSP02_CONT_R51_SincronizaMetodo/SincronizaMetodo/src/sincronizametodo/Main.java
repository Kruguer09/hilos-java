/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sincronizametodo;
// @author IMCG
public class Main {

    public static void main(String[] args) {
        int numTerminales = 4;
        int numAccesos = 10;

        ServidorWeb[] servidores = new ServidorWeb[2]; // Simular 2 servidores
        for (int i = 0; i < servidores.length; i++) {
            servidores[i] = new ServidorWeb();
        }

        Hilo_Terminal[] hilosTerminales = new Hilo_Terminal[numTerminales];
        for (int i = 0; i < numTerminales; i++) {
            hilosTerminales[i] = new Hilo_Terminal("Terminal" + (i + 1), servidores, numAccesos);
            hilosTerminales[i].start();
        }
    }
    
}
