package ud05._4reservasLibreria;

import java.util.Scanner;

import ud05._4reservasLibreria.ListaReservas.ElementoDuplicadoException;
import ud05._4reservasLibreria.ListaReservas.ElementoNoEncontradoException;
import ud05._4reservasLibreria.ListaReservas.ListaLlenaException;

public class GestionReservas {

    static Scanner entrada = new Scanner(System.in);

    public static void menu(){
        System.out.println("MENU DE LAS RESERVAS");
        String resultado = "";
        resultado += "**********************************\n";
        resultado += "*         R E S E R V A S        *\n";
        resultado += "**********************************\n";
        resultado += "* 1=> Realizar reserva           *\n";
        resultado += "* 2=> Anular reserva             *\n";
        resultado += "* 3=> Pedido                     *\n";
        resultado += "* 4=> Recepcion                  *\n";
        resultado += "* 5=> Mostrar reservas           *\n";
        resultado += "* 6=> Salir                      *\n";
        resultado += "**********************************\n";
        resultado += "Elige una opción (1-6): ";
        System.out.println(resultado);
    }

    public static Reserva menuReserva(){
        String nif;
        String nombre;
        String tel;
        int codigo;
        int ejemplares;

        System.out.println("SEGUNDA RESERVA \n\n");
        entrada.nextLine();
        System.out.println("Introduzca NIF: ");
        nif =entrada.nextLine();
        System.out.println("Introduzca nombre: ");
        nombre =entrada.nextLine();
        System.out.println("Introduzca telefono: ");
        tel =entrada.nextLine();
        System.out.println("Introduzca codigo: ");
        codigo =entrada.nextInt();
        System.out.println("Introduzca numero de ejemplares: ");
        ejemplares =entrada.nextInt();

        Reserva r1 = new Reserva(nif, nombre, tel, codigo, ejemplares);
        return r1;
    }

    public static void main(String[] args) {
        int opcion=0;
        String nif;
        int codigo;

        ListaReservas lr1 = new ListaReservas();

        do {
            menu();
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        lr1.reservar(menuReserva());
                    } catch (ListaLlenaException | ElementoDuplicadoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.print("Introduce NIF: ");
                    nif = entrada.nextLine();
                    System.out.print("Introduce codigo: ");
                    codigo=entrada.nextInt();

                    try {
                        lr1.cancelar(nif, codigo);
                    } catch (ElementoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Introduce codigo: ");
                    codigo=entrada.nextInt();
                    System.out.println("numero de ejemplares del libro " + codigo + " : " + lr1.numEjemplaresReservadosLibro(codigo));
                    break;
                case 4:
                    System.out.print("Introduce codigo: ");
                    codigo=entrada.nextInt();
                    lr1.reservasLibro(codigo);
                    break;
                case 5:
                    System.out.println(lr1);
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }
            System.out.println("\nPulse Intro para continuar...");
                        entrada.nextLine();
                        entrada.nextLine();
        } while (opcion != 6);
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Saliendo...");
    }
}
