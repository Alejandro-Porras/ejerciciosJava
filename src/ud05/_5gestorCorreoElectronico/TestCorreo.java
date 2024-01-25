package ud05._5gestorCorreoElectronico;

import java.util.Scanner;

public class TestCorreo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int numMensajes=0;
        String emisor;
        String destinatario;
        String asunto;
        String texto;

        System.out.println("¿Cuantos mensajes quieres añadir?");
        numMensajes=entrada.nextInt();

        Mensaje[] lista= new Mensaje[numMensajes];

        entrada.nextLine();
        for (int i = 0; i < numMensajes; i++) {
            System.out.println("Introduzca el nombre del emisor: ");
            emisor=entrada.nextLine();

            System.out.println("Introduzca el nombre del destinatario: ");
            destinatario=entrada.nextLine();

            System.out.println("Introduzca el asunto: ");
            asunto=entrada.nextLine();

            System.out.println("Introduzca el texto: ");
            texto=entrada.nextLine();

            lista[i]= new Mensaje(emisor, destinatario, asunto, texto);
            System.out.println(lista[i]);
        }

        System.out.println(Mensaje.validarEMail("tuCorreo@gmail.com"));
        System.out.println(Mensaje.validarEMail("tuCorreogmail.com"));
        System.out.println(Mensaje.validarEMail("tuCorreo@gmail"));
        System.out.println(Mensaje.validarEMail("tuCorreo.com@gmail"));

        entrada.close();
    }
}
