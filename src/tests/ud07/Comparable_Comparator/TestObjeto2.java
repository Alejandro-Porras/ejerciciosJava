package tests.ud07.Comparable_Comparator;

import java.util.TreeSet;

public class TestObjeto2 {
    public static void main(String[] args) {
        TreeSet<Objeto2> ts = new TreeSet<>();
        Objeto2 o1 = new Objeto2(0, 1);

        ts.add(o1);

        ts.add(new Objeto2(4, 5));
        ts.add(new Objeto2(3, 1));

        for (Objeto2 item : ts) {
            System.out.println(item);
        }
    }
}
