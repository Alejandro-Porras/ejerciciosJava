package ud01;

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner (System.in);

    double longitud;
    double anchura;

    System.out.println("Inserte la longitud: ");
    longitud=entrada.nextDouble();

    System.out.println("Inserte la anchura: ");
    anchura=entrada.nextDouble();

    System.out.println("La longitud es "+longitud + " y la anchura es " + anchura);

    entrada.close();
    }
}
