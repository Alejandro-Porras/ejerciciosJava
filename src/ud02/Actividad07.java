package ud02;

import java.util.Scanner;

public class Actividad07 {

 private double pesoEnKg;



 public Actividad07 (double pesoEnKg){

 this.pesoEnKg = pesoEnKg;

 }

 //hacemos el get/return de el calculo de Libras

 public double getLibras(){

 return this.pesoEnKg / 0.453;

 }



 //hacemos el get/return de el calculo de Lingotes

 public double getLingotes(){

 return this.pesoEnKg / 14.59;

 }



 public double getPeso (String unidad){

 if (unidad.equals("Kg")) {

 return this.pesoEnKg;

 } else if(unidad.equals("Lb")) {

 return this.getLibras();

 } else if (unidad.equals("Li")) {

 return this.getLingotes();

 } else if (unidad.equals("Oz")){

 return this.pesoEnKg / 0.02835;

 } else if (unidad.equals("P")){

 return this.pesoEnKg / 0.00155;

 } else if (unidad.equals("G")) {

 return this.pesoEnKg * 1000;

 } else if (unidad.equals("Q")){

 return this.pesoEnKg / 43.3;

 } else {

 System.out.println("no has introducido una unidad correcta.");

 return 0;

 }

 }



 public static void main(String[] args) {

 double peso;

 String unidad;

 Scanner entrada = new Scanner(System.in);

 System.out.print("\nAñade el peso en kg: ");

 peso = entrada.nextDouble();

 Actividad07 masa = new Actividad07(peso);

 System.out.print("\nAñade la unidad elegida: Kg (Kg), Libras (Lb), Lingotes (Li), Onzas (Oz), Peniques (P) y Quintales (Q): ");

 unidad = entrada.next();

 System.out.println("\n\nEl peso en kilogramos es: "+ masa.pesoEnKg +" Kg");

 System.out.printf("El peso en %s es: %.2f %s\n", unidad, masa.getPeso(unidad), unidad);

 System.out.println();

 entrada.close();

 }
}
