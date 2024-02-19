package ud06.Lionel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Ej30_MostrarInformacionFicherosV2 {
    private static void muestraInfoRuta(File ruta, boolean inf) throws FileNotFoundException{
        if (ruta.exists()) {
            if (ruta.isFile()) {
                System.out.println("[A]" + ruta.getName());
            }else{
                String[] lista = ruta.list();
                Arrays.sort(lista);
                for (int i = 0; i < lista.length; i++) {
                    File aux = new File(ruta.getPath() + "/" + lista[i]);
                    Date date = new Date(aux.lastModified());
                    if (inf) {
                        System.out.println(aux.isFile()?
                        "[A]"+lista[i]+ "\t" + aux.length() + " Bytes \tFecha -> " + date:
                        "*"+lista[i] + "\t" + aux.length() + " Bytes \tFecha -> " + date);
                    }else{
                        System.out.println(aux.isFile()?"[A]"+lista[i]:"*"+lista[i]);
                    }
                }
            }
        }else{
            throw new FileNotFoundException("Ruta no encontrada.");
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String rutaIntro = "";
        boolean info;
        do {
            System.out.println("Introduzca la ruta: ");
            rutaIntro = entrada.nextLine();

            System.out.println("Quiere añadir mas informacion?");
            char option = entrada.nextLine().toLowerCase().charAt(0);
            info = (option=='s' || option=='y');

            if (!rutaIntro.isEmpty()) {
                File f = new File(rutaIntro);
                try {
                    muestraInfoRuta(f, info);
                } catch (FileNotFoundException e) {
                    System.out.println("Error -> " + e.getMessage());
                }
            }
        } while (!rutaIntro.isEmpty());
        entrada.close();
        System.out.println("ADIOSSSSS");
    }
}
