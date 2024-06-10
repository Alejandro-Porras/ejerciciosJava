package ud08.Ejercicios._15_mascotas;

public class Gato extends Mascota {
    protected String color;
    protected boolean peloLargo;

    public Gato(String nombre, int edad, String estado, String fechaNacimiento, String color, boolean peloLargo) {
        super(nombre, edad, estado, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    @Override
    public void muestra() {
        System.out.println("Gato: " + nombre);
    }

    @Override
    public void cumpleaños() {
        edad++;
    }

    @Override
    public void morir() {
        estado = "fallecido";
    }

    @Override
    public void habla() {
        System.out.println("Sí");
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Color: " + color +
               ", Pelo largo: " + (peloLargo ? "Sí" : "No");
    }
}
