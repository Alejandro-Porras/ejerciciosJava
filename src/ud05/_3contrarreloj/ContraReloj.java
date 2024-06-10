package ud05._3contrarreloj;

/*
 * Here comes the text of your license
 * Each line should be prefixed with  *
 */

import java.util.Scanner;

import ud05._3contrarreloj.Corredor.IllegalArgumentException;
import ud05._3contrarreloj.ListaCorredores.ElementoDuplicadoException;
import ud05._3contrarreloj.ListaCorredores.ListaLlenaException;

/**
 *
 * @author David Martínez (wwww.martinezpenya.es|iesmre.com)
 */
public class ContraReloj {

    static ListaCorredores hanSalido = new ListaCorredores();
    static ListaCorredores hanLlegado = new ListaCorredores();
    static Scanner teclado = new Scanner(System.in);


    public static String menu() {
        String resultado = "";
        resultado += "**********************************\n";
        resultado += "*     C O N T R A R R E L O J    *\n";
        resultado += "**********************************\n";
        resultado += "* 1=> Salida                     *\n";
        resultado += "* 2=> Llegada                    *\n";
        resultado += "* 3=> Clasificación              *\n";
        resultado += "* 4=> Han Salido                 *\n";
        resultado += "* 5=> Salir                      *\n";
        resultado += "**********************************\n";
        resultado += "Elige una opcion (1-5): ";
        return resultado;
    }

    public static void menuSalida() {
        System.out.println("REGISTRO DE SALIDA:");
        System.out.print("Introduzca el nombre del corredor: ");
        String nombre = teclado.next();
        //System.out.printf("Introduzca el dorsal de %s: ", nombre);
        //int dorsal = teclado.nextInt();
        try {
            hanSalido.anyadir(new Corredor(nombre));
        } catch (ElementoDuplicadoException ex) {
            System.out.println(
                    "ERROR: Ese dorsal ya ha sido registrado en la salida");
        }
    }

    public static void menuLlegada() {
        System.out.println("REGISTRO DE LLEGADA:");
        System.out.print("Introduzca el dorsal del corredor: ");
        int dorsal = teclado.nextInt();
        System.out.printf(
                "Introduzca el tiempo de llegada para el dorsal %d en segundos: ",
                dorsal);
        double time = teclado.nextDouble();
        try {
            Corredor c = hanSalido.quitar(dorsal);
            try {
                c.setTiempo(time);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            try {
                hanLlegado.insertarOrdenado(c);
            } catch (ListaLlenaException e) {
                System.out.println(e.getMessage());
            }
        } catch (ListaCorredores.ElementoNoEncontradoException ex) {
            System.out.println(
                    "ERROR: El corredor no esta en la lista de salida");
        }
    }

    public static void main(String[] args) {
        int opcion;
        System.out.print(menu());
        while ((opcion = teclado.nextInt()) != 5) {
            switch (opcion) {
                case 1:
                    menuSalida();
                    break;
                case 2:
                    menuLlegada();
                    break;
                case 3:
                    System.out.println(hanLlegado.toString());
                    break;
                case 4:
                    System.out.println("Corredores que aun no han llegado");
                    System.out.println(hanSalido.toString());
                    break;
                default:
                    System.out.println("opcion incorrecta, intentelo de nuevo");
            }
            System.out.print(menu());
        }
        System.out.println("Ha seleccionado Salir, que pase buen dia!");
    }
}

