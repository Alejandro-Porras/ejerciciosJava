package programaMe.fakeProgramame;

import java.util.HashMap;

public class LetrasCapullas {

    public static void contarPalabras(String texto, HashMap <Character,Integer> letras){
        String[] palabrasContar = texto.toUpperCase().split(" ");
        for (int i = 0; i < palabrasContar.length; i++) {
            for (int j = 0; j < palabrasContar[i].length(); j++) {
                if (!letras.containsKey(palabrasContar[i].charAt(j))) {
                    letras.put(palabrasContar[i].charAt(j), 1);
                } else {
                    int valorActual = letras.get(palabrasContar[i].charAt(j));
                    letras.put(palabrasContar[i].charAt(j),valorActual+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        //HashMap <Character,Integer> letrasPalabraIni = new HashMap<>();
        //HashMap <Character,Integer> letrasPalabraFin = new HashMap<>();
    }
}
