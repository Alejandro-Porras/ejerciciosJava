package tests.ud06.examen.miki;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class TestAlumnos {
    public static void main(String[] args) {
        //Se pretende mostrar los datos de alumno.dat ordenados como indica el examen
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/tests/ud06/examen/miki/alumnos.dat"))) {
            while (true) {
                System.out.println(ois.readObject());
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            // System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
