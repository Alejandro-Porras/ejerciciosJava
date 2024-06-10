package ud08.Ejercicios._10_facultad;

public class Profesor extends Empleado {
    protected String departamento;

    public Profesor(String nombre, String apellidos, String numeroIdentificacion, 
                    String estadoCivil, String departamento) {
        super(nombre, apellidos, numeroIdentificacion, estadoCivil, 0, 0);
        this.departamento = departamento;
    }

    public void cambiarDepartamento(String nuevoDepartamento) {
        this.departamento = nuevoDepartamento;
    }

    @Override
    public String toString() {
        return super.toString() + 
        "\nDepartamento: " + departamento;
    }
}
