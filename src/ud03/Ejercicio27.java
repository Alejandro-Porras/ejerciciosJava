package ud03;

import java.util.Scanner;

public class Ejercicio27 {
    public static boolean esPrimo(int num){
        boolean esPrimo = true;
        if ((num==2)) {
            esPrimo= true;
        } else if (num<2 || num%2==0) {
            esPrimo= false;
        } else {
            int divMax = num/2+1;
            for(int i=3;i<divMax && esPrimo; i += 2){
                if (num%i == 0) {
                    esPrimo = false;
                }
            } 
        }
        
        return esPrimo;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int numero;

        System.out.println("Escribe un limite: ");
        numero = entrada.nextInt();

            for( int i=1; i<numero;i++){
                if (i==1){
                    System.out.println(i);
                } else if(esPrimo(i)){
                    System.out.println(i);
                    //System.out.println(esPrimo(numero)?i:"");
                }
            }
        entrada.close();
    }
}
