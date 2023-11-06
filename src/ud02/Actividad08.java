package ud02;

import java.util.Scanner;

public class Actividad08 {
    double millas;

    public Actividad08(double millas){
        this.millas = millas;
    }
    public double millasAMetros (){
        return this.millas*1852 ;
    }
    public double metrosAMillas (double metros){
        return metros/1852;
    }

    public static void main(String[] args) {
    Scanner entrada= new Scanner(System.in);
    
    double millas;
    double metros;
    System.out.println("Introduzca millas");
    millas = entrada.nextDouble();

    Actividad08 distancia = new Actividad08(millas);

    System.out.printf("%.2f millas son: %.1f metros\n\n" , millas , distancia.millasAMetros());

    System.out.println("Introduzca metros para pasarlos a millas: ");
    metros = entrada.nextDouble();

    System.out.printf("%.2f metros son: %.4f millas" , metros , distancia.metrosAMillas(metros));

    entrada.close();
    }
}
