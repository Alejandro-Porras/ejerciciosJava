package ud01;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        
    
    /*Averigua mediante pruebas:
    1. ¿Es pos.ible escribir dos instrucciones en la misma línea de un programa?

    Si,ejemplo*/
        Scanner tec = new Scanner(System.in); int a, b; System.out.println("Introduce un número entero");a = tec.nextInt();
    /*2. ¿Se puede "romper" una instrucción entre varias líneas?

    Si, ejemplo*/
        System.out.println
        ("Introduce otro número entero");
        b = tec.
        nextInt();

        System.out.println
        ("Los números introducidos son " + 
        a + " y " + 
        b);
        tec.close();
    /*3. Algunos lenguajes de programación dan un valor por defecto a las variables
    cuando las declaramos sin inicializarlas. Otros no permiten usar el contenido de
    una variable que no haya sido previamente inicializada. ¿Cuál es comportamiento
    de Java?

    En Java hay que inicializar las variables.Ejemplo: */
    //Si se descomenta saldra el error de no inicializacion
    /*int x;
    String y;
    
    System.out.println(x);
    System.out.println(y);*/
    }
}
