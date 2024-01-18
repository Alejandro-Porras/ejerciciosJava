package ud05._4reservasLibreria;

import java.util.Scanner;

public class TestReservas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nif;
        String nombre;
        String tel;
        int codigo;
        int ejemplares;

        System.out.println("PRIMERA RESERVA \n\n");

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

        Reserva r2;
        do {
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

        r2 = new Reserva(nif, nombre, tel, codigo, ejemplares);

        if (r1.equals(r2)) {
            System.out.println("Las reservas son iguales, vuelva a introducirlas");
        }

        } while (r1.equals(r2));

        System.out.println("Mostramos antes de sumar :)");
        System.out.println(r1);
        System.out.println(r2);

        r1.setEjemplares(r1.getEjemplares()+1);
        r2.setEjemplares(r2.getEjemplares()+1);

        System.out.println("Despues de sumar");
        System.out.println(r1);
        System.out.println(r2);

        System.out.println("\n Mostramos el mayor");
        if (r1.compareTo(r2)>0) {
            System.out.println("La reserva 1 es mayor");
        }else if (r1.compareTo(r2)<0) {
            System.out.println("La reserva 2 es mayor");
        } else {
            System.out.println("Es el mismo libro");
        }

        entrada.close();
    }
}
