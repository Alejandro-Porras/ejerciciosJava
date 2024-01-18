package ud03;

import java.util.Scanner;

public class Ejercicio25 {

    public static boolean esPrimo(int num){
        boolean esPrimo = true;
        for(int i=2;i<num && esPrimo; i++){
            if (num%i ==0) {
                esPrimo = false;
            }
        }
        return esPrimo;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int numero;

        System.out.println("Introduce numero: ");
        numero = entrada.nextInt();

        System.out.println(esPrimo(numero));

        entrada.close();
    }
}
