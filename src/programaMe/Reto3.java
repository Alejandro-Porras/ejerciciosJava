package programaMe;

import java.util.Scanner;

public class Reto3 {
    //metodo de calculo de los datos
    public static int calculo(int[] v){
        //creamos la variable resu que ira sumando valores
        int resu = 0;
            //cuando es par, realizamos el calculo 
            //del IF cuando es impar el del else
            for (int i = 0; i < v.length; i++) {
                if (i%2==0) {
                    resu+=(v[i]*3+(minimo(v, i)));
                }else{
                    resu+=(v[i]*2+(maximo(v, i)));
                }
            }
        //devolvemos el resultado
        return resu;
    }

    //En este metodo sacamos el numero maximo desde la posicion a la izquierda.
    public static int maximo(int[] v, int posi){
        int max = v[posi];
        for (int i = posi-1; i >= 0; i--) {
            if (v[i]>max) {
                max=v[i];
            }
        }
        return max;
    }

    //En este metodo sacamos el numero minimo desde la posicion a la derecha.
    public static int minimo(int[] v, int posi){
        int min = v[posi+1];
        for (int i = posi+1; i < v.length; i++) {
            if (v[i]<min && v[i]>0){
                min=v[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        //introducimos el numero de repeticiones del codigo de abajo.
        int repes=entrada.nextInt();
        //introducimos este salto de linea para que no se coma el de abajo
        entrada.nextLine();
            //bucle para realizar la introduccion de datos en las repeticiones de arriba
            for (int i = 0; i < repes; i++) {
                //introduccion de datos en String
                String num = entrada.nextLine();
                //los pasamos a array
                    //creamos el array
                    int[] numArray = new int[num.length()];
                    //recorremos el array colocandole la cifra
                    for (int j = 0; j < num.length(); j++) {
                        char digitoChar = num.charAt(j);
                        int digito = Character.getNumericValue(digitoChar);
                        numArray[j] = digito;
                    }
                //SALIDA DEL CALCULO (metodo)
                System.out.println(calculo(numArray));
            }
        entrada.close();   
    }
}
