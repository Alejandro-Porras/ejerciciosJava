package ud01;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner (System.in);
        
    double m1;
    double m2;
    double d;

    System.out.print("\n\nIntroduzca masa del cuerpo 1: ");
    m1=entrada.nextDouble();

    System.out.print("\nIntroduzca masa del cuerpo 2: ");
    m2=entrada.nextDouble();

    System.out.print("\nIntroduzca la distancia entre cuerpos: ");
    d=entrada.nextDouble();

    System.out.println("La fuerza es: " + ((6.693*Math.pow(10, -11))*m1*m2)/Math.pow(d, 2));
    entrada.close();
    }
}
