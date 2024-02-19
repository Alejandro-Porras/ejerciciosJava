package ud06.Lionel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej29_MostrarInformacionFicheros {
    private static void muestraInfoRuta(File ruta) throws FileNotFoundException{
        if (ruta.exists()) {
            if (ruta.isFile()) {
                System.out.println("[A]" + ruta.getName());
            }else{
                String[] lista = ruta.list();
                for (int i = 0; i < lista.length; i++) {
                    File aux = new File(ruta.getPath() + "/" + lista[i]);

                    System.out.println(aux.isFile()?"[A]"+lista[i]:"*"+lista[i]);
                }
            }
        }else{
            throw new FileNotFoundException("Ruta no encontrada.");
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String rutaIntro = "";
        do {
            System.out.println("Introduzca la ruta: ");
            rutaIntro = entrada.nextLine();

            if (!rutaIntro.isEmpty()) {
                File f = new File(rutaIntro);
                try {
                    muestraInfoRuta(f);
                } catch (FileNotFoundException e) {
                    System.out.println("Error -> " + e.getMessage());
                }
            }
        } while (!rutaIntro.isEmpty());
        entrada.close();
        System.out.println("ADIOSSSSS");
    }
}
