package ud08.Ejercicios._15_mascotas;

public class Perro extends Mascota {
    protected String raza;
    protected boolean tienePulgas;

    public Perro(String nombre, int edad, String estado, String fechaNacimiento, String raza, boolean tienePulgas) {
        super(nombre, edad, estado, fechaNacimiento);
        this.raza = raza;
        this.tienePulgas = tienePulgas;
    }

    @Override
    public void muestra() {
        System.out.println("Perro: " + nombre);
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
               ", Raza: " + raza +
               ", Tiene pulgas: " + (tienePulgas ? "Sí" : "No");
    }
}
