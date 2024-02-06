package tests.ud06.act1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaDatos {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"))) {
            String nia;
            int cont = 1;
            while ((nia = br.readLine())!=null) {                
            System.out.println("Alumno - " + cont + " -");
            System.out.println("nia: " + nia);
            System.out.println("Nombre: " + br.readLine());
            System.out.println("Apellidos: " + br.readLine());
            System.out.println("Curso: " + br.readLine());
            System.out.println();
            cont++;
            }
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        }
    }
}
