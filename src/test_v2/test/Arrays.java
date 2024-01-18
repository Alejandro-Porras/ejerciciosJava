package test_v2.test;

import java.util.Scanner;

public class Arrays {
    public static String nombreMes(int mes){
        String nombre[] = {"Enero","Febrero","Marzo","Abril",
                            "Mayo","Junio","Julio","Agosto","Septiembre",
                            "Octubre","Noviembre","Diciembre"};
        return nombre[--mes];
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el numero del mes:");

        System.out.println(nombreMes(entrada.nextInt()));
    
        entrada.close();
    }
}
