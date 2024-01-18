package ud03;

import java.util.Scanner;

public class Ejercicio43 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String cadena;
        do {
            System.out.print("Introduce una cadena: ");
            cadena = entrada.nextLine();
            for (int i=0; i<cadena.length(); i++) {
                System.out.println(cadena.charAt(i));
            }
        } while (!cadena.equals(""));
        System.out.println("Fin del programa.");
        entrada.close();
    }
}