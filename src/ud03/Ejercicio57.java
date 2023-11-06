package ud03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio57 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int edad = 0;
        int suma = 0;
        for (int i=1; i <=5; i++)
        do {
            System.out.println("Introduzca edad de la persona" + i);
            try {
            edad = entrada.nextInt();
            } catch (InputMismatchException e) {
                edad = 0;
                i = 5;
                System.out.println("No se ha introducido un número entero.");
            }
            if (edad>=0 || edad<=110) {
            suma += edad;
            }
            System.out.println(suma);
        } while (edad<=0 || edad>=110);
        
        
        System.out.println("El edad de la persona es "+ (suma/5));

        entrada.close();
    }
}
