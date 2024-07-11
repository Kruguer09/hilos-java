/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sincronizametodo;

// @author IMCG
public class ServidorWeb {
    //clase que simula los accesos a un servidor
    private int cuenta;
    public ServidorWeb() {
        cuenta = 0;
    }
    public synchronized void  incrementaCuenta() {
        incrementaCuenta(getName());
    }

    public synchronized void incrementaCuenta(String name) {
        //método sincronizado (monitor)
        System.out.println("hilo " + Thread.currentThread().getName()
                + "----- Entra en Servidor");
        //muestra le hilo que entra en el método
        cuenta++;
        System.out.println(cuenta + " accesos");
        //cuenta cada acceso al servidor y muestra el número de accesos
    }

    private String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
