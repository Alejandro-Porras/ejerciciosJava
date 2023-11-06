package ud03;

import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int numero;
        int divisor;

        System.out.print("Introduzca el numero que vayas a dividir: ");
        numero = entrada.nextInt();

        System.out.print("\nIntroduzca el divisor: ");
        divisor = entrada.nextInt();

        if (divisor>=1) {
            System.out.println("\n\nLa division de " + numero + "/" + divisor + " es: " + numero/divisor);
        }else{
            System.out.println("\n\nHas colocado un 0 en el divisor.");
        }
        entrada.close();
    }
}
