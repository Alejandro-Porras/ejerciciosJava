package ud03;

import java.util.Scanner;

public class Ejercicio24 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numPersonas;
        int edad;
        int infancia=0, pubertad=0, adolescencia=0, adultez=0, vejez=0, ancianidad=0;

        System.out.print("Introduce el numero de personas: ");
        numPersonas = entrada.nextInt();

        for(int i=1; i<=numPersonas; i++){
            do {
               System.out.print("Introduce edad de la persona" + i + " :");
                edad = entrada.nextInt(); 
            } while (edad<0 && edad>130);

            if (edad<=10) {
                infancia++;
            } else if (edad>=11 && edad<=14) {
                pubertad++;
            } else if (edad>=15 && edad<=21) {
                adolescencia++;
            } else if (edad>=22 && edad<=55) {
                adultez++;
            } else if (edad>=56 && edad<=70) {
                vejez++;
            } else {
                ancianidad++;
            }

            System.out.println("\n\nInfancia: " + (infancia*numPersonas/100) +
                               "\nPubertad: " + (pubertad*numPersonas/100) +
                               "\nAdolescencia: " + (adolescencia*numPersonas/100) +
                               "\nAdultez: " + (adultez*numPersonas/100) +
                               "\nVejez: " + (vejez*numPersonas/100) +
                               "\nAncianidad: " + (ancianidad*numPersonas/100));
            entrada.close();
        }
    }
}
