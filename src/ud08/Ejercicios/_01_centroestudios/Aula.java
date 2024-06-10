package ud08.Ejercicios._01_centroestudios;

public class Aula {
    // contador, atributo de clase
    private static int contador = 0;
    // Generar codigo por contador
    protected int codigo;
    protected double longitud;
    protected double anchura;

    public Aula(double longitud, double anchura){
        this.codigo = ++contador;
        this.longitud = longitud;
        this.anchura = anchura;
    }

    private double superficie(){
        return this.longitud*this.anchura;
    }

    public int capacidad(){
        return (int)(this.superficie()/1.4);
    }

    @Override
    public String toString() {
        return "\tcódigo: " + this.codigo +
                "\tsuperficie: " + this.superficie() +
                "\tcapacidad: " + this.capacidad();
    }
}
