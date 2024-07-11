/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jardinessincronizado;

// @author IMCG
public class Main {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        RecursoJardin jardin = new RecursoJardin();
        //crea un objeto RecursoJardín

        for (int i = 1; i <= 10; i++) {
            (new Entra_Jardin("Entra" + i, jardin)).start();
        }//entrada de 10 hilos al jardín

        for (int i = 1; i <= 15; i++) {
            (new Sale_Jardin("Sale" + i, jardin)).start();
        }//salida de 15 hilos al jardín
    }**/
    //mi version
    public static void main(String[] args) {
        RecursoJardin jardin = new RecursoJardin();
        int contadorentra = 0;
        int contadorsale = 0;
        //crea un objeto RecursoJardín
        while (jardin.getCuenta() < 101) {

            (new Entra_Jardin("Entra" + contadorentra, jardin)).start();
            contadorentra++;
        }

       
        while (jardin.getCuenta() > 50) {

            (new Sale_Jardin("Sale" + contadorsale, jardin)).start();
            contadorsale++;
        }
        //salida de 15 hilos al jardín
    }
}

