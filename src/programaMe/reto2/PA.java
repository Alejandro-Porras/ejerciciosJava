package programaMe.reto2;

import java.util.Scanner;

public class PA {
    public static boolean comprobarCadena(String[] v, int cantidadNumeros){
        boolean resultado = true;
            if (v.length==cantidadNumeros) {
                for (int i = 0; i < v.length-1; i++) {
                    int numInt1 = Integer.parseInt(v[i]);
                    int numInt2 = Integer.parseInt(v[i+1]);

                    // Si el primero es menor que el segundo
                    if (Math.abs(numInt1)<Math.abs(numInt2)) {
                        // Si el primero es negativo y el segundo es negativo.
                        if (numInt1<0) {
                            // Y el segundo es negativo
                            if (numInt2<0) {
                                return false;
                            }
                            // Si el primero es positivo y el segundo positivo
                        } else {
                            if (numInt2>0) {
                               return false; 
                            }
                        }
                    // Si el primero es mayor o igual que el segundo
                    }else{
                        if (numInt1<0) {
                            // Y el segundo es negativo
                            if (numInt2>0) {
                                return false;
                            }
                            // Si el primero es positivo y el segundo positivo
                        } else {
                            if (numInt2<0) {
                               return false; 
                            }
                        }
                    }
                }
            }else{
                resultado = false;
            }
        return resultado;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Se añade el numero de veces que se recorrera:
        int numVeces = entrada.nextInt();
        // Realizamos el bucle
        for (int i = 0; i < numVeces; i++) {
            int cantidadNumeros = entrada.nextInt();
            entrada.nextLine();
            String numero = entrada.nextLine();
            String[] arrayNumeros = numero.split(" ");
            
            if (comprobarCadena(arrayNumeros, cantidadNumeros)) {
                System.out.println("CORRECTA");
            } else {
                System.out.println("INCORRECTA");
            }
        }
        entrada.close();
    }
}
