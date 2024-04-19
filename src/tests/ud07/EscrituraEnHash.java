package tests.ud07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class EscrituraEnHash {
    public static void main(String[] args) {
        HashSet <Integer> numeros = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("./src/tests/files/numeros.txt"))) {
            String lectura;
            while ((lectura = br.readLine())!=null) {
                lectura=lectura.trim();
                numeros.add(Integer.parseInt(lectura));
            }
        } catch (IOException e) {
            System.out.println("ERROR ->" + e.getMessage());
        }
        

        for (Integer contenido : numeros) {
            System.out.println(contenido);
        }
    }
}
