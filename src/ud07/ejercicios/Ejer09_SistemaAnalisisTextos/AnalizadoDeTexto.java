package ud07.ejercicios.Ejer09_SistemaAnalisisTextos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AnalizadoDeTexto {
    private String texto;
    private HashMap<String, Integer> palabras;

    public AnalizadoDeTexto(String texto) {
        this.texto = texto;
        this.palabras = new HashMap<>();
    }

    public void contarPalabras(){
        String textoMinuscula = texto.toLowerCase();
        String[] textoPalabras = textoMinuscula.replace(";", "")
                                                .replace(":", "").split(" ");

        for (int i = 0; i < textoPalabras.length; i++) {
            if (palabras.containsKey(textoPalabras[i])) {
                palabras.put(textoPalabras[i], palabras.get(textoPalabras[i])+1);
            }else{
                palabras.put(textoPalabras[i], 1);
            }
        }

        for(Map.Entry<String, Integer> entry : palabras.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\n\nkey: " + key + "\nvalue: " + value);
        }
    }

    public ArrayList<String> palabrasMasFrecuentes(int n) {
        ArrayList<String> listaPalabrasMas = new ArrayList<>();
        if (palabras == null || palabras.isEmpty()) {
            return listaPalabrasMas;
        }
        
        for (int i = 0; i < n; i++) {
            String palabraMayor = "";
            int numActualMayor = -1;
            for (Map.Entry<String, Integer> entry : palabras.entrySet()) {
                String palabra = entry.getKey();
                int frecuencia = entry.getValue();
                if (!listaPalabrasMas.contains(palabra) && frecuencia > numActualMayor) {
                    palabraMayor = palabra;
                    numActualMayor = frecuencia;
                }
            }
            if (!palabraMayor.isEmpty()) {
                listaPalabrasMas.add(palabraMayor);
            } else {
                break;
            }
        }
        return listaPalabrasMas;
    }

    public ArrayList<String> palabrasMenosFrecuentes(int n) {
        ArrayList<String> listaPalabrasMenos = new ArrayList<>();
        if (palabras == null || palabras.isEmpty()) {
            return listaPalabrasMenos; // Retorna una lista vacía si no hay palabras
        }
        
        for (int i = 0; i < n; i++) {
            String palabraMenor = "";
            int numActualMenor = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : palabras.entrySet()) {
                String palabra = entry.getKey();
                int frecuencia = entry.getValue();
                if (!listaPalabrasMenos.contains(palabra) && frecuencia < numActualMenor) {
                    palabraMenor = palabra;
                    numActualMenor = frecuencia;
                }
            }
            if (!palabraMenor.isEmpty()) {
                listaPalabrasMenos.add(palabraMenor);
            } else {
                break;
            }
        }
        return listaPalabrasMenos;
    }    
    
    public HashMap<Integer,ArrayList<String>> palabrasPorLongitud(){
        HashMap<Integer,ArrayList<String>> palabrasLongitud = new HashMap<>();
        
        HashSet<String> listaAux = new HashSet<>();

        String textoMinuscula = texto.toLowerCase();
        String[] textoPalabras = textoMinuscula.replace(";", "")
                                                .replace(":", "").split(" ");

        for (int i = 0; i < textoPalabras.length; i++) {
            listaAux.add(textoPalabras[i]);
        }

        for (String palabra : listaAux) {
            if (!palabrasLongitud.containsKey(palabra.length())) {
                palabrasLongitud.put(palabra.length(), new ArrayList<String>());
                palabrasLongitud.get(palabra.length()).add(palabra);
            } else{
                palabrasLongitud.get(palabra.length()).add(palabra);
            }
        }

        return palabrasLongitud;
    }
}
