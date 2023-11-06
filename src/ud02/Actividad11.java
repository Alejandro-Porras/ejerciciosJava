package ud02;

import java.util.Scanner;

public class Actividad11 {
    private double km;
    private double litros;
    private double vmed;
    private double pgas;

    //constructor con todos los parámetros.
    public Actividad11 (double km, double litros, double vmed, double pgas){
        this.km = km; //Kilometro recorridos
        this.litros = litros; //litros de gasolina gastados en el viaje
        this.vmed = vmed; //velocidad media del viaje
        this.pgas = pgas; //precio de la gasolina
    }

    //conseguir tiempo del viaje
    public double getTiempo(){
        return this.km/this.vmed;
    }
    
    //conseguir el consumo medio
    public double consumoMedio(){
        return this.litros * 100 / this.km;
    }

    //conseguir precio del consumo cada 100%
    public double consumoEuros(){
        return this.litros * 100 /this.pgas;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public void setVmed(double vmed) {
        this.vmed = vmed;
    }

    public void setPgas(double pgas) {
        this.pgas = pgas;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double kms;
        double lts;
        double vm;
        double pg;

        System.out.print("\n\nIntroduzca kilometros realizados: ");
        kms = entrada.nextDouble();
        System.out.print("Introduzca litros consumidos: ");
        lts = entrada.nextDouble();
        System.out.print("Introduzca velocidad media: ");
        vm = entrada.nextDouble();
        System.out.print("Introduzca precio de gasolina: ");
        pg = entrada.nextDouble();

        Actividad11 consumo = new Actividad11(kms, lts, vm, pg);

        System.out.printf("\n\nEl tiempo transcurrido es: %.2f horas", consumo.getTiempo());
        System.out.printf("\nEl consumo medio de gasolina es: %.2f (l/100km)", consumo.consumoMedio());
        System.out.printf("\nEl consumo medio en euros es: %.2f (€/100km)", consumo.consumoMedio());

        entrada.close();
    }
}
