package test;
/*
 * Ejercicio entrada de datos:
 * se introduce por teclado nombre, apellidos, edad, num.dni, sueldo
 * se muestra por pantalla nombre, apellidos, edad, NIF, sueldo + 20%
 */

import java.util.*;

public class EjercicioEntradaDatos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        String apellidos;
        int edad;
        int numDni;
        double sueldo;


        System.out.print("Introduce tu nombre:\t");
        nombre = teclado.nextLine();

        System.out.print("Introduce tus apellidos:\t");
        apellidos = teclado.nextLine();

        System.out.print("Introduce tu edad:\t");
        edad = teclado.nextInt();
        
        System.out.print("Introduce tu num.dni:\t");
        numDni = teclado.nextInt();

        System.out.print("Introduce tu sueldo:\t");
        sueldo = teclado.nextDouble();

        System.out.println("Tu nombre es "+ nombre + " " + apellidos);
        System.out.println("Si tu edad es "+ edad + (edad>=18?"Eres mayor de edad":"eres menor de edad, pollo"));
        
        // calcular letra dni.
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numDni % 23;
        System.out.println("Tu NIF es: "+ numDni + "-" + letrasDNI.charAt(resto));
        System.out.println("Tu sueldo era "+sueldo+" con el incremento será " + sueldo*1.2);
        teclado.close();
    }
}
