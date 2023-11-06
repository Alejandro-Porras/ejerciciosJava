package ud02;

import java.util.Scanner;

public class Actividad09 {
    private String marca;
    private String modelo;

    public Actividad09(){
    this.marca="Alfa Romeo";
    this.modelo="GT";
    }

    public Actividad09(String marca, String modelo){
    this.marca = marca;
    this.modelo = modelo;
    }

    @Override
    public String toString(){
        return "\nMarca= " + this.marca +
                "\nModelo= " + this.modelo;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String marca;
        String modelo;

        Actividad09 coche1 = new Actividad09();

        System.out.print("Introduzca la marca del coche: ");
        marca=entrada.nextLine();

        System.out.print("\nIntroduzca el modelo del coche: ");
        modelo=entrada.nextLine();

        Actividad09 coche2 = new Actividad09(marca, modelo);

        System.out.println("El coche1 es: "+coche1.toString());
        System.out.println("\nEl coche2 es: "+coche2.toString());

        entrada.close();
    }
}
