package ud08.Ejercicios._13_alimento;

public class Huevo {
    private String tamaño;

    public Huevo(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Huevo de tamaño " + tamaño;
    }
}
