package ud07.ejercicios.Ejer04_ListaEspera;

public class Paciente {
    private String nombre;
    private int gravedad;

    public Paciente(String nombre, int gravedad) {
        this.nombre = nombre;
        this.gravedad = (int)(Math.random()*5+1);
    }

    public String getNombre() {
        return nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " Gravedad: " + getGravedad();
    }
}
