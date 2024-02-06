package tests.test_v2.test;

import java.io.File;
import java.io.FileWriter;

public class NoBebereMonster2 {
    public static void main(String[] args) {

        //Un texto cualquiera guardado en una variable
        String fin = "bucle finito";

        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("noBeberéMasMonster.txt");

            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);


            //Escribimos en el archivo con el metodo write 
            for(int i = 1;i>0;i++) {
                escribir.write(i + ") No beberé mas monster");
                escribir.write("\r\n"); 
                System.out.println(i + ") No beberé mas monster");

            }

            escribir.write(fin);

            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}

