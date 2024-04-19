package ud07.ejercicios.Ejer02_Biblioteca;

import java.util.LinkedList;

public class CatalogoLibrosRepetidos {

    private LinkedList<Libro> catalogo = new LinkedList<>();

    

    public CatalogoLibrosRepetidos(Libro v[]){
        for (int i = 0; i < v.length; i++) {
            catalogo.add(v[i]);
        }
    }

    public String buscar(Libro l){
        String str = null;
        
        if (catalogo.contains(l)) {
            str = l.getEstanteria();
        }

        return str;
    }
}
