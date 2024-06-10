package ud08.Ejercicios._01_centroestudios;

public class AulaInformatica extends Aula {
    private int numOrdenadores;

    public AulaInformatica(double longitud, double anchura, int ordenadores) {
        super(longitud, anchura);
        this.numOrdenadores = ordenadores;
    }

    @Override
    public int capacidad() {
        return numOrdenadores * 2;
    }
    
    @Override
    public String toString() {
        return "Aula de Informatica\n" + 
                super.toString() +
                "\tNumero de ordenadores: " + this.numOrdenadores;
    }
}
