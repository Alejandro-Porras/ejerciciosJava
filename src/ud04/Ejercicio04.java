package ud04;

import java.util.Scanner;

public class Ejercicio04 {
    public static int generarNumero(){
        int numero;
        do {
            numero = (int)(Math.random()*20+1);
        } while (numero%2==0);
        return numero;
    }
    public static int[] invertirArray(int [] w){
        int[] invertido = new int[w.length];
        for (int i=0; i<w.length; i++) {
            invertido[i] = w[w.length-1-i];
        }
        return invertido;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce la longitud del array");
        int[] v = new int[entrada.nextInt()];

        System.out.println("Vector original: ");
        for (int i = 0; i < v.length; i++) {
            v[i] = generarNumero();
            System.out.print(v[i] + " ");
        }
        System.out.println();

        int[] invertido = invertirArray(v);
        System.out.println("Vector invertido: ");
        for (int i = 0; i < invertido.length; i++) {
            System.out.print(invertido[i] + " ");
        }
        System.out.println();
    entrada.close();
    }
}
