package ud02;

import java.util.Scanner;

public class Actividad12 {
    private double patatas;
    private double carne;

    public Actividad12(){

    }

    public Actividad12(double patatas, double carne){
        this.patatas=patatas;
        this.carne=carne;
    }

    public double cuantosClientesXMateria(){
        double clientes;
        if ((patatas/2)<carne) {
            clientes=3*(patatas/2);
        } else {
            clientes=3*carne;
        }
        return clientes;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double patatas;
        double carne;
        
        System.out.print("Introduzca los kilos de patatas: ");
        patatas=entrada.nextDouble();

        System.out.print("Introduzca los kilos de carne: ");
        carne=entrada.nextDouble();

        Actividad12 comida = new Actividad12(patatas, carne);

        System.out.printf("Con la materia prima se puede dar de comer a %.1f",comida.cuantosClientesXMateria());

        entrada.close();
    }
}
