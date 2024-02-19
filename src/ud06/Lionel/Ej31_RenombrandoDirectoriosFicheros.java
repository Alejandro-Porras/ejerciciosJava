package ud06.Lionel;

import java.io.File;

public class Ej31_RenombrandoDirectoriosFicheros {
    public static void main(String[] args) {
        String ruta = "./src/ud06/Lionel";
        File documentos = new File(ruta+"/Documentos");
        File docs = new File(ruta+"/DOCS");
        documentos.renameTo(docs);

        File Fotografias = new File(docs.getPath()+"/Fotografias");
        File FOTOS = new File(docs.getPath()+"/FOTOS");
        Fotografias.renameTo(FOTOS);

        File Libros = new File(docs.getPath()+"/Libros");
        File LECTURAS = new File(docs.getPath()+"/LECTURAS");
        Libros.renameTo(LECTURAS);

        File[] listaFotos = FOTOS.listFiles();
        for (int i = 0; i < listaFotos.length; i++) {
            String a = listaFotos[i].toString();
            File aux = new File(a.replace(a.substring(a.lastIndexOf('.')), ""));
            listaFotos[i].renameTo(aux);
        }

        File[] listaLecturas = LECTURAS.listFiles();
        for (int i = 0; i < listaLecturas.length; i++) {
            String a = listaLecturas[i].toString();
            File aux = new File(a.replace(a.substring(a.lastIndexOf('.')), ""));
            listaLecturas[i].renameTo(aux);
        }
    }
}
