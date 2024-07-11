/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacionProcesos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Sumador {

    public static int sumar(int uno, int dos){
        int resultado=0;
         for(int i=uno;i<=dos;i++){
            resultado+=i;
        }
        return resultado;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int resultado=0;
        int numUno;
        int numDos;
        System.out.println("numero uno:");
        numUno=sc.nextInt();
        System.out.println("numero dos:");
        numDos=sc.nextInt();
        System.out.println(sumar(numUno,numDos));
    }
    
}
