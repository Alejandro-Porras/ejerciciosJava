package tests.test_v2;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej15_AnyadirPersonas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("Introduce 1 si quieres reemplazar los datos o 2 si quieres continuarlos:");
            int elec = entrada.nextInt(); 
            FileOutputStream fos;
            entrada.nextLine();
            // El objetivo es poder activar o no el apend
            // El problema es que el bucle while me lo coge como vacio y no puedo añadir datos
            if (elec == 1) {
                fos = new FileOutputStream("personas.dat", false);
            } else {
                fos = new FileOutputStream("personas.dat", true);
            }
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);

            while (true) {
                System.out.print("Introduce el nombre(Vacio para terminar): ");
                String nombre = entrada.nextLine();
                dos.writeUTF(nombre);
                if(nombre.isEmpty()){
                    break;
                }
                System.out.print("Introduce la edad: ");
                int edad = entrada.nextInt();
                dos.writeInt(edad);
                System.out.print("Introduce el peso: ");
                double peso = entrada.nextDouble();
                dos.writeDouble(peso);
                System.out.print("Introduce la estatura: ");
                double estatura = entrada.nextDouble();
                dos.writeDouble(estatura);

                entrada.nextLine();
            }
            fos.close();
            bos.close();
            dos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        entrada.close();
    }
}