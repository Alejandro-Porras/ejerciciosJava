package ud03;

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int año;

        System.out.print("Introduzca el año: ");
        año = entrada.nextInt();

        if ((año%4==0 && !(año%100==0)) || (año%100==0&&año%400==0)) {
            System.out.println("El año " + año + " es bisiesto.");
        } else {
            System.out.println("El año " + año + " no es bisiesto."); 
        }
        entrada.close();
    }
}
