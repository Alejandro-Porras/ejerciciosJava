package ud07.ejercicios.Ejer03_Academia;

import java.util.TreeSet;

public class Academia {
    private String nombre;
    private String direccion;
    private TreeSet<Aula> aulas = new TreeSet<>();

    public Academia(String nombre, String direccion, TreeSet<Aula> aulas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.aulas = aulas;
    }

    public void ampliar (Aula a){
        aulas.add(a);
    }

    public void quitar (Aula a){
        aulas.remove(a);
    }

    public int getNumAulas(){
        return aulas.size();
    }

    @Override
    public String toString() {
        String str = "Academia " + nombre + "\n Direccion -> " + direccion + "\n-----AULAS-----";

        for (Aula aula : aulas) {
            str += aula.toString() + "\n";
        }
        
        return str;
    }
    
}
