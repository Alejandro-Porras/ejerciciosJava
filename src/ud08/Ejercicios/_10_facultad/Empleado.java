package ud08.Ejercicios._10_facultad;

public class Empleado extends Persona {
    protected int anoIncorporacion;
    protected int numeroDespacho;

    public Empleado(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil, 
                    int anoIncorporacion, int numeroDespacho) {
        super(nombre, apellidos, numeroIdentificacion, estadoCivil);
        this.anoIncorporacion = anoIncorporacion;
        this.numeroDespacho = numeroDespacho;
    }

    public void reasignarDespacho(int nuevoDespacho) {
        this.numeroDespacho = nuevoDespacho;
    }

    @Override
    public String toString() {
        return super.toString() + 
        "\nAño de Incorporación: " + anoIncorporacion + 
        "\nNúmero de Despacho: " + numeroDespacho;
    }
}
