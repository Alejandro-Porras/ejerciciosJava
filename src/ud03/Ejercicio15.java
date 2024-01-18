package ud03;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double num1, num2;
        int opcion;

        System.out.println("Introduzca numero 1");
        num1 = entrada.nextDouble();

        do {
        System.out.println("\n+--------------------------\n" +
        "| Calculadora\n" + 
        "|\n" +
        "|1-Suma:\n" +
        "|2-Resta:\n" +
        "|3-Multiplicacion:\n" +
        "|4-Division:\n" +
        "+--------------------------\n");
        opcion = entrada.nextInt();
        } while (opcion<1 || opcion>4);

        if (opcion==4) {
            do {
            System.out.println("Introduzca numero 2");
            num2 = entrada.nextDouble();
            } while (num2<1);
        } else {
            System.out.println("Introduzca numero 2");
            num2 = entrada.nextDouble();    
        }

        switch (opcion) {
            case 1:
                System.out.println("La suma de " + num1 + "+" + num2 + " es = " + (num1+num2));
                break;
            case 2:
                System.out.println("La resta de " + num1 + "-" + num2 + " es = " + (num1-num2));
                break;
            case 3:
                System.out.println("La multiplicacion de " + num1 + "*" + num2 + " es = " + (num1*num2));
                break;
            case 4:
                System.out.println("La divison de " + num1 + "/" + num2 + " es = " + (num1/num2));
                break;
        }
    entrada.close();
    }
}
