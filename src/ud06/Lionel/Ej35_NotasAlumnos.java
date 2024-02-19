package ud06.Lionel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej35_NotasAlumnos {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("./src/ud06/Lionel/DOCS/alumnos_notas.txt"))) {
            String linea = "";
            while ((linea=br.readLine())!=null) {
                String[] listaLinea = linea.split(" ");
                String str = "Nombre -> " + listaLinea[0] + "\r\t\t\t Apellido -> " + listaLinea[1];
                int suma = 0;
                int cont = 0;
                for (int i = 2; i < listaLinea.length; i++) {
                    suma += Integer.parseInt(listaLinea[i]);
                    cont++;
                }
                str += "\r\t\t\t\t\t\t\t\t Media -> " + (suma/cont) + " (truncada)";
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -> " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }
}
