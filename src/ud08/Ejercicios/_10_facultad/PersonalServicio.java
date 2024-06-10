package ud08.Ejercicios._10_facultad;

public class PersonalServicio extends Empleado {
    protected String seccion;

    public PersonalServicio(String nombre, String apellidos, 
    String numeroIdentificacion, String estadoCivil, String seccion) {
        super(nombre, apellidos, numeroIdentificacion, estadoCivil, 0, 0);
        this.seccion = seccion;
    }

    public void trasladarSeccion(String nuevaSeccion) {
        this.seccion = nuevaSeccion;
    }

    @Override
    public String toString() {
        return super.toString() + 
        "\nSección: " + seccion;
    }
}