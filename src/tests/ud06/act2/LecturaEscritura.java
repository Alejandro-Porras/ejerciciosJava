package tests.ud06.act2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class LecturaEscritura {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"))) {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("alumnosDaw.dat"));

            String cadena;
            String nombre;
            String apellido;
            String curso;
            while ((cadena = br.readLine())!=null) {
            
            int nia =Integer.parseInt(cadena);
            nombre = br.readLine();
            apellido = br.readLine();
            curso = br.readLine();
            
                if (curso.indexOf("daw")>=0) {
                    dos.writeInt(nia);
                    dos.writeUTF(nombre);
                    dos.writeUTF(apellido);
                    dos.writeUTF(curso);
                }
            }
            dos.close();
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        }
    }
}
