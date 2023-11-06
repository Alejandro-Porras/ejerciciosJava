package ud01;

import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double masa;
        
        System.out.print("Introduzca masa: ");
        masa = entrada.nextDouble();

        System.out.println("La energia segun la formula de Einstein es: " + (masa*(2.997925*Math.pow(10, 8))));
        entrada.close();
    }
}
