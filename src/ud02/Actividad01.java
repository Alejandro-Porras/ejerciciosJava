package ud02;

import java.util.Scanner;

public class Actividad01 {
    public static double celsiusToFarenheit (double celsius){

        return (1.8*celsius)+32;
    }

    /**
     * The function `farenheitToCelsius` converts a temperature value from Fahrenheit to Celsius.
     * 
     * @param farenheit The parameter `farenheit` represents a temperature value in Fahrenheit that you
     * want to convert to Celsius. The `farenheitToCelsius` method takes this Fahrenheit temperature as
     * input and returns the equivalent temperature in Celsius.
     * @return The method `farenheitToCelsius` is returning the temperature converted from Fahrenheit
     * to Celsius.
     */
    public static double farenheitToCelsius (double farenheit){

        return (farenheit-32)/1.8;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double celsius;
        double farenheit;

        System.out.println("introduce grados en Celsius");
        celsius = entrada.nextDouble();
        System.out.println("Grados en Farenheit es: "+celsiusToFarenheit(celsius));
        
        System.out.println("introduce grados en Farenheit");
        farenheit = entrada.nextDouble();
        System.out.printf("Grados en Celsius es: %.2f",farenheitToCelsius(farenheit));
        entrada.close();
    }
}
