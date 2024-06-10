package ud08.Ejercicios._12_juego;

public class Dado extends Sorteo {
    @Override
    public void lanzar() {
        int resultado = (int) (Math.random() * 6) + 1;
        System.out.println("Resultado del dado: " + resultado);
    }
}
