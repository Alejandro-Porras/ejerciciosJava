package ud03;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        
        int mes;

        do {
            System.out.println("Introduzca dia del mes(En formato numerico): ");
            mes = entrada.nextInt();
        } while (mes<1 || mes>12);

        if (mes==2) {
            System.out.println(28);
        } else if ((mes<=7 && (mes%2)==0) || (mes>=8 && (mes%2)!=0)) {
            System.out.println(30);
        } else if ((mes<=7 && (mes%2)!=0) || (mes>=8 && (mes%2)==0)) {
            System.out.println(31);
        }
        entrada.close();
    }
}
