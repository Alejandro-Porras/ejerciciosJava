package tests.test_v2.test;

import java.util.Scanner;

public class Puntos {
    public static void dibRecAsteriscos(int ancho, int alto) {
        for (int j=1; j<=alto; j++) {
                if (j>=1) {
                    System.out.print("\n");
                }
            for (int i=0; i<ancho; i++) {
                System.out.print("*");
                }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int ancho;
        int alto;

        System.out.print("Introduce el ancho de la figura: ");
        ancho = entrada.nextInt();

        System.out.print("Introduce el alto de la figura: ");
        alto = entrada.nextInt();

        dibRecAsteriscos(ancho, alto);

        entrada.close();
    }
}
