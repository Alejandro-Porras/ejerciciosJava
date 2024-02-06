package tests.ud06.act3;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LecturaBinario {
    public static int longitud (String archivo){
        int cont=0;
            try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(archivo)))) {
                while (true) {
                    dis.readInt();
                    dis.readUTF();
                    dis.readUTF();
                    dis.readUTF();
                    cont++;
                }
            }catch (EOFException e){
                System.out.println("\\");
            }catch (FileNotFoundException e) {
                System.out.println("Error: No encuentra el archivo");
            }catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        return cont;
    }

    public static void ordenar(Alumnos[] lista){
        // 1) Primero, recorremos el array para seleccionar las posiciones y elegir la minima.
        for (int i = 0; i < lista.length-1; i++) {
            // 2) Elegimos la posicion de i.
            int posMin=i;
            // 3) Creamos el bucle para buscar posiciones menores a la derecha.
            for (int j = i+1; j < lista.length; j++) {
                // 4) En este if buscamos cual es la posicion minima.
                if (lista[j].getNia()<lista[posMin].getNia()) {
                    posMin = j;
                }
            }
            // 5) creamos un auxiliar.
            Alumnos aux = lista[i];
            // 6) Le colocamos a i la posicion minima.
            lista[i]=lista[posMin];
            // 7) Y a la posicion minima le colocamos la actual.
            lista[posMin]=aux;
        }
    }

    public static void mostrar(Alumnos[] lista){
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }

    public static void main(String[] args) {
        String nombreArchivo = "alumnosDaw.dat";
        Alumnos[] listaAlumnos = new Alumnos[longitud(nombreArchivo)];
        int cont=0;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nombreArchivo)))) {
            while (true) {
                int nia;
                String nombre;
                String apellidos;
                String curso;

                nia = dis.readInt();
                nombre = dis.readUTF();
                apellidos = dis.readUTF();
                curso = dis.readUTF();
                listaAlumnos[cont]= new Alumnos(nia, nombre, apellidos, curso);
                cont++;
            }
        }catch (EOFException e){
            System.out.println("\\");
        }catch (FileNotFoundException e) {
            System.out.println("Error: No encuentra el archivo");
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Mostramos nadamas añadir");
        mostrar(listaAlumnos);

        System.out.println("\n\nOrdenamos el array");
        ordenar(listaAlumnos);

        System.out.println("Mostramos el array ya ordenado :)");
        mostrar(listaAlumnos);
    }
}
