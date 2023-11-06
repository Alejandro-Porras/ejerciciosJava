package ud01;

import java.util.Scanner;

public class Ejercicio04 {
    /*
     *  Ejercicio 04. Escribir un programa que lea un entero desde teclado, lo multiplique por 2, y a
     *  continuación escribe el resultado en la pantalla:
     */
    public static void main(String[] args) {
    Scanner entrada = new Scanner (System.in) ;
        int numero;
        System.out.println("Escribe un número: ");
        numero = entrada.nextInt();

        System.out.println("El doble " + numero + " es " + numero*2);
        entrada.close();
    }
}
