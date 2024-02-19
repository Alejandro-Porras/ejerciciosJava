package ud06.Ejercicios;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej14_Personas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nombre;
        int edad;
        double peso;
        double estatura;

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
                                                    new FileOutputStream("./src/ud06/Ejercicios/Files/Ej14_nombres.log", true)))) {
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
        entrada.close();
    }
}
