package ud03;

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double numero;

        do {
            System.out.print("\nIntroduzca el numero real del cual quieras hacer la raiz cuadrada: ");
            numero = entrada.nextDouble();
            
            if (numero>=0) {
                System.out.println("\n\nLa raiz cuadrada es " + Math.sqrt(numero));
            } else {
                System.out.println("\n\nHas introducido un numero negativo, coloque un numero positivo");
            }
            
        } while (numero<0);
        entrada.close();
    }
}
