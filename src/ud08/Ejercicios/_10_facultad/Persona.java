package ud08.Ejercicios._10_facultad;

public class Persona {
    protected String nombre;
    protected String apellidos;
    protected String numeroIdentificacion;
    protected String estadoCivil;

    public Persona(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.estadoCivil = estadoCivil;
    }

    public void cambiarEstadoCivil(String nuevoEstadoCivil) {
        this.estadoCivil = nuevoEstadoCivil;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + 
        "\nApellidos: " + apellidos + 
        "\nNúmero de Identificación: " + numeroIdentificacion + 
        "\nEstado Civil: " + estadoCivil;
    }
}
