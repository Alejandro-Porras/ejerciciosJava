package ud01;

import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner (System.in);

    double pies;
    
    System.out.println("Inserte el numero de pies: ");
    pies=entrada.nextDouble();

    System.out.println("Pies a Yardas: " + pies/3);
    
    double pulgada = pies*12;
    System.out.println("Pies a Pulgadas: " + pulgada);

    double centimetros = pulgada*2.54;
    System.out.println("Pies a Centimetros: " + centimetros);

    double metros = centimetros/100;
    System.out.print("Pies a Metros: " + metros);

    entrada.close();
    }
}
