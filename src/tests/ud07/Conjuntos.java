package tests.ud07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Conjuntos {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();

        hs.add(5);
        hs.add(99);
        hs.add(3);
        hs.add(2);
        hs.add(0);

        Iterator<Integer> it = hs.iterator();

        

        lhs.add(5);
        lhs.add(99);
        lhs.add(3);
        lhs.add(2);
        lhs.add(0);

        

        ts.add(5);
        ts.add(99);
        ts.add(3);
        ts.add(2);
        ts.add(0);

        System.out.println("HashSet (ordenado por hash) :");

        while (it.hasNext()) {
            System.out.print(it.next());
            if (it.hasNext()) {
                System.out.print(", ");
            }
        }

        // for (Integer contenido : hs) {
        //     System.out.print(contenido + ",");
        // }

        System.out.println("ListedHashSet (ordenado por insercion):");

        for (Integer contenido : lhs) {
            System.out.print(contenido + ",");
        }
        
        System.out.println("TreeSet (ordenado): ");
        
        for (Integer contenido : ts) {
            System.out.print(contenido + ",");
        }
    }
}
