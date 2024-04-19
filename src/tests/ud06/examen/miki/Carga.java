package tests.ud06.examen.miki;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Carga {
    public static void main(String[] args) {

    //Lo que estoy intentando hacer, es que estos datos se escriban sobre el fichero alumnos.dat
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/tests/ud06/examen/miki/alumnos.dat"))) {
        oos.writeObject(new Alumno("Jose", "Martinez Sebo", "SMX1", 5.9));
        oos.writeObject(new Alumno("Lucia", "Abraham Tea", "SMX2", 5.5));
        oos.writeObject(new Alumno("Carles", "Galan Ruiz", "DAW1", 6.7));
        oos.writeObject(new Alumno("Fidel", "Alvarez Pino", "DAW2", 7.9));
        oos.writeObject(new Alumno("Eusebio", "Sacramento Aparisi", "DAW2", 7.5));
        oos.writeObject(new Alumno("Maria", "Alvarez Bernabe", "SMX1", 6.2));
        oos.writeObject(new Alumno("Carla", "Del Arbol Ruiz", "DAW1", 7.9));
        oos.writeObject(new Alumno("Jose", "Ruiz Gonzalez", "SMX2", 8.4));
        oos.writeObject(new Alumno("Natalia", "Gonzalez Bisbal", "SMX2", 9.3));
        oos.writeObject(new Alumno("Elena", "Grande Martinez", "SMX2", 5.5));
        oos.writeObject(new Alumno("Carmen", "Sanchez Herminio", "DAW1", 6.1));
        oos.writeObject(new Alumno("Jesus", "Lopez Lopez", "DAW1", 6.9));
        oos.writeObject(new Alumno("Ana", "Ferrer Ortiz", "SMX1", 8.9));
        oos.writeObject(new Alumno("Angel", "Vila Labanda", "DAW2", 5.9));
        oos.writeObject(new Alumno("Zoe", "Carrus Monegro", "SMX1", 6.8));
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    }
}
