package ud02;

import java.util.Scanner;

public class Actividad13 {
        private double patatas;
    private double carne;

    public Actividad13(){
        this.patatas=2;
        this.carne=1;
    }

    public Actividad13(double patatas, double carne){
        this.patatas=patatas;
        this.carne=carne;
    }

    public void addPatatas(double patatas){
        this.patatas+=patatas;
    }

    public void addCarne(double carne){
        this.carne+=carne;
    }
    

    public double getComensales(){
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

        Actividad13 comida = new Actividad13();
        
        System.out.print("Introduzca los kilos de patatas a los ya existentes: ");
        patatas=entrada.nextDouble();
        comida.addPatatas(patatas);

        System.out.print("Introduzca los kilos de carne a los ya existentes: ");
        carne=entrada.nextDouble();
        comida.addCarne(carne);
        

        System.out.printf("Con la materia prima se puede dar de comer a %.1f",comida.getComensales());

        entrada.close();
    }
}
