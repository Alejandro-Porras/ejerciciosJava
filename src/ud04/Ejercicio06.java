package ud04;

import java.util.Scanner;

public class Ejercicio06 {
    public static int generarNumero(int inicio, int fin){
        return (int)(Math.random()*(fin-inicio+1)+inicio);
    }
    public static void rotarDerecha(int[] v){
    int aux = v[0];
    int valor = v[v.length-1];
    for (int i = 1; i < v.length-1; i++) {
        // aux = v[(i+1)%v.length];
        // v[(i+1)%v.length] = v[i];
        // v[i]=aux;   
        if (v[i]<v.length-3) {
            v[i+2]=v[i];
            System.out.println(+v[i]);
        }
    }
    v[0]=valor;
    }

    public static void mostrarArray(int[] v){
        for (int i = 0; i < v.length; i++) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        // Scanner entrada = new Scanner(System.in);
        
        // //Pedir longitud y crear array con esa longitud
        // System.out.print("Introduce la longitud del array.");
        // int[] v = new int[entrada.nextInt()];

        // for (int i = 0; i < v.length; i++) {
        //     v[i]=generarNumero(0, 9);
        // }

        int v[] = {1,2,3,4,5,6};

        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }

        System.out.println("Roto derecha");
        rotarDerecha(v);

        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }
}
