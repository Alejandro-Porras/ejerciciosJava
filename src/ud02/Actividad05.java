package ud02;

import java.util.Scanner;

public class Actividad05 {
    private int numero;
    
    public Actividad05 (){

    }

    public Actividad05 (int numero){
        this.numero=numero;
    }

    public int dobleDeNumero(){
        return numero*2;
    }
    public int tripleDeNumero(){
        return numero*3;
    }
    public int cuadrupleDeNumero(){
        return numero*4;
    }
    
    public static void main(String[] args) {
        int numero1;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el numero");
        numero1 = entrada.nextInt();

        Actividad05 calculo = new Actividad05(numero1);
        System.out.println("Numero seleccionado: "+numero1);
        System.out.println();

        System.out.println("El doble del numero es: " + calculo.dobleDeNumero());
        
        System.out.println("El triple del numero es: " + calculo.tripleDeNumero());

        System.out.println("El cuadruple del numero es: " + calculo.cuadrupleDeNumero());

        entrada.close();
    }
}
