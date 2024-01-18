package ud03;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        
        int mes;

        do {
            System.out.println("Introduzca dia del mes(En formato numerico): ");
            mes = entrada.nextInt();
        } while (mes<1 || mes>12);

        switch (mes) {
            case 1:
                System.out.println("\nEnero");
                break;
            case 2:
                System.out.println("\nFebrero");
                break;
            case 3:
                System.out.println("\nMarzo");
                break;
            case 4:
                System.out.println("\nAbril");
                break;
            case 5:
                System.out.println("\nMayo");
                break;
            case 6:
                System.out.println("\nJunio");
                break;
            case 7:
                System.out.println("\nJulio");
                break;
            case 8:
                System.out.println("\nAgosto");
                break;
            case 9:
                System.out.println("\nSeptiembre");
                break;
            case 10:
                System.out.println("\nOctubre");
                break;
            case 11:
                System.out.println("\nNoviembre");
                break;
            case 12:
                System.out.println("\nDiciembre");
                break;
        }
        entrada.close();
    }
}
