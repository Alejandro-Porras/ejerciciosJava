package programaMe.fakeProgramame;

import java.util.ArrayList;
import java.util.Scanner;

public class Hacienda {

    public static boolean calculoHacienda(ArrayList<Integer> lista){
        boolean valido = false;
        int suma = 0;
        for (int i = 0; i < lista.size() && !valido; i++) {
            if (lista.get(i)>22000) {
                valido = true;
            }
            if (lista.get(i)>1500&&i!=0) {
                suma += lista.get(i);
            }
        }

        if (suma>14000) {
            valido = true;
        }

        return valido;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numVeces = entrada.nextInt();

        ArrayList<Integer> listaPagos = new ArrayList<>();

        for (int i = 0; i < numVeces; i++) {
            listaPagos.add(entrada.nextInt());
        }

        System.out.println(calculoHacienda(listaPagos)?"SI":"NO");

        entrada.close();
    }
}
