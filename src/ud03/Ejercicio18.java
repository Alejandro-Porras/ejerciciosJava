package ud03;

import java.util.Scanner;

public class Ejercicio18 {
    public static double calcularCoste(int hora, int dia, int kilometros){
        double coste = 0;
        if (dia<=5) {
            if (hora>=6 && hora<=22) {
                coste= kilometros * 0.73;
            } else {
                coste= kilometros * 0.84;
            }
        coste = Math.max(coste, 2.95);
        } else {
            coste = kilometros*0.93;
            coste = Math.max(coste, 4);
        }

        return coste;
    }
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);

        int horas;
        int minutos;
        int dia;
        int kilometros;

        System.out.println("Introduzca los siguientes datos: ");
        System.out.println("\nIntroduzca la hora del trayecto: ");
        do {
            System.out.print("hora: ");
            horas = entrada.nextInt();
        } while (horas<0 || horas>23);
        
        do {
            System.out.print("minuto: ");
            minutos = entrada.nextInt();
        } while (minutos<0 || minutos>59);
        
        do {
            System.out.print("Introduzca dia en numero(Lunes = 1, Martes = 2, "+
            "Miercoles = 3, Jueves = 4, Viernes = 5, Sabado = 6, Domingo = 7)");
            dia = entrada.nextInt();
        } while (dia<1 || dia>7);
       
        do {
            System.out.print("Introduzca los kilometros realizados: ");
            kilometros = entrada.nextInt();
        } while (kilometros>0);

        System.out.println("El coste será: " + calcularCoste(horas, dia, kilometros));

        entrada.close();
        
    }
}
