package tests.test_v2.test;

import java.util.Scanner;

public class Factores {

    public static void factores(int numero){

        for(int i=2;i<numero;i++){

            while(numero%i == 0){
                numero = numero/i;
                System.out.print(i+"  ");
                 if(numero == 1){
                    System.out.println(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        System.out.print("Introduce el número: ");
        int num = tec.nextInt();
        factores(num);

        tec.close();
    }
}
