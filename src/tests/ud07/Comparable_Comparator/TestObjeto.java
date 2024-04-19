package tests.ud07.Comparable_Comparator;

import java.util.TreeSet;

public class TestObjeto {
    public static void main(String[] args) {
        TreeSet<Objeto> ts = new TreeSet<>(new ObjetoComparator());
        Objeto o1 = new Objeto(0, 1);

        ts.add(o1);

        ts.add(new Objeto(4, 5));
        ts.add(new Objeto(3, 1));

        for (Objeto item : ts) {
            System.out.println(item);
        }
    }
}
