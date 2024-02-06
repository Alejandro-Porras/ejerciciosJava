package ud04;

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        double[] v = new double[10];
        for (int i = 0; i < v.length; i++) {
            System.out.println("Introduzca altura de la persona" + (i+1));  
            v[i]=entrada.nextDouble();      
        }

        for (int i = 0; i < v.length; i++) {
            System.out.println("Persona " + (i+1) + ": " + v[i] + "m");
        }
        entrada.close();
    }
    
}
