package ud07.ejercicios.Ejer08_EquipoDeFutbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ud07.ejercicios.Ejer08_EquipoDeFutbol.Futbolista.Posicion;

public class Equipo{
    private String nombre;
    private ArrayList<Futbolista> listaFutbolistas;
    public HashMap<Posicion, Integer> maxJugadoresPosicion = new HashMap<>();

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Futbolista> getListaFutbolistas() {
        ArrayList<Futbolista> lista = listaFutbolistas;
        return lista;
    }

    // public Equipo(String nombre, ArrayList<Futbolista> listaFutbolistas) {
    //     this.nombre = nombre;
    //     this.listaFutbolistas = listaFutbolistas;
    //     this.maxJugadoresPosicion.put(Posicion.PORTERO, 2);
    //     this.maxJugadoresPosicion.put(Posicion.DEFENSA, 5);
    //     this.maxJugadoresPosicion.put(Posicion.CENTROCAMPISTA, 5);
    //     this.maxJugadoresPosicion.put(Posicion.DELANTERO, 4);
    // }

    public Equipo(String nombre) {
        this.nombre = nombre;
        listaFutbolistas = new ArrayList<>();
        this.maxJugadoresPosicion.put(Posicion.PORTERO, 2);
        this.maxJugadoresPosicion.put(Posicion.DEFENSA, 5);
        this.maxJugadoresPosicion.put(Posicion.CENTROCAMPISTA, 5);
        this.maxJugadoresPosicion.put(Posicion.DELANTERO, 4);
    }
    
    public void agregarFutbolista(Futbolista jugador) throws posicionesMaximaException{
        if (posicionesEnLista(jugador.getPosicion())<this.maxJugadoresPosicion.get(jugador.getPosicion())) {
            listaFutbolistas.add(jugador);
        } else {
            throw new posicionesMaximaException(jugador);
        }
    }

    static class posicionesMaximaException extends Exception{
        public posicionesMaximaException(Futbolista j){
            super(j.getNombre() + " no se puede añadir ya que la lista ha llegado a su maximo de " + j.getPosicion().getNombrePos());
        }
    }
    
    private int posicionesEnLista(Posicion pos){
        int cont = 0;
        for (Futbolista futbolista : listaFutbolistas) {
            if (futbolista.getPosicion().equals(pos)) {
                cont++;
            }
        }
        return cont;
    }

    public void listarFormacionDelEquipo(){
        listaFutbolistas.sort(null);
        Iterator<Futbolista> it = listaFutbolistas.iterator();
        while (it.hasNext()) {
            System.out.println("-" + it.next());
        }   
    }
}
