package programaMe.reto2;

import java.util.Scanner;

public class PB {

    public static boolean comprobarEquilibrio(String num){
        if (num.length()%2!=0) {
            return false;
        }
        int cont0 = 0;
        int cont1 = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i)=='0') {
                cont0++;
            }
            if (num.charAt(i)=='1') {
                cont1++;
            }
        }
        if (num.substring(0, 2).equals(num.substring(num.length()-2, num.length())) && cont0==cont1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Se añade el numero de veces que se recorrera:
        int numVeces = entrada.nextInt();
        // Realizamos el bucle
        for (int i = 0; i < numVeces; i++) {
            // Recogemos el numero con un array
            String numeroAComprobar = entrada.next();

            // Realizamos la comprobacion para devolver.
            if (comprobarEquilibrio(numeroAComprobar)) {
                System.out.println("EQUILIBRADA");
            } else {
                System.out.println("ERROR");
            }
        }
        entrada.close();
    }
}
