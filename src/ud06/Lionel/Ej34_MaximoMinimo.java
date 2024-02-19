package ud06.Lionel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ej34_MaximoMinimo {
    public static int longitudFichero(String ruta){
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((br.readLine())!=null) {
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -> " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR -> " + e.getMessage());
        }
        return contador;
    }
    public static void main(String[] args) {
        int[] listaNumeros = new int[longitudFichero("./src/ud06/Lionel/DOCS/numeros.txt")];
        try (BufferedReader br = new BufferedReader(new FileReader("./src/ud06/Lionel/DOCS/numeros.txt"))) {
            String numero = "";
            int cont = 0;
            while ((numero=br.readLine())!=null) {
                listaNumeros[cont]=Integer.parseInt(numero);
                cont++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -> " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR -> " + e.getMessage());
        }
        Arrays.sort(listaNumeros);
        System.out.println("Minimo -> " + listaNumeros[0]);
        System.out.println("Maximo -> " + listaNumeros[listaNumeros.length-1]);
    }
}
