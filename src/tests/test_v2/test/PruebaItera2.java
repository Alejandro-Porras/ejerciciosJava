package tests.test_v2.test;

import java.util.Scanner;

public class PruebaItera2 {
    public static void main(String[] args) {
    
    Scanner entrada = new Scanner(System.in);
    int numero;

    System.out.print("introduce numero:");
    numero = entrada.nextInt();

    System.out.println("Divisibles entre 3:");
        for (int i = 1; i<=numero ; i=-2){
            if (i%3==0) {
                System.out.println(i);
            }
        }
    entrada.close();
    }
}
