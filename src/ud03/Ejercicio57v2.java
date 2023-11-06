package ud03;

import java.util.Scanner;

public class Ejercicio57v2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int edad = 0;
        int suma = 0;
       
        try {
        do {
        System.out.println("Introduzca edad de la persona");
        edad = entrada.nextInt();
        } while (edad<=0 || edad>=110);

            System.out.println("El edad de la persona es "+ (suma/5));
        } catch (Exception e) {
            // TODO: handle exception
        }
       
       

        entrada.close();
    }
}

