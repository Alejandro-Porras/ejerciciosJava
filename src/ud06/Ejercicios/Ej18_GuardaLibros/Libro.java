package ud06.Ejercicios.Ej18_GuardaLibros;

import java.io.Serializable;

public class Libro implements Serializable{
    private String titulo;
    private int anyoEdicion;
    private Autor autor;

    public Libro(String tit, int any, Autor aut){
        this.titulo=tit;
        this.anyoEdicion=any;
        this.autor=aut;
    }

    @Override
    public String toString() {
        return "\nLibro -> " + this.titulo +
                "\nAnyo Edicion -> " + this.anyoEdicion + 
                "\nAutor -> " + this.autor;
    }
}
