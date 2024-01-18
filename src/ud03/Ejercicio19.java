package ud03;

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String nombre;
    
        System.out.print("\n\nEscribe tu nombre: ");
        nombre = entrada.nextLine();

        if ((nombre.toLowerCase().charAt(0)) == (nombre.toLowerCase().charAt(nombre.length()-1))) {
            System.out.println("Coinciden.");
        } else {
            System.out.println("No coinciden.");
        }
        entrada.close();
    }
}
