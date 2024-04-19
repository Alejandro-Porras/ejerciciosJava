package ud07.actividades;

import java.util.ArrayList;
import java.util.Iterator;

public class Actividad01 {
    public static void main(String[] args) {
        ArrayList<Integer> misNumeros = new ArrayList<>();
        misNumeros.add(1);
        misNumeros.add(6);
        misNumeros.add(3);
        misNumeros.add(2);
        misNumeros.add(0);
        misNumeros.add(4);
        misNumeros.add(5);

        System.out.println(misNumeros);

        System.out.println(misNumeros.get(5));

        misNumeros.add(4, 8);

        misNumeros.set(1, 9);

        misNumeros.remove(misNumeros.indexOf(5));

        misNumeros.remove(3);

        for (int i = 0; i < misNumeros.size(); i++) {
            System.out.print(misNumeros.get(i) + ",");
        }

        Iterator<Integer> it = misNumeros.iterator();

        while (it.hasNext()) {
            System.out.print(it.next());
            if (it.hasNext()) {
                System.out.print(", ");
            }
        }

        System.out.println(misNumeros.contains(0));

        System.out.println(misNumeros.contains(7));

        ArrayList<Integer> copiaArrayList = new ArrayList<>();
        copiaArrayList.addAll(misNumeros);

        //tambien puede:
        //ArrayList<Integer> copiaArrayList = (ArrayList<Integer>misNumeros.clone());

        misNumeros.add(9);

        System.out.println(misNumeros.indexOf(9));

        System.out.println(misNumeros.lastIndexOf(9));

        copiaArrayList.clear();
        
        System.out.println(copiaArrayList.isEmpty());

        Object[] newArray =  misNumeros.toArray();

        System.out.println("misNumeros: " + misNumeros);

        for (Object elemento : newArray) {
            System.out.print(elemento + ", ");
        }
    }
}
