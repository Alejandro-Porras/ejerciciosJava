package ud08.Ejercicios._12_juego;

public class Moneda extends Sorteo {
    @Override
    public void lanzar() {
        int resultado = (int) (Math.random() * 2);
        if (resultado == 0) {
            System.out.println("Cara");
        } else {
            System.out.println("Cruz");
        }
    }
}
