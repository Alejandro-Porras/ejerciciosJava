package ud06.Ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej17_CalculosPersonas {
    public static void leerFichero(){
        try (DataInputStream dis = new DataInputStream(
                                        new BufferedInputStream(
                                            new FileInputStream("./src/ud06/Ejercicios/Files/Ej14_nombres.log")))) {
            while (true) {
                System.out.println("Nombre -> " + dis.readUTF());
                System.out.println("Edad -> " + dis.readInt());
                System.out.println("Peso -> " + dis.readDouble());
                System.out.println("Estatura -> " + dis.readDouble());
                System.out.println();
            }
        } catch (EOFException e) {
            System.out.println("/");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }

    public static void leerCalculo(){
        int cont = 0;
        int suma = 0;
        try (DataInputStream dis = new DataInputStream(
                                        new BufferedInputStream(
                                            new FileInputStream("./src/ud06/Ejercicios/Files/Ej14_nombres.log")))) {
            while (true) {
                dis.readUTF();
                int edad = dis.readInt();
                dis.readDouble();
                double estatura = dis.readDouble();
                if (edad>=20 && edad<=30) {
                    suma+=estatura;
                    cont++;
                }
            }
        } catch (EOFException e) {
            System.out.println("/");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
        System.out.println(suma/cont);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nombre;
        int edad;
        double peso;
        double estatura;
        boolean bool = false;
        boolean leer = false;

        System.out.println("Quieres Sobreescribir?");
        char option = entrada.nextLine().toLowerCase().charAt(0);
        bool = (option=='s' || option=='y');

        do {
            System.out.print("Introduzca el nombre: ");
            nombre = entrada.nextLine();
            if (!nombre.isEmpty()) {
                System.out.print("Introduzca la edad: ");
                edad = entrada.nextInt();
                System.out.print("Introduzca el peso: ");
                peso = entrada.nextDouble();
                System.out.print("Introduzca la estatura: ");
                estatura = entrada.nextDouble();
                System.out.println();
                try (DataOutputStream dos = new DataOutputStream(
                                                new BufferedOutputStream(
                                                    new FileOutputStream("./src/ud06/Ejercicios/Files/Ej14_nombres.log", !bool)))) {
                    dos.writeUTF(nombre);
                    dos.writeInt(edad);
                    dos.writeDouble(peso);
                    dos.writeDouble(estatura);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                entrada.nextLine();
            }
        } while (!nombre.isEmpty());
        
        System.out.println("Quiere leer el fichero? ");
        option = entrada.nextLine().toLowerCase().charAt(0);
        leer = (option=='s' || option=='y');
        
        if (leer) {
            leerFichero();
            leerCalculo();
        }

        entrada.close();
    }
}
