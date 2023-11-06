package ud03;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        
        int d1, d2, m1, m2, a1, a2;

        System.out.println("Introduzca fecha 1");
        System.out.print("Dia: ");
        d1 = entrada.nextInt();

        System.out.print("Mes: ");
        m1 = entrada.nextInt();

        System.out.print("Año: ");
        a1 = entrada.nextInt();

        System.out.println("\n\nIntroduzca fecha 2");
        System.out.print("Dia: ");
        d2 = entrada.nextInt();

        System.out.print("Mes: ");
        m2 = entrada.nextInt();

        System.out.print("Año: ");
        a2 = entrada.nextInt();

        if (a1<a2 || ((a1==a2) && (m1<m2)) || ((a1==a2) && (m1==m2) && (d1<d2))) {
            System.out.printf("La fecha menor es: %d-%d-%d",d1,m1,a1);
        } else {
            System.out.printf("La fecha menor es: %d-%d-%d",d2,m2,a2);
        }

        entrada.close();
        dsdas
    }
}
