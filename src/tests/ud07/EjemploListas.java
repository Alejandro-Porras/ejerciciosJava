package tests.ud07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class EjemploListas {
    public static void main(String[] args) {
        LinkedList <Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(3);
        ll.add(1,2);
        ll.add( ll.get(1) + ll.get(2));
        ll.remove(0);

        System.out.println("LinkedList:");

        for (Integer numero : ll) {
            System.out.print(numero + " ");
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < ll.size(); i++) {
            System.out.println(i + ": " + ll.get(i));
        }

        System.out.println("------------------");

        ArrayList <Integer> al = new ArrayList<>();

        al.add(10);
        al.add(11);
        al.set(al.indexOf(11), 12);

        System.out.println("ArrayList:");
        for (Integer item : al) {
            System.out.print(item + " ");
        }

        System.out.println();

        TreeSet <Integer> ts = new TreeSet<>();
        ts.add(55);
        ts.add(99);

        System.out.println("------------------");
        al.addAll(0, ll.subList(1, ll.size()));
        al.addAll(ts);
        for (Integer item : al) {
            System.out.print(item + " ");
        }
        System.out.println();

        al.subList(al.indexOf(10), al.lastIndexOf(55)+1).clear();
        System.out.println("modificao borrao");
        for (Integer item : al) {
            System.out.print(item + " ");
        }
        System.out.println();

    }
}
