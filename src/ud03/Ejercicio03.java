package ud03;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2, num3;

        System.out.println("Introduzca el numero 1");
        num1 = entrada.nextInt();

        System.out.println("Introduzca el numero 2");
        num2 = entrada.nextInt();

        System.out.println("Introduzca el numero 3");
        num3 = entrada.nextInt();

        if ((num1>num2 && num1<num3) || (num1<num2 && num1>num3)) {
            System.out.println("\nEl numero intermedio es "+num1);
        } else if ((num2>num1 && num2<num3) || (num2<num1 && num2>num3)) {
            System.out.println("\nEl numero intermedio es "+num2);
        } else if ((num3>num1 && num3<num2) || (num3<num1 && num3>num2)) {
            System.out.println("\nEl numero intermedio es "+num3);
        } else {
            System.out.println("invalid operation");
        }
        
        entrada.close();
    }
}
