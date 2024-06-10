package ud08.test.punto;

import java.util.Scanner;

public class TestRectangulo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Punto 1");
        System.out.print("x1: ");
        double x1 = entrada.nextDouble();
        System.out.print("y1: ");
        double y1 = entrada.nextDouble();

        System.out.println("Punto 2");
        System.out.print("x2: ");
        double x2 = entrada.nextDouble();
        System.out.print("y2: ");
        double y2 = entrada.nextDouble();

        Punto p0 = new Punto();
        Punto p1 = new Punto(x1, y1);
        Punto p2 = new Punto(x2, y2);

        System.out.println("Rectangulo de (0,0) a p2");
        Rectangulo r02 = new Rectangulo(p0, p2);
        System.out.println(r02);

        System.out.println("Perimetro: " + r02.calcularPerimetroRectangulo());
        System.out.println("Area: " + r02.calcularAreaRectangulo());

        System.out.println("Rectangulo de p1 a p2");
        Rectangulo r12 = new Rectangulo(p1, p2);
        System.out.println(r12);

        System.out.println("Perimetro: " + r12.calcularPerimetroRectangulo());
        System.out.println("Area: " + r12.calcularAreaRectangulo());

        entrada.close();
    }
}
