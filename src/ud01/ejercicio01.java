package ud01;
import java.util.*;
/*
 * 1. Ejercicio 01. Probar la E/S elemental: Escribe el pequeño programa que aparece a
 *continuación.
 */
    public class Ejercicio01 {
        public static void main (String arg[]){
            Scanner tec = new Scanner(System.in);
            int a, b;

            System.out.println("Introduce un número entero");
            a = tec.nextInt();

            System.out.println("Introduce otro número entero");
            b = tec.nextInt();

            System.out.println("Los números introducidos son " + a + " y " + b);
            tec.close();
        }
    }
/*
 * ¿Qué ocurre si cuando nos pide un número entero le damos un número real? 
 * Da error ya que no es un numero entero, sino un float o double
 * 
 * ¿Y si le damos un carácter no numérico?
 * Tambien da error ya que no es un numero entero, sino un float o double
 * 
 * ¿Qué ocurre si eliminamos la instrucción import java.util.* ;
 *  Que no podremos utilizar la funcion Scanner
 */