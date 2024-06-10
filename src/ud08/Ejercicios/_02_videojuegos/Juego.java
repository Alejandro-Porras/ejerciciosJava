package ud08.Ejercicios._02_videojuegos;

public class Juego {
    protected String titulo;
    protected String fabricante;
    protected int anyo;
    
    public Juego(String titulo, String fabricante, int anyo) {
        this.titulo = titulo;
        this.fabricante = fabricante;
        this.anyo = anyo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getAnyo() {
        return anyo;
    }

    @Override
    public String toString() {
        return "\nTitulo: " + this.titulo +
                "\nFabricante: " + this.fabricante +
                "\nAnyo: " + this.anyo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass()!=o.getClass()) {
            return false;
        }
        Juego game = (Juego)o;
        return this.titulo.equals(game.titulo) &&
                this.fabricante.equals(game.fabricante) &&
                this.anyo == game.anyo;
    }
    
    public int compareTo(Object o){
        Juego game = (Juego)o;
        // Aqui lo que hacemos es colocar el valor del compareTo a devolver
        int devolver = this.titulo.compareTo(game.titulo);
        // Revisamos si es cero, ya que si es serian iguales
        if (devolver == 0) {
            devolver = this.fabricante.compareTo(game.fabricante);
            // Si el anterior TAMBIEN es igual, dara 0, por lo tanto entrará
            if (devolver == 0) {
                devolver = this.anyo - game.anyo;
            }
        }
        
        return devolver;
    }

    
}
