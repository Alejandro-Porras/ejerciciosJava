package ud08.Ejercicios._15_mascotas;

public abstract class Ave extends Mascota {
    protected String pico;
    protected boolean vuela;

    public Ave(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela) {
        super(nombre, edad, estado, fechaNacimiento);
        this.pico = pico;
        this.vuela = vuela;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Pico: " + pico +
               ", Vuela: " + (vuela ? "Sí" : "No");
    }

    public abstract void volar();
}
