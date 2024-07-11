/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jardinessincronizado;

// @author IMCG

public class RecursoJardin {
//clase que simula las entradas y las salidas al Jardín
    private int cuenta; //para contar las entradas y salidas al Jardín
    public RecursoJardin() {
        cuenta = 100; //inicalmente hay 100 personas en le jardín
    }
    public synchronized void incrementaCuenta() {
        //método que increamenta en 1 la varibale cuenta
        System.out.println("hilo " + Thread.currentThread().getName()
                + "----- Entra en Jardín");
        //muestra el hilo que entra en el método
        cuenta++;
        System.out.println(cuenta + " en jardín");
        //cuenta cada acceso al jardín y muestra el número de accesos
    }
   public synchronized void  decrementaCuenta() {
        //método que decrementa en 1 la varibale cuenta
        System.out.println("hilo " + Thread.currentThread().getName()
                + "----- Sale de Jardín");
        //muestra el hilo que sale en el método
        cuenta--;
        System.out.println(cuenta + " en jardín");
        //cuenta cada acceso al jardín y muestra el número de accesos
    }
   public synchronized void podaJardin() {
        // Método para la poda del jardín
        System.out.println("Inicia la poda del jardín...");

        // Verifica que el jardín esté vacío antes de realizar la poda
        while (cuenta > 0) {
            try {
                System.out.println("Esperando a que el jardín esté vacío para la poda...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Realiza la poda
        System.out.println("Realizando la poda del jardín...");

        // Simula la poda (puedes realizar acciones específicas de poda aquí)

        // Notifica que la poda ha terminado
        System.out.println("Poda del jardín completada.");
        notifyAll();
    }
}
