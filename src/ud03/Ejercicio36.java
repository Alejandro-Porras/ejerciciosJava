package ud03;

import java.util.Scanner;

public class Ejercicio36 {
    public static final int A = 3;//alumnos
    public static final int S = 4;//asignaturas

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        for (int i=1;i<=A;i++) {
            System.out.println("Alumno "+i);
            for (int j=1; j<=S; j++) {
            System.out.print("Introduce nota de la asignatura " + j + ":");
            entrada.nextInt();
            }
        }
        entrada.close();
    }
}
