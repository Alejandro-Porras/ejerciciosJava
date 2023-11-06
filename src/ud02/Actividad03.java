package ud02;

import java.util.Scanner;

public class Actividad03 {
    public static int descubrePorcentaje(double orig, double rebaj){
        return (int)Math.round(100*(orig-rebaj)/orig);
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double original, rebajado;

        System.out.println("Introduce ek precio original:");
        original= entrada.nextDouble();
        System.out.println("Introduce el precio rebajado:");
        rebajado= entrada.nextDouble();

        System.out.println("El porcentaje aplicado es:"+ 
                            descubrePorcentaje(original, rebajado)+ "%");
        entrada.close();
    }
}
