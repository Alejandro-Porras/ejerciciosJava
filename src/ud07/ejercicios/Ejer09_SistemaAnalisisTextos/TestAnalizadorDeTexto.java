package ud07.ejercicios.Ejer09_SistemaAnalisisTextos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestAnalizadorDeTexto {

    public static void main(String[] args) {
        String texto = "Mami, ¿qué tú hace'?, ey (qué tú hace') " + 
                        "Si la disco está llena y to' el mundo en un trance (to' el mundo en un trance), ey " + 
                        "Dame otro cantito, baby, no te pase' Ella cubre toa' las base', eh " + 
                        "Tiene de la ciudad, también tiene del case " +
                        "Si fueras profesora, no te falto a clase' (Rauw)";

        AnalizadoDeTexto test = new AnalizadoDeTexto(texto);

        test.contarPalabras();

        ArrayList<String> mas = test.palabrasMasFrecuentes(5);

        System.out.println("--------------MAS--------------");
        for (String string : mas) {
            System.out.println(string);
        }

        ArrayList<String> menos = test.palabrasMenosFrecuentes(5);

        System.out.println("--------------MENOS--------------");
        for (String string : menos) {
            System.out.println(string);
        }

        HashMap<Integer,ArrayList<String>> palabras = test.palabrasPorLongitud();

        for (Map.Entry<Integer, ArrayList<String>> entry : palabras.entrySet()) {
        Integer longitud = entry.getKey();
        ArrayList<String> palabra = entry.getValue();
        System.out.println("Longitud " + longitud + ": " + palabra);
        }

        
    }
}