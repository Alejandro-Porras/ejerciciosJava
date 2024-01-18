package ud03;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int num1;
        int num2;

        System.out.println("Introduzca numero 1");
        num1 = entrada.nextInt();

        System.out.println("Introduzca numero 2");
        num2 = entrada.nextInt();

        if ((num1*num2)%2==0) {
            System.out.println("El producto de los dos números es positivo o nulo");
        } else {
            System.out.println("El producto de los dos números es negativo");
        }
        entrada.close();
    }
}
