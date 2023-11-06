package ud02;

import java.util.Scanner;

public class Actividad06 {
    private int numero;
    
    public Actividad06 (){
        numero=0;
    }

    public Actividad06 (int numero){
        this.numero=numero;
    }

    public int getNumero(){
        return this.numero;
    }

    public void sumar(int mas){
        this.numero+=mas;
    }

    public void restar(int menos){
        this.numero-=menos;
    }

    public void dobleDeNumero(){
        numero*=2;
    }
    public void tripleDeNumero(){
        numero*=3;
    }
    
    public static void main(String[] args) {
        int numero1;
        int calc;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduzca el numero: ");
        numero1 = entrada.nextInt();

        Actividad06 calculo1 = new Actividad06(numero1);
        System.out.println("\nNumero seleccionado: "+numero1);
        System.out.println();

        System.out.print("Añade un numero para sumar al seleccionado: ");
        calc = entrada.nextInt();
        calculo1.sumar(calc);
            System.out.println("Resultado de la suma:" + calculo1.getNumero());

        System.out.print("\nAñade un numero para restar al seleccionado: ");
        calc = entrada.nextInt();
        calculo1.restar(calc);
            System.out.println("Resultado de la resta:" + calculo1.getNumero());
        
        calculo1.dobleDeNumero();
        System.out.println("\nEl doble del numero es: " + calculo1.getNumero());

        calculo1.tripleDeNumero();
        System.out.println("\nEl triple del numero es: " + calculo1.getNumero());

        entrada.close();
    }
}