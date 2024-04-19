package ud07.ejercicios.Ejer01_Varios;

import java.util.ArrayList;
import java.util.HashSet;

public class Varios {
    public static void mostrarArray(int[] v){
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]);
            if (i<v.length-1) {
                System.out.print(", ");
            }
        }
    }

    public static int[] quitarDuplicados (int[] v){

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < v.length; i++) {
            hs.add(v[i]);
        }

        int[] aux = new int[hs.size()];
        int cont = 0;

        for (Integer i : hs) {
            aux[cont] = i;
            cont++;
        }
        return aux;
    }
    
    public static int[] union1(int[] v1, int[] v2){
        HashSet<Integer> hs1 = new HashSet<>();
        for (int i = 0; i < v1.length; i++) {
            hs1.add(v1[i]);
        }

        for (int i = 0; i < v2.length; i++) {
            hs1.add(v2[i]);
        }

        int[] aux = new int[hs1.size()];
        int cont = 0;

        for (Integer i : hs1) {
            aux[cont] = i;
            cont++;
        }
        return aux;
    }
   
    public static int[] union2(int v1[], int v2[]){
        ArrayList<Integer> al1 = new ArrayList<>();
        for (int i = 0; i < v1.length; i++) {
            al1.add(v1[i]);
        }
        for (int i = 0; i < v2.length; i++) {
            al1.add(v2[i]);
        }

        int[] aux = new int[al1.size()];
        
        for (int i = 0; i < al1.size(); i++) {
            aux[i]=al1.get(i);
        }

        return aux;
    }
    
    public static int[] interseccion(int v1[], int v2[]){
        HashSet<Integer> hs1 = new HashSet<>();
        for (int i = 0; i < v1.length; i++) {
            hs1.add(v1[i]);
        }

        HashSet<Integer> hs2 = new HashSet<>();
        for (int i = 0; i < v2.length; i++) {
            hs2.add(v2[i]);
        }

        hs1.retainAll(hs2);

        int[] aux = new int[hs1.size()];
        int cont = 0;

        for (Integer i : hs1) {
            aux[cont] = i;
            cont++;
        }
        return aux;
    }
    
    public static int[] diferencia1 (int v1[], int v2[]){
        ArrayList<Integer> al1 = new ArrayList<>();
        for (int i = 0; i < v1.length; i++) {
            al1.add(v1[i]);
        }

        ArrayList<Integer> al2 = new ArrayList<>();
        for (int i = 0; i < v2.length; i++) {
            al2.add(v2[i]);
        }

        al1.removeAll(al2);

        int[] aux = new int[al1.size()];
        
        for (int i = 0; i < al1.size(); i++) {
            aux[i]=al1.get(i);
        }

        return aux;
    }
    
    public static int[] diferencia2 (int v1[], int v2[]){
        HashSet<Integer> hs1 = new HashSet<>();
        for (int i = 0; i < v1.length; i++) {
            hs1.add(v1[i]);
        }

        HashSet<Integer> hs2 = new HashSet<>();
        for (int i = 0; i < v2.length; i++) {
            hs2.add(v2[i]);
        }

        hs1.removeAll(hs2);

        int[] aux = new int[hs1.size()];
        int cont = 0;

        for (Integer i : hs1) {
            aux[cont++] = i;
        }
        return aux;
    }
    
    public static void main(String[] args) {
        System.out.println("\nPrimer array: ");
        int[] v1 = {1,1,3,3,2,4,6,6,5};
        mostrarArray(v1);

        System.out.println("\n\nSegundo array: ");
        int[] v2 = {6,7,7,7};
        mostrarArray(v2);

        System.out.println("\n\nQuitar duplicados");
        mostrarArray(quitarDuplicados(v1));

        System.out.println("\n\nUnion1");
        mostrarArray(union1(v1, v2));

        System.out.println("\n\nUnion2");
        mostrarArray(union2(v1, v2));

        System.out.println("\n\nInterseccion");
        mostrarArray(interseccion(v1, v2));

        System.out.println("\n\nDiferencia1");
        mostrarArray(diferencia1(v1, v2));

        System.out.println("\n\nDiferencia2");
        mostrarArray(diferencia2(v1, v2));
    }
}