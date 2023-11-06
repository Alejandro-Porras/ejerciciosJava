package ud03;

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int num1;
    int num2;

    System.out.println("Introduce numero 1: ");
    num1 = entrada.nextInt();

    System.out.println("Introduce numero 2: ");
    num2 = entrada.nextInt();

    System.out.println("El numero menor es:");
    if(num1<num2){
    System.out.println(num1);
    }else{
    System.out.println(num2);
    }
    entrada.close();
    }

}
