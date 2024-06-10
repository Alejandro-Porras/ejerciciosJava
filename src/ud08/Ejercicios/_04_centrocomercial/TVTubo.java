package ud08.Ejercicios._04_centrocomercial;

public class TVTubo extends Televisor{
    private int lineas;

    public TVTubo(String marca, String modelo, double precio, double pulgadas, int lineas) {
        super(marca, modelo, precio, pulgadas);
        this.lineas = lineas;
    }

    @Override
    public String resulucion() {
        return lineas + " lineas";
    }
}
