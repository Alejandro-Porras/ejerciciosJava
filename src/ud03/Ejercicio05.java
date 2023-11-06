package ud03;

import java.util.Scanner;

public class Ejercicio05 {

    public static boolean tieneLetra(String dni){
        char ultimo = dni.toUpperCase().charAt(dni.length()-1);
        return (ultimo >=65 && ultimo <= 90);
    }

    public static char calcularLetraDni(String dni){
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = Integer.parseInt(dni);
        return letrasDNI.charAt(resto%23);
    }

    public static int extraeNumeroDni(String dni){
        return Integer.parseInt(dni.substring(0, dni.length()-1));
    }

    public static boolean validarLetraDNI(String dni){
        char letra = dni.toUpperCase().charAt(dni.length()-1);
        char letraCorrecta = calcularLetraDni(dni.substring(0,dni.length()-1));
        return letra==letraCorrecta;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String dni;

        System.out.println("Introduzca su DNI: ");
        dni = entrada.nextLine();

        System.out.println(dni);

        if (tieneLetra(dni)) {
            System.out.println("El DNI tiene letra: ");
            if (validarLetraDNI(dni)) {
                System.out.printf("\nEl dni %s es correcto", dni);
            } else {
                System.out.println("\nEl dni " + dni + "es incorrecto, el correcto seria " + extraeNumeroDni(dni) + 
                calcularLetraDni(dni.substring(0,dni.length()-1)));
            }
        } else {
            System.out.println("El DNI NO tiene letra: ");
            System.out.println("Su dni con letra seria: "+ dni + "-" + calcularLetraDni(dni));
        }
    
        entrada.close();
    }
}
