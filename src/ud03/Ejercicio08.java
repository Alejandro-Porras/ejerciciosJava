package ud03;

import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int hora;
        int minuto;

        System.out.print("Introduzca la hora: ");
        hora = entrada.nextInt();

        System.out.print("Introduzca minutos: ");
        minuto = entrada.nextInt();

        if (hora>12) {
            System.out.printf("\nSon las %02d-%02d PM",hora-12,minuto);
        } else {
            System.out.printf("\nSon las %02d-%02d AM",hora,minuto);
        }
        entrada.close();
    }
}
