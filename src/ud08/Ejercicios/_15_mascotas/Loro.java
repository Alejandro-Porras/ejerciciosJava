package ud08.Ejercicios._15_mascotas;

public class Loro extends Ave {
    protected String origen;
    protected boolean habla;

    public Loro(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela,
                String origen, boolean habla) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.origen = origen;
        this.habla = habla;
    }

    @Override
    public void muestra() {
        System.out.println("Loro: " + nombre);
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
        if (habla) {
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
               ", Origen: " + origen +
               ", Habla: " + (habla ? "Sí" : "No");
    }
}
