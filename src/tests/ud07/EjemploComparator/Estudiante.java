package tests.ud07.EjemploComparator;

import java.util.Comparator;

public class Estudiante {
    private int id;
    private String nombre;

    public Estudiante(int i, String n){
        this.id = i;
        this.nombre = n;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    //comparators

    static class IdComparator implements Comparator<Estudiante>{
        public int compare (Estudiante e1, Estudiante e2){
            return e1.getId()-e2.getId();
        }
    }

    static class IdDescComparator implements Comparator<Estudiante>{
        public int compare (Estudiante e1, Estudiante e2){
            return e2.getId()-e1.getId();
        }
    }

    static class NombreComparator implements Comparator<Estudiante>{
        public int compare (Estudiante e1, Estudiante e2){
            return e1.getNombre().compareTo(e2.getNombre());
        }
    }

    @Override
    public String toString() {
        return String.format("Id:%5d | nombre:%-50s", getId(), getNombre());
    }
}
