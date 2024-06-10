package ud08.Ejercicios._10_facultad;

public class Estudiante extends Persona {
    protected String curso;

    public Estudiante(String nombre, String apellidos, String numeroIdentificacion, 
                    String estadoCivil, String curso) {
        super(nombre, apellidos, numeroIdentificacion, estadoCivil);
        this.curso = curso;
    }

    public void matricularCurso(String nuevoCurso) {
        this.curso = nuevoCurso;
    }

    @Override
    public String toString() {
        return super.toString() + 
        "\nCurso: " + curso;
    }
}
