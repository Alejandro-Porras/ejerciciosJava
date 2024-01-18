package ud03;
import java.util.Scanner;

public class Ejercicio26 {

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
