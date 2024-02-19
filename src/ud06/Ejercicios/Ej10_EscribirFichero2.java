package ud06.Ejercicios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej10_EscribirFichero2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // escriba los caracteres de tu nombre en un fichero y los vaya añadiendo ( nombres.log ).
        try (FileWriter fw = new FileWriter("./src/ud06/Ejercicios/Files/Ej10_nombres.log")) {
            System.out.print("Introduzca su nombre: ");
            fw.write(entrada.nextLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // lea el fichero creado y lo muestre por pantalla
        try (FileReader fr = new FileReader("./src/ud06/Ejercicios/Files/Ej10_nombres.log")) {
            int caracter;
            while ((caracter=fr.read())!=-1) {
                System.out.print((char)caracter + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        entrada.close();
    }
}
