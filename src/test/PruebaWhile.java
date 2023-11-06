package test;

import java.util.Scanner;

public class PruebaWhile {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int numero;

    System.out.print("introduce numero:");
    numero = entrada.nextInt();

    int i = 1;
    while(i<=numero){
        System.out.println(i);
        i++;
    }
    entrada.close();
    }
}
