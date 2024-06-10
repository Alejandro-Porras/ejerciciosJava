package ud09.actividades;

import java.sql.*;
import java.util.Scanner;

import ud09.test.Credenciales;

public class _11_GestionClientes {
    public static Scanner entrada = new Scanner(System.in);

    public static void menu() {
        int opcion = 0;
        do {
            System.out.println("----------------Gestion de clientes----------------\n" +
                    "1.Mostrar posicion actual del cliente\n" +
                    "2.Mostrar informacion del ultimo cliente\n" +
                    "3.Salir\n");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    mostrarPosicionActualCliente();
                    break;
                case 2:
                    mostrarUltimoCliente();
                    break;
                case 3:
                    System.out.println("ADIOOOS");
                    break;
                default:
                    System.out.println("Numero de opcion incorrecto, intentelo de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }

    public static void mostrarPosicionActualCliente() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM clientes";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                int posicion = rs.getRow();
                System.out.println("Posicion actual del cliente: " + posicion);
                System.out.printf("%-5s %-20s %-30s %-15s\n", "ID", "Nombre", "Correo", "Telefono");
                System.out.printf("%-5d %-20s %-30s %-15s\n", rs.getInt("id"), 
                rs.getString("nombre"), rs.getString("correo"), rs.getString("telefono"));
            } else {
                System.out.println("No hay clientes en la base de datos.");
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void mostrarUltimoCliente() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM clientes";
            ResultSet rs = st.executeQuery(sql);

            if (rs.last()) {
                System.out.println("Informacion del ultimo cliente:");
                System.out.printf("%-5s %-20s %-30s %-15s\n", "ID", "Nombre", "Correo", "Telefono");
                System.out.printf("%-5d %-20s %-30s %-15s\n", rs.getInt("id"), 
                rs.getString("nombre"), rs.getString("correo"), rs.getString("telefono"));
            } else {
                System.out.println("No hay clientes en la base de datos.");
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
