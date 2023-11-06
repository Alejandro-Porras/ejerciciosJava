package ud01;

public class Ejercicio12 {
    public static void main(String[] args) {
        int d1;
        int d2;

        d1 = (int)(Math.random()*6+1);
        d2 = (int)(Math.random()*6+1);

        System.out.println("Dado 1 : " + d1);
        System.out.println("Dado 2 : " + d2);
        System.out.println("Puntuacion total: " + (d1+d2));
    }
}
