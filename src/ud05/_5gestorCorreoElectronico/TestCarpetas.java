package ud05._5gestorCorreoElectronico;

import ud05._5gestorCorreoElectronico.Carpeta.ElementoDuplicadoException;
import ud05._5gestorCorreoElectronico.Carpeta.ElementoNoEncontradoException;
import ud05._5gestorCorreoElectronico.Carpeta.ListaLlenaException;

public class TestCarpetas {
    public static void main(String[] args) {
        Carpeta c1 = new Carpeta("Mensajes recibidos");
        Carpeta c2 = new Carpeta("Mensajes eliminados");

        Mensaje m1 = new Mensaje("paco", "manulo", "caca", "cacota");
        Mensaje m2 = new Mensaje("omar", "arnau", "somali", "voltereta");

        System.out.println("Mostramos C1 sin añadir nada");
        System.out.println(c1);
        try {
            c1.añadir(m1);
            c1.añadir(m2);
        } catch (ListaLlenaException | ElementoDuplicadoException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Mostramos carpetas antes de mover mensajes.");
        System.out.println(c1);
        System.out.println(c2);

        System.out.println("Movemos mensaje");
        try {
            Carpeta.moverMensaje(c1, c2, 1);
        } catch (ElementoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Final");
        System.out.println(c1);
        System.out.println(c2);
        
    }
}
