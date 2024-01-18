package ud03;

import java.util.Scanner;

public class Ejercicio44 {
    public static void dibRecAsteriscos(int alto, int ancho) {
        for (int j=1; j<=alto; j++) {
                if (j>=1) {
                    System.out.print("\n");
                }
            for (int i=0; i<ancho; i++) {
                System.out.print("*");
                }
        }
    }

    public static void dibRecNumeros1(int alto, int ancho) {
        for (int j=1; j<=alto; j++) {
                if (j>=1) {
                    System.out.print("\n");
                }
            for (int i=0; i<ancho; i++) {
                System.out.print(i+1);
                }
        }
    }

    public static void dibRecNumeros2(int alto, int ancho) {
        for (int j=1; j<=alto; j++) {
                if (j>=1) {
                    System.out.print("\n");
                }
            for (int i=0; i<ancho; i++) {
                System.out.print(ancho-i);
                }
        }
    }

    public static void dibRecNumeros3(int alto, int ancho) {
          int a = 1;
            for (int j=1; j<=alto; j++) {
                if (j>=1) {
                    System.out.print("\n");
                }
            for (int i=1; i<=ancho; i++) {
                System.out.printf("%02d ", a);
                a++;
                }
        }
    }

    public static void dibDiagonal(int alto, int ancho) {
            for (int j=1; j<=alto; j++) {
                if (j>=1) {
                    System.out.print("\n");
                }
            for (int i=1; i<=ancho; i++) {
                if (j==i) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
                }
        }
    }
    public static void dibRecLetras(int alto, int ancho) {
            /* 
            char abc = 'a';
            int a = 0;
            for (int j=1; j<=alto; j++) {
                if (j>=1) {
                    System.out.print("\n");
                    if (j>=2) {
                       abc+=a+1; 
                    }
                }
            for (int i=0; i<ancho; i++) {
                    System.out.print(abc);
                }
        }
        */
        for (char i ='a';i<(alto+'a');i++){
            for (int j=1; j<=ancho;j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void dibRecLetras2(int alto, int ancho) {
            /* 
            char abc = 'a';
            abc+=alto;
            for (int j=1; j<=alto; j++) {
                if (j>=1) {
                    System.out.print("\n");
                abc--;
                }
            for (int i=0; i<ancho; i++) {
                    System.out.print(abc);
                }
        }
            */
            for (int i =(alto-1)+'a';i>=('a');i--){
            for (int j=1; j<=ancho;j++){
                System.out.print((char)i + " ");
            }
            System.out.println();
        }
        
    }
    public static void dibRecLetras3(int alto, int ancho) {
            char abc = 'a';
            for (int j=1; j<alto; j++) {
                if (j>=1) {
                    System.out.print("\n");
                }
            for (int i=0; i<ancho; i++) {
                    System.out.print((abc++)+" ");
                }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int alto;
        int ancho;
        int aux;

        System.out.print("Introduce el alto de la figura: ");
        alto = entrada.nextInt();

        System.out.print("Introduce el ancho de la figura: ");
        ancho = entrada.nextInt();

                do {
                    System.out.println("---------------------"+
                        "\n-Figuras" + 
                        "\n-1.dibRecAsteriscos" + 
                        "\n-2.dibRecNumeros1" +
                        "\n-3.dibRecNumeros2" +
                        "\n-4.dibRecNumeros3" +
                        "\n-5.dibDiagonal" +
                        "\n-6.dibRecLetras1" +
                        "\n-7.dibRecLetras2" +
                        "\n-8.dibRecLetras3" +
                        "\n-0.Salir" +
                         "\n---------------------");
                         aux = entrada.nextInt();
                } while (aux<0 || aux>8);
        
                         switch (aux) {
                            case 1:
                                dibRecAsteriscos(alto, ancho);
                                break;
                            case 2:
                                dibRecNumeros1(alto, ancho);
                                break;
                            case 3:
                                dibRecNumeros2(alto, ancho);
                                break;
                            case 4:
                                dibRecNumeros3(alto, ancho);
                                break;
                            case 5:
                                dibDiagonal(alto, ancho);
                                break;
                            case 6:
                                dibRecLetras(alto, ancho);
                                break;
                            case 7:
                                dibRecLetras2(alto, ancho);
                                break;
                            case 8:
                                dibRecLetras3(alto, ancho);
                                break;
                         }
        

        entrada.close();
    }
}
