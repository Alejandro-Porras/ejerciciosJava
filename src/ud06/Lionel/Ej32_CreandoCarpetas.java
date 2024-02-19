package ud06.Lionel;

import java.io.File;
import java.io.IOException;

public class Ej32_CreandoCarpetas {
    public static void main(String[] args) {
        String ruta = "./src/ud06/Lionel";
        File misCosas = new File(ruta + "/DOCS/Mis Cosas");
        misCosas.mkdir();

        File alfabeto = new File(ruta + "/DOCS/Alfabeto");
        alfabeto.mkdir();

        File FOTOS = new File(ruta + "/DOCS/FOTOS");
        File fMove = new File(misCosas.getPath() + "/FOTOS");
        FOTOS.renameTo(fMove);

        File LECTURAS = new File(ruta + "/DOCS/LECTURAS");
        File lMove = new File(misCosas.getPath() + "/LECTURAS");
        LECTURAS.renameTo(lMove);

        char caracter = 'A';
        for (int i = 0; i <= 25; i++) {
            File aux = new File(alfabeto.getPath() + "/" + caracter);
            try {
                aux.createNewFile();
                caracter++;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
