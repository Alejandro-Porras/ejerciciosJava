package ud08.Ejercicios._15_mascotas;

public class Canario extends Ave {
    protected String color;
    protected boolean canta;

    public Canario(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela,
                   String color, boolean canta) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.color = color;
        this.canta = canta;
    }

    @Override
    public void muestra() {
        System.out.println("Canario: " + nombre);
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
        if (canta) {
            System.out.println("Sí");
        } else {
            System.out.println("No");
        }
    }

    @Override
    public void volar() {
        if (vuela) {
            System.out.println("Sí");
        } else {
            System.out.println("No");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Canta: " + (canta ? "Sí" : "No");
    }
}
