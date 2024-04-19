package ud06.Ejercicios.Ej18_GuardaLibros;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardaLibros {
    public static void main(String[] args) {
        Autor a1 = new Autor("Santiago Posteguillo", 1965, "Español");
        Autor a2 = new Autor("Miguel Hernández", 1900, "Español");

        Libro l1 = new Libro("Roma soy yo", 2023, a1);
        Libro l2 = new Libro("Cartas a mi tierra", 1933, a2);
        Libro l3 = new Libro("Escipión el Africano", 2012, a1);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/ud06/Ejercicios/Files/Ej18_biblioteca.log"))) {
            oos.writeObject(l1);
            oos.writeObject(l2);
            oos.writeObject(l3);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
