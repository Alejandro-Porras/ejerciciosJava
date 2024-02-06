package tests.test_v2;

import java.io.File;
import java.util.Scanner;

public class Lluviasv2 {
    private static final int MAX_LLUVIAS = 31;
    
    public static void leerArray(double[] v, String nombreFichero){
        //indice para recorrer el array.
        int indice = 0;
        try {
            //indicamos el archivo a abrir
            File arxiu = new File(nombreFichero);
            //Creamos els Scanner desde el fichero en lugar de desde System.in
            Scanner input = new Scanner(arxiu);

            //Mientras haya lineas las vamos leyendo
            while (indice<MAX_LLUVIAS) {
                v[indice] = input.nextDouble();
                indice++;
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static double lluviaTotal(double[] v){
        double total = 0;
        for (int i = 0; i < v.length; i++) {
            total+=v[i];
        }
        return total;
    }

    public static double lluviaMedia(double[] v){
        double total = 0;
        for (int i = 0; i < v.length; i++) {
            total+=v[i];
        }
        return (total/MAX_LLUVIAS);
    }

    public static double lluviaMax(double[] v){
        double aux = v[0];
        for (int i = 1; i < v.length-1; i++) {
            if (aux<v[i+1]) {
                aux = v[i+1];
            }
        }
        return (aux);
    }

    public static int lluviaPosMax(double[] v){
        double aux = v[0];
        int aux2=0;
        for (int i = 1; i < v.length-1; i++) {
            if (aux<v[i+1]) {
                aux = v[i+1];
                aux2=i+1;
            }
        }
        return (aux2);
    }

    public static double lluviaMin(double[] v){
        double aux = v[0];
        for (int i = 1; i < v.length-1; i++) {
            if (aux>v[i+1]) {
                aux = v[i+1];
            }
        }
        return (aux);
    }

    public static int lluviaPosMin(double[] v){
        double aux = v[0];
        int aux2=0;
        for (int i = 1; i < v.length-1; i++) {
            if (aux>v[i+1]) {
                aux = v[i+1];
                aux2=i+1;
            }
        }
        return (aux2);
    }

    public static int lluviaNula(double[] v){
        int aux = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i]==0) {
                aux++;
            }
        }
        return (aux);
    }

    public static int lluviaMayorMedia(double[] v){
        int aux = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i]>lluviaMedia(v)) {
                aux++;
            }
        }
        return (aux);
    }

    public static double lluviaSumaParcial(double[]v,int izq,int der){
        double suma = 0;
        for (int i = izq; i < der; i++) {
            suma+=v[i];
        }
        return suma;
    }

    public static int lluviaMenorSiguiente(double[]v){
        int cont= 0;
        for (int i = 0; i < v.length-1; i++) {
            if (v[i]<v[i+1]) {
                cont++;
            }
        }
        return cont;
    }

    public static void main(String[] args) {
        double[] v = new double[MAX_LLUVIAS];
        leerArray(v, "./src/ud04/lluviasEnero");
        System.out.println("La lluvia total caída en el mes: " + lluviaTotal(v));
        System.out.println("La cantidad media de lluvias del mes: " + lluviaMedia(v));
        System.out.println("La cantidad más grande de lluvia caída en un solo día: " + lluviaMax(v));
        System.out.println("Cual fue el día que más llovió: " + lluviaPosMax(v));
        System.out.println("La cantidad más pequeña de lluvia caída en un solo día: " + lluviaMin(v));
        System.out.println("Cual fue el día que menos llovió: " + lluviaPosMin(v));
        System.out.println("En cuantos días no llovió nada: " + lluviaNula(v));
        System.out.println("En cuantos días la lluvia superó la media: " + lluviaMayorMedia(v));
        double quincena1 = lluviaSumaParcial(v, 0, 14);
        double quincena2 = lluviaSumaParcial(v, 15, 30);
        System.out.println("Si en la primera quincena del mes llovió más o menos que en la segunda: " + 
        ((quincena1>quincena2)?"Si, es mayor":"No, es menor"));
        System.out.println("En cuantos días la lluvia fue menor que la del día siguiente: " + lluviaMenorSiguiente(v));
    }
}
