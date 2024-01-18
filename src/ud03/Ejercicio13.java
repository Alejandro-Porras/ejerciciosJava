package ud03;

import java.util.Scanner;

public class Ejercicio13 {

    private int horas;
    private int sueldo;
    private double sueldoNeto;
    private int horasOrdinarias = 6;
    private int horasExtraOrdinarias = 10;
    private double menorQue = 0.02;
    private double mayorQue = 0.1;

    public Ejercicio13(){

    }

    public Ejercicio13(int horas){
        this.horas=horas;
    }

    public int calcularSueldo(){
        if (this.horas<=40) {
            this.sueldo=horas*horasOrdinarias;
        } else {
            this.sueldo=((horas-40) * horasExtraOrdinarias) + (40 * horasOrdinarias);
        }
        return sueldo;
    }
    public double salarioNeto(){

        if (this.sueldo<=350) {
            this.sueldoNeto = (double)this.sueldo - ((double)this.sueldo * menorQue) ;
        } else {
            this.sueldoNeto = (double)this.sueldo - ((double)this.sueldo * mayorQue) ;
        }
        return sueldoNeto;
    }

    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        int horas;

        System.out.println("Introduzca horas: ");
        horas = entrada.nextInt();

        Ejercicio13 calc1 = new Ejercicio13(horas);

        System.out.println("Sueldo: " + calc1.calcularSueldo());
        System.out.println("Sueldo neto: " + calc1.salarioNeto());

        entrada.close();
    }
}
