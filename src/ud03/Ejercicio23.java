package ud03;

import java.util.Scanner;

public class Ejercicio23 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num;
        int resu=1;

        System.out.print("Introduzca el numero de potencias de 2: ");
        num=entrada.nextInt();
        
        for (int i = 0; i < num; i++) {
            resu*=2;
        }
        System.out.println("El resultado de 2 elevado a " + num + " es: " + resu);

        entrada.close();
    }
}
