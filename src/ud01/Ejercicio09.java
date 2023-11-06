package ud01;

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner (System.in);

    int segundos;
    int dias;
    int horas;
    int minutos;


    System.out.println("Introduzca segundos: ");
    segundos = entrada.nextInt();


    System.out.println(segundos + " segundos son:\n");
    
    dias = segundos >= 86400 ? segundos/86400 : 0;
        segundos -= dias*86400;
        System.out.println(dias + " días");

        horas = segundos >= 3600 ? segundos/3600 : 0;
        segundos -= horas*3600;
        System.out.println(horas + " horas");

        minutos=segundos >=60 ? segundos/60 : 0;
        segundos-=minutos*60;
        System.out.println(minutos + " minutos");

        System.out.println(segundos + " segundos");

        entrada.close();
    }
}
