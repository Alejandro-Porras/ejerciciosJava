package ud03;

import java.util.Scanner;

public class Ejercicio33 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double nota;
        int alumnos = 0;
        int alumnosApro = 0;
        double notaTotal = 0;

        do {
            System.out.println("Introduzca nota del alumno" + (alumnos+1));
            nota=entrada.nextDouble();
            
            if (nota>=0 && nota<=10) {
                if (nota>=5) {
                alumnosApro++;
            }
                notaTotal+=nota;
                alumnos++;
            }   else {
                System.out.println("Saliendo...");
            }
            
        } while (nota>=0 && nota<=10);

        System.out.println("\n\nEl numero de alumnos es " + alumnos);
        System.out.println("El numero de alumnos aprobados es " + alumnosApro);
        System.out.println("La nota media es " + notaTotal/alumnos);

        entrada.close();
    }
}
