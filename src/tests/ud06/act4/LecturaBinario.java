package tests.ud06.act4;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LecturaBinario {

    public static int longitud (String archivo, String filtro){
        int cont=0;
            try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(archivo)))) {
                while (true) {
                    dis.readInt();
                    dis.readUTF();
                    dis.readUTF();
                    if (dis.readUTF().indexOf(filtro) != -1) {  
                        cont++;
                    }
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

    public static void InsertarOrdenado(Alumnos[] lista, Alumnos alu){
        int posi = 0;
        boolean encontrado = false;

        if (lista[0] == null) {
            lista[0] = alu;
        }else{
            for (int i = 0; i < lista.length && lista[i] != null && !encontrado; i++) {
                if (alu.getNia() < lista[i].getNia()) {
                    posi = i;
                    encontrado = true;
                }
            }
            if (encontrado) {
                for (int j = lista.length-1; j > posi; j--) {
                    lista[j] = lista[j-1];
                }
                lista[posi]=alu;
            }else{
                boolean found= false;
                int ultima= 0;

                for (int i = 0; i < lista.length && !found; i++) {
                    if (lista[i]==null) {
                        found = true;
                        ultima = i;
                    }
                }
                lista[ultima] = alu;
            }
        }
    }

    public static void mostrar(Alumnos[] lista){
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nombreArchivo = "alumnosDaw.dat";

        System.out.println("Introduzca preferencia");
        String prefe = entrada.nextLine();

        Alumnos[] listaAlumnos = new Alumnos[longitud(nombreArchivo, prefe)];

        if (longitud(nombreArchivo, prefe)>0) {
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
                        if (curso.indexOf(prefe) != -1) {
                            InsertarOrdenado(listaAlumnos, new Alumnos(nia, nombre, apellidos, curso));
                        }
                    }
                }catch (EOFException e){
                    System.out.println("\\");
                }catch (FileNotFoundException e) {
                    System.out.println("Error: No encuentra el archivo");
                }catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            mostrar(listaAlumnos);
        }else{
            System.out.println("Filtro no valido");
        }
        entrada.close();
    } 
}
