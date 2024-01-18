package ud03;

import java.util.Scanner;

public class Ejercicio31 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int dia;
        int bultos;
        int peso = 0;

        do {
            System.out.println("Introduzca dia: ");
            dia = entrada.nextInt();
        } while (dia<1 || dia>6);

        do {
            System.out.print("Introduzca numero de bultos: ");
            bultos = entrada.nextInt();
        } while (bultos<1 || bultos>=30);

        for(int i = 1; i<=bultos;i++){
            do {
                System.out.println("Introduzca peso del bulto" + i);
                peso += entrada.nextInt();
            } while (peso<1);
        }

            System.out.println("\n\nEl peso total es " + peso + "kg\n\n");

            if (peso<=300) {
                if (dia!=6) {
                    System.out.println("Cobra: "+(bultos*30) + " euros");
                } else if (dia==6) {
                    System.out.println("Cobra: "+((bultos*30)+60) + " euros");
                }
            } else if (peso>300 && peso<=1000) {
                if (dia!=6) {
                    System.out.println("Cobra: "+((bultos*30)+((peso-300)*0.9)) + " euros");
                } else if (dia==6) {
                    System.out.println("Cobra: "+(((bultos*30)+60)+((peso-300)*0.9)) + " euros");
                }
            } else if (peso>1000) {
                System.out.println("No se realizan pedidos de mas de mil Kilos.");
            }
        entrada.close();
    }
}
