package ud08.Ejercicios._09_supermercado;

import java.util.ArrayList;

//import java.util.ArrayList;

public class TestSupermercado {
    public static void main(String[] args) {
        Detergente detergente = new Detergente("MarcaX", 5.0);
        System.out.println(detergente);
        Cereales cereales1 = new Cereales("CerealesABC", 3.0, "Trigo");
        Cereales cereales2 = new Cereales("Cereales123", 2.5, "Maíz");
        Vino vino = new Vino("VinoTinto", "Tinto", 14.5, 8.0);

        ArrayList<EsAlimento> productosAlimenticios = new ArrayList<>();
        productosAlimenticios.add(cereales1);
        productosAlimenticios.add(cereales2);
        productosAlimenticios.add(vino);

        int sumaCalorias = 0;
        for (EsAlimento producto : productosAlimenticios) {
            sumaCalorias += producto.getCalorias();
        }

        System.out.println("Suma total de calorías de los productos alimenticios: " + sumaCalorias);
    }
}
