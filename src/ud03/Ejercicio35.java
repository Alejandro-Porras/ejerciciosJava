package ud03;

import java.util.Scanner;

public class Ejercicio35 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
        
    int edades = 0;

        do {
            edades = 0;
            for (int i=1;i<=5;i++) {
                System.out.println("Introduzca edad de persona" + i);
                edades += entrada.nextInt();
            }
            if (edades<200) {
                System.out.println("No has introducido una suma mayor que 200.\n\n");
            }
        } while (edades<200);

        System.out.println("La edad total es " + edades);
        entrada.close();
    }
}
