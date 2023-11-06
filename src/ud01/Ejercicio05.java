package ud01;
import java.util.Scanner;
public class Ejercicio05 {
    /*5. Ejercicio 05. (Intercambio) Escribir un programa que …
        1. Lea desde teclado dos valores enteros. Llama a las variables v1 y v2.
        2. Muestra los valores introducidos por el usuario.
        3. Intercambia el valor de v1 y v2 (v1 pasa a valer lo que valía v2 y viceversa).
        4. Muestra de nuevo los valores, ahora con su valor intercambiado.*/
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int v1;
        int v2;
        int intercambio;
        System.out.print("Escribe un número para v1: ");
        v1=entrada.nextInt();

        System.out.print("Escribe un número para v2: ");
        v2=entrada.nextInt();
        System.out.println("Antes de intercambiar\tv1: "+ v1 + "\t\t y\tv2: " + v2);
        
        intercambio=v1;
        v1=v2;
        v2=intercambio;
        
        System.out.println("Después de intercambiar\tv1: "+ v1 + "\t\t y\tv2: " + v2);
        entrada.close();
    }

}
