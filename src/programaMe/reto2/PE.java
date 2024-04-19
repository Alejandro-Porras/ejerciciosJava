package programaMe.reto2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PE {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Se añade el numero de veces que se recorrera:
        int numVeces = entrada.nextInt();
        entrada.nextLine();
        // Realizamos el bucle
        HashMap<String, Integer> hs = new HashMap<>();
        for (int i = 0; i < numVeces; i++) {
            String nombre = entrada.nextLine();
            String[] dos = nombre.split(" ");
            hs.put(dos[1], Integer.parseInt(dos[0]));
        }
        ArrayList<Integer> al = new ArrayList<>();

        for(HashMap.Entry<String, Integer> entry : hs.entrySet()) {
            al.add(entry.getValue());
        }
        al.sort(null);
        

        entrada.close();
    }
}
