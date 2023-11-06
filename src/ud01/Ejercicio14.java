package ud01;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;

        System.out.print("\nIntroduce el numero entero: ");
        numero = entrada.nextInt();

        System.out.println("La ultima cifra de " + numero + " es " + ((numero%100-numero%10)/10));

        entrada.close();
    }
}
