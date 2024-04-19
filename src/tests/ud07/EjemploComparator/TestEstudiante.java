package tests.ud07.EjemploComparator;

import java.util.TreeSet;
import tests.ud07.EjemploComparator.Estudiante.*;

public class TestEstudiante {
    public static void main(String[] args) {
        System.out.println("comparando por id:");
        TreeSet<Estudiante> setId = new TreeSet<>(new IdComparator());
        
        setId.add(new Estudiante(450,"Laura"));
        setId.add(new Estudiante(341,"Esther"));
        setId.add(new Estudiante(134,"Daniel"));
        setId.add(new Estudiante(590,"Jorge"));

        for (Estudiante estudiante : setId) {
            System.out.println(estudiante);
        }

        System.out.println("\ncomparando por id descendente:");
        TreeSet<Estudiante> setDescId = new TreeSet<>(new IdDescComparator());
        
        setDescId.add(new Estudiante(450,"Laura"));
        setDescId.add(new Estudiante(341,"Esther"));
        setDescId.add(new Estudiante(134,"Daniel"));
        setDescId.add(new Estudiante(590,"Jorge"));

        for (Estudiante estudiante : setDescId) {
            System.out.println(estudiante);
        }

        System.out.println("\ncomparando por nombre:");
        TreeSet<Estudiante> setNombre = new TreeSet<>(new NombreComparator());
        
        setNombre.add(new Estudiante(450,"Laura"));
        setNombre.add(new Estudiante(341,"Esther"));
        setNombre.add(new Estudiante(134,"Daniel"));
        setNombre.add(new Estudiante(590,"Jorge"));

        for (Estudiante estudiante : setNombre) {
            System.out.println(estudiante);
        }
    }
}