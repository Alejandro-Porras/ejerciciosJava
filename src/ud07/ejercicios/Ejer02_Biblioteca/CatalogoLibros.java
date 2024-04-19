package ud07.ejercicios.Ejer02_Biblioteca;

import java.util.HashSet;

public class CatalogoLibros {

    private HashSet<Libro> catalogo = new HashSet<>();

    

    public CatalogoLibros(Libro v[]){
        for (int i = 0; i < v.length; i++) {
            catalogo.add(v[i]);
        }
    }

    public String buscar(Libro l){
        String str = "";
        
        if (catalogo.contains(l)) {
            str = l.getEstanteria();
        }else{
            str = "null";
        }

        return str;
    }
}
