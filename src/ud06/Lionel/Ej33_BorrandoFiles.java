package ud06.Lionel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej33_BorrandoFiles {
    public static boolean menuBorrar(File f) throws FileNotFoundException{
        @SuppressWarnings("resource")
        Scanner entrada = new Scanner(System.in);
        boolean realizado = false;
        char respu=0;
            if (f.exists()) {
                do {
                    System.out.println("Estas seguro que quieres eliminar? si/no/listar");
                    respu = entrada.nextLine().toLowerCase().charAt(0);
                    if (respu == 's' || respu == 'y') {
                        borrarTodo(f);
                        f.delete();
                        realizado = true;
                    }else if (respu == 'n') {
                        System.out.println("chau conchetumare");
                    } else if (respu == 'l') {
                        File[] listaFile = f.listFiles();
                        for (int i = 0; i < listaFile.length; i++) {
                            System.out.println(listaFile[i].isFile()?
                            "[A]"+listaFile[i].getName():
                            "[*]"+listaFile[i].getName());
                        }
                    }
                } while (respu!=0 || (respu == 's' || respu == 'y') || respu == 'n');
            } else {
                throw new FileNotFoundException("Ruta no encontrada.");
            }
        return realizado;
    }

    public static boolean borrarTodo(File f){
        boolean realizado = false;
            File[] lista = f.listFiles();
            for (int i = 0; i < lista.length; i++) {
                if (lista[i].isFile()) {
                    lista[i].delete();
                }else{
                    borrarTodo(lista[i]);
                    lista[i].delete();
                }
            }
        return realizado;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String respuesta = "";
        do {
            System.out.println("Coloque la ruta: ");
            respuesta = entrada.nextLine();

            File f = new File(respuesta);
            try {
                menuBorrar(f);
            } catch (FileNotFoundException e) {
                System.out.println("Error -> " + e.getMessage());
            }
            
        } while (!respuesta.isEmpty());
        entrada.close();
    }
}
