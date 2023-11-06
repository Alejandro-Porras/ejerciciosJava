package ud01;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner (System.in);
    
    double radio;

    System.out.println("Introduzca el radio: ");
    radio = entrada.nextDouble();

    System.out.printf("La longitud de la circunferencia es: %.2f" , (2*Math.PI*radio));

    entrada.close();
    }
}
