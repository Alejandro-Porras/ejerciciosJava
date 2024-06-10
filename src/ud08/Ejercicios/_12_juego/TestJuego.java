package ud08.Ejercicios._12_juego;

public class TestJuego {
    public static void main(String[] args) {
        Dado dado = new Dado();
        Moneda moneda = new Moneda();

        System.out.println("Lanzamiento del dado:");
        dado.lanzar();

        System.out.println("Lanzamiento de la moneda:");
        moneda.lanzar();
    }
}
