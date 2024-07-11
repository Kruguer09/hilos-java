
package psp;

import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Ejemplo1 {
    public static void main(String[] args) throws IOException {
        lanzarPrograma("notepad.exe");
        lanzarPrograma("mspaint.exe");
        lanzarPrograma("write.exe");
        
    }

    static void lanzarPrograma(String comando){
        ProcessBuilder pb = new ProcessBuilder(comando);
        try {
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
        }
    }
}
