package ud02;

import java.util.Scanner;

public class Actividad04 {
    private double cambio;

    public Actividad04(){      
        this.cambio = 1.02; 
    }

    public Actividad04(double cambio){
        this.cambio = cambio;
    }

    public double dolaresToEuros(double dolares){
        return (dolares*this.cambio);
    }

    public double eurosToDolares(double euros){
        return euros/this.cambio;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Actividad04 moneda = new Actividad04();
        double dinero;

        System.out.println("Euros:");
        dinero = entrada.nextDouble();
        System.out.printf("cambio a dolares: %.2f", moneda.eurosToDolares(dinero));
        entrada.close();
    }
}
