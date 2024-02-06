package tests.test_v2;

import java.util.Scanner;

public class Piramide {
    public static void dibTriangulo3(int alto){
        
        int cont = 0;
        int aux;
        int i;

        for (i = 1; i <= alto; i++) {
            for (int j = alto; j >= 1; j--) {
                if (i<j) {
                    System.out.print("  ");
                } else if (i==j){
                    //veces que necesitamos que se repita
                    aux = i*2-1;
                    cont= 1;
                    do {
                        //printeamos
                        System.out.print("* ");
                        cont++;
                    } while (cont<=aux);
                } 
            }
            System.out.println();
        }
    }

    public static void dibTriangulo4(int alto){
        
        int cont = 0;
        int aux;
        int i;

        for (i = 1; i <= alto; i++) {
            for (int j = alto; j >= 1; j--) {
                if (i<j) {
                    System.out.print("  ");
                } else if (i==j){
                    //veces que necesitamos que se repita
                    aux = i*2-1;
                    cont= 1;
                    do {
                        //printeamos
                        System.out.print("* ");
                        cont++;
                    } while (cont<=aux);
                } 
            
            System.out.println();
        }
        }
        for (i = 1; i <= alto; i++) {
            for (int k = 1; k >= alto; k++) {
                if (i<k) {
                    System.out.print("  ");
                } else if (i==k){
                    //veces que necesitamos que se repita
                    aux = i*2-1;
                    cont= 1;
                    do {
                        //printeamos
                        System.out.print("* ");
                        cont++;
                    } while (cont<=aux);
                } 
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int alt;
        System.out.println("Intro alt");
        alt = entrada.nextInt();

        dibTriangulo4(alt);
        entrada.close();
    }
}
