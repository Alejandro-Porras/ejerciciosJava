package tests.ud06.examen.miki;

import java.io.Serializable;

public class Alumno implements Serializable{

    //Creacion de Variables
    private String nombre;
    private String apellidos;
    private String curso;
    private double nota;


    //Contructor con todos los parametros
    public Alumno(String nombre, String apellidos, String curso, double nota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.nota = nota;
    }

    //Getters
    public String getNombre() {
        return this.nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    public String getCurso() {
        return this.curso;
    }
    public double getNota() {
        return this.nota;
    }

    //Metodo compareTo que comparará los apellidos de los alumnos por ordena alfabetico
    public int compareTo (Alumno o){
        return this.apellidos.compareTo(o.apellidos);
    }
    
   // Se muestran los datos
    @Override
    public String toString() {
        return nombre + " " + apellidos + " " + curso + " " + nota;
    }
}
