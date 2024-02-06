package tests.test_v2.test;

import java.util.Scanner;

public class EdWhile {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    int numRandom;
    int numTec;
    int i=0;
    
    numRandom = (int)(Math.random()*100+1);
    do {
        System.out.println("Introduzca el numero");
        numTec= entrada.nextInt();
        if (numTec<numRandom) {
            System.out.println("El numero es mayor");
        } else if (numTec>numRandom) {
            System.out.println("El numero es menor");
        } else if (numTec==numRandom) {
            System.out.println("\nBravo, acertaste en " + i + " intentos");   
        }
        i++;

        } while ((numTec!=numRandom));
    entrada.close();
    }
}

