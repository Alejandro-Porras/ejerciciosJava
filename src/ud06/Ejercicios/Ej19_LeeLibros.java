package ud06.Ejercicios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import ud06.Ejercicios.Ej18_GuardaLibros.Libro;

public class Ej19_LeeLibros {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/ud06/Ejercicios/Files/Ej18_biblioteca.log"))) {
            while (true) {
                Libro l = (Libro) ois.readObject();
                System.out.println(l);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            // nada
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
