/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Usuario
 */
public class Ejemplo2Runtime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Runtime r=Runtime.getRuntime();
        String comando="CMD /C  DIR";
        Process p =r.exec(comando);
        InputStream is=p.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String salida;
        while((salida=br.readLine()) !=null) System.out.println(salida);
    }
    
}
