package test_v2;

import java.io.File;
import java.util.Scanner;

public class Lluvias {
    private static final int MAX_LLUVIAS = 31;
         
    public static void leerArray(double v[], String nombreFichero) {
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
    public static double suma(double v[]) {
        int sum = 0;
        for (int i=0; i < v.length;i++) {
            sum += v[i];
        }
        return sum;
    }

    public static double media(double v[]) {
       return suma(v)/MAX_LLUVIAS;
    }

    public static int contarMayorQueMedia(double v[]) {
        int cont = 0;
        for (int i=0;i<v.length; i++){
            if (v[i] > media(v)) {
                cont++;
            }
        }
        return cont;
    }

     public static double maximo(double v[]) {
        double max = v[0];
        for (int i=1; i<v.length; i++){
            if (v[i]>max) {
                max = v[i];
            }
        }
        return max;
    }

    public static double minimo(double v[]) {
        double min = v[0];
        for (int i=1; i<v.length; i++){
            if (v[i]<min) {
                min = v[i];
            }
        }
        return min;
    }

    public static int posMaximo(double v[]) {
        boolean encontrado = false;
        int i=0;
        while (i<v.length && !encontrado) {
            if (v[i]==maximo(v)) {
            }
            i++;
        }
           return i; 
        }
        

    public static int posMinimo(double v[]) {
        boolean encontrado = false;
        int i=0;
        while (i<v.length && !encontrado) {
            if (v[i]==minimo(v)) {
            }
            i++;
        }
           return i; 
        }
    

    public static int contarApariciones(double v[], double x) {
        int cont = 0;
        for (int i=0; i<v.length; i++){
            if (v[i]==x) {
                cont++;
            }
        }
        return cont;
    }

    public static double sumaParcial(double v[], int izq, int der) {
        double suma = 0;
        for (int i= izq; i<der; i++){
            suma += v[i];
        }
        return suma;
    }

    public static int menoresQueElSiguiente(double v[]) {
        int menores = 0;
        for (int i=0; i<v.length-1; i++){
            if (v[i]<v[i+1]) {
                menores++;
            }
        }
        return menores;
    }

    public static void main(String[] args) {
        double[]lluvias = new double[MAX_LLUVIAS];
        leerArray(lluvias, "./src/lluviasenero");
        System.out.format("La suma de las lluvias es %.2f litros\n", suma(lluvias));
        System.out.format("La media de las lluvias es %.2f litros\n", media(lluvias));
        System.out.format("La máxima de las lluvias es %.2f litros\n", maximo(lluvias));
        System.out.format("La máxima de las lluvias fué el dia %d\n", posMaximo(lluvias) + 1);
        System.out.format("La mínima de las lluvias es %.2f litros\n", minimo(lluvias));
        System.out.format("La mínima de las lluvias fué el dia %d\n", posMinimo(lluvias) + 1);
        System.out.format("Ha habido un total de %d dias sin lluvia\n", contarApariciones(lluvias, 0.0));
        System.out.format("Ha habido un total de %d dias en los que la lluvia ha superado la media\n", contarMayorQueMedia(lluvias));
        double quincena1 = sumaParcial(lluvias, 0, 14);
        double quincena2 = sumaParcial(lluvias, 15, 30);
        System.out.format("La %s quincena ha llovido más que la otra\n", (quincena1 >= quincena2) ? "primera" : "segunda");
        System.out.format("Ha habido %d dias en los que ha llovido menos que el dia siguiente\n", menoresQueElSiguiente(lluvias));
    }
}

