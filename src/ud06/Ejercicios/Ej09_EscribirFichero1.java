package ud06.Ejercicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej09_EscribirFichero1 {
    public String RUTA = "./src/ud06/Ejercicios/Files/";
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduzca su nombre: ");
        String nombre = entrada.nextLine();

        // escriba los caracteres de tu nombre en un fichero y los vaya añadiendo ( nombres.log ).
        try (FileOutputStream fos = new FileOutputStream("./src/ud06/Ejercicios/Files/Ej09_nombres.log")) {
            for (int i = 0; i < nombre.length(); i++) {
                fos.write(nombre.charAt(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // lea el fichero creado y lo muestre por pantalla
        try (FileInputStream fis = new FileInputStream("./src/ud06/Ejercicios/Files/Ej09_nombres.log")) {
            int resu;
            while ((resu=fis.read())!=-1) {
                System.out.println((char)resu);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Si abrimos el fichero creado con un editor de textos, ¿su contenido es legible?
        // Si, aunque no deberia, ya que es un fichero binario, se puede leer ya que al guardarlo y estar en ascii se traduce.

        entrada.close();
    }
}
