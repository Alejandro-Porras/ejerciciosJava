package ud08.Ejercicios._15_mascotas;

public abstract class Mascota {
    protected String nombre;
    protected int edad;
    protected String estado;
    protected String fechaNacimiento;

    public Mascota(String nombre, int edad, String estado, String fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               ", Edad: " + edad +
               ", Estado: " + estado +
               ", Fecha de Nacimiento: " + fechaNacimiento;
    }

    public abstract void muestra();
    public abstract void cumpleaños();
    public abstract void morir();
    public abstract void habla();
}
