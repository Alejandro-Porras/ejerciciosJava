package ud06.Ejercicios.Ej18_GuardaLibros;

import java.io.Serializable;

public class Autor implements Serializable{
    private String nombre;
    private int anyoNacimiento;
    private String nacionalidad;

    public Autor (String n, int a, String na){
        this.nombre = n;
        this.anyoNacimiento = a;
        this.nacionalidad = na;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnyoNacimiento() {
        return anyoNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return this.nombre + " - " + this.anyoNacimiento + " - " + this.nacionalidad;
    }
}
