package tests.ud06.act4;

public class Alumnos {
    private int nia;
    private String nombre;
    private String apellidos;
    private String curso;   

    public Alumnos(int nia, String nombre, String apellidos, String curso){
        this.nia=nia;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.curso=curso;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "\nNia: " + this.nia + 
                "\nNombre: " + this.nombre +
                "\nApellidos: " + this.apellidos +
                "\nCurso: " + this.curso;
    }
    
}
