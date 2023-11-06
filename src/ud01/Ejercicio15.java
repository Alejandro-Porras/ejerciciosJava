package ud01;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double numero;

        System.out.print("\nIntroduce el numero real: ");
        numero = entrada.nextDouble();

        System.out.println("El número " + numero + " , redondeado a un decimal es " + ((double)(Math.round(numero*10))/10));

        entrada.close();
    }
}
