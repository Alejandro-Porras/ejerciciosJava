package ud08.Ejercicios._03_fnmt;

import java.time.LocalDate;

public class TestDinero {
    public static void main(String[] args) {
        Moneda m = new Moneda(2, LocalDate.now(), 1, 1);
        Billete b = new Billete(2, LocalDate.of(2005, 4, 11), 2, 2);

        System.out.println(m.mostrarDatos());

        System.out.println(b.mostrarDatos());
    }
}
