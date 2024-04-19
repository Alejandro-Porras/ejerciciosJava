package ud07.actividades;

import java.util.HashMap;

public class Actividad05 {
    public static void main(String[] args) {
        HashMap<String,Double> divisas = new HashMap<>();

        divisas.put("Dolar Americano", 0.81);
        divisas.put("Franco Suizo", 0.85);
        divisas.put("Libra Esterlina", 1.14);
        divisas.put("Corona Danesa", 0.13);
        divisas.put("Peso Mexicano", 0.04);
        divisas.put("Dólar Singapur", 0.62);
        divisas.put("Real Brasil", 0.24);

        System.out.println("Valor de libra estarlina");
        System.out.println(divisas.get("Libra Esterlina"));

        System.out.println("\nTodas las divisas");
        for (HashMap.Entry<String,Double> elemento : divisas.entrySet()) {
            System.out.println(String.format("%-20s %1.2f", elemento.getKey(), elemento.getValue()));
        }

        System.out.println("\nNumero de divisas del Map: ");
        System.out.println(divisas.size());

        System.out.println("\nEliminar la divisa Real Brasil y mostrar los datos del Map");
        divisas.remove("Real Brasil");
        for (HashMap.Entry<String, Double> elemento : divisas.entrySet()) {
            System.out.println(String.format("%-20s %1.2f", elemento.getKey(), elemento.getValue()));
        }

        System.out.println("\nMostrar si existe la divisa Peso Mexicano.");
        System.out.println(divisas.containsKey("Peso Mexicano"));

        System.out.println("\nMostrar si existe la divisa Euro.");
        System.out.println(divisas.containsKey("Euro"));

        System.out.println("\nMostrar si existe el valor al cambio 0.85 €.");
        System.out.println(divisas.containsValue(0.85));

        System.out.println("\nMostrar si existe el valor al cambio 0.33 €.");
        System.out.println(divisas.containsValue(0.33));

        System.out.println("\nIndicar si el Map divisas está vacío.");
        System.out.println(divisas.isEmpty());

        System.out.println("\nBorra todos los componentes del Map divisas.");
        divisas.clear();

        System.out.println("\nVolver a indicar si el Map divisas está vacío.");
        System.out.println(divisas.isEmpty());
    }
}
