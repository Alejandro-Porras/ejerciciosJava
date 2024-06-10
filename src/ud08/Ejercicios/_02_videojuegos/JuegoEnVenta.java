package ud08.Ejercicios._02_videojuegos;

public class JuegoEnVenta extends Juego {
    private int precio;
    private int numCopias;
    // private int numDiasAlquilados;

    public JuegoEnVenta(String titulo, String fabricante, int anyo, int precio, int numCopias, int numDiasAlquilados) {
        super(titulo, fabricante, anyo);
        this.precio = precio;
        this.numCopias = numCopias;
        // this.numDiasAlquilados = numDiasAlquilados;
    }

    public void vender() throws NoQuedanCopiasException{
        if (this.numCopias > 0) {
            this.numCopias--;
        } else {
            throw new NoQuedanCopiasException(this.titulo);
        }
    }

    @Override
    public String toString() {
        return "Juego en venta: \n" + 
                super.toString() + 
                "\nPrecio: " + this.precio +
                "\nNumero de copias: " + this.numCopias;
    }

    static class NoQuedanCopiasException extends Exception{
        public NoQuedanCopiasException(String titulo){
            super("No quedan copias disponibles de " + titulo);
        }
    }
}
