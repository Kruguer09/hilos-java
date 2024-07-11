/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacionProcesos;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class LanzadorJava {

    public void LanzarSumador(Integer n1, Integer n2, String ficheroResultado) throws IOException{
        String clase="comunicacionProcesos.Sumador";
        ProcessBuilder pb = new ProcessBuilder("java", clase, n1.toString(),n2.toString());
        pb.directory(new File("build/classes"));
        pb.redirectError(new File ("errores.txt"));
        pb.redirectOutput(new File(ficheroResultado));
        pb.start();
    }
    public static void main(String[] args) throws IOException {
        LanzadorJava uno =new LanzadorJava();
        uno.LanzarSumador(1, 5, "resultado.txt");
        
    }
    
}
