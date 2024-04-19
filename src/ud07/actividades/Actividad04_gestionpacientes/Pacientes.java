package ud07.actividades.Actividad04_gestionpacientes;

public class Pacientes implements Comparable<Pacientes>{
    private String nombre;
    private String apellidos;
    private int edad;

    public Pacientes(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\nNombre: " + this.nombre + " | Apellidos: " + this.apellidos +
                " | Edad: " + this.edad + "\n";
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Pacientes o) {
        if (this.getApellidos().compareTo(o.getApellidos()) == 0) {
            return this.getNombre().compareTo(o.getNombre());
        } else {
            return this.getApellidos().compareTo(o.getApellidos());
        }   
    }
    
}
