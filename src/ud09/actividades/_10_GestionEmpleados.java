package ud09.actividades;

import java.sql.*;
import java.util.Scanner;

import ud09.test.Credenciales;

public class _10_GestionEmpleados {
    public static Scanner entrada = new Scanner(System.in);

    public static void menu() {
        int opcion = 0;
        do {
            System.out.println("----------------Gestion de empleados----------------\n" +
                    "1.Listar empleados\n" +
                    "2.Actualizar salarios\n" +
                    "3.Eliminar empleados\n" +
                    "4.Mostrar empleado por ID\n" +
                    "5.Buscar empleados por salario\n" +
                    "6.Verificar si hay empleados\n" +
                    "7.Mostrar primer empleado\n" +
                    "8.Salir\n");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    listarEmpleados();
                    break;
                case 2:
                    actualizarSalarios();
                    break;
                case 3:
                    eliminarEmpleados();
                    break;
                case 4:
                    System.out.println("Introduzca el ID del empleado:");
                    int id = entrada.nextInt();
                    entrada.nextLine();
                    mostrarEmpleadoPorID(id);
                    break;
                case 5:
                    System.out.println("Introduzca el salario minimo:");
                    double salarioMin = entrada.nextDouble();
                    System.out.println("Introduzca el salario maximo:");
                    double salarioMax = entrada.nextDouble();
                    entrada.nextLine();
                    buscarEmpleadosPorSalario(salarioMin, salarioMax);
                    break;
                case 6:
                    verificarSiHayEmpleados();
                    break;
                case 7:
                    mostrarPrimerEmpleado();
                    break;
                case 8:
                    System.out.println("ADIOOOS");
                    break;
                default:
                    System.out.println("Numero de opcion incorrecto, intentelo de nuevo.");
                    break;
            }
        } while (opcion != 8);
    }

    public static void listarEmpleados() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);
             Statement st = con.createStatement()) {
            String sql = "SELECT * FROM empleados";
            ResultSet rs = st.executeQuery(sql);

            System.out.printf("%-5s %-20s %-10s\n", "ID", "Nombre", "Salario");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-10.2f\n", rs.getInt("id"), 
                rs.getString("nombre"), rs.getDouble("salario"));
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void actualizarSalarios() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);
             Statement st = con.createStatement()) {
            String sql = "UPDATE empleados SET salario = salario * 1.10";
            int rowsUpdated = st.executeUpdate(sql);
            System.out.println("Salarios actualizados para " + rowsUpdated + " empleados.");
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void eliminarEmpleados() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);
             Statement st = con.createStatement()) {
            String sql = "DELETE FROM empleados WHERE salario < 3000";
            int rowsDeleted = st.executeUpdate(sql);
            System.out.println("Eliminados " + rowsDeleted + " empleados con salario menor a 3000.");
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void mostrarEmpleadoPorID(int id) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM empleados WHERE id = " + id;
            ResultSet rs = st.executeQuery(sql);

            if (rs.absolute(1)) {
                System.out.printf("%-5s %-20s %-10s\n", "ID", "Nombre", "Salario");
                System.out.printf("%-5d %-20s %-10.2f\n", rs.getInt("id"), 
                rs.getString("nombre"), rs.getDouble("salario"));
            } else {
                System.out.println("Empleado con ID " + id + " no encontrado.");
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void buscarEmpleadosPorSalario(double salarioMin, double salarioMax) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);
             Statement st = con.createStatement()) {
            String sql = "SELECT * FROM empleados WHERE salario BETWEEN " + salarioMin + " AND " + salarioMax;
            ResultSet rs = st.executeQuery(sql);

            System.out.printf("%-5s %-20s %-10s\n", "ID", "Nombre", "Salario");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-10.2f\n", rs.getInt("id"), 
                rs.getString("nombre"), rs.getDouble("salario"));
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void verificarSiHayEmpleados() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM empleados";
            ResultSet rs = st.executeQuery(sql);

            if (rs.isBeforeFirst()) {
                System.out.println("Hay empleados en la base de datos.");
            } else if (rs.isAfterLast()) {
                System.out.println("No hay empleados en la base de datos.");
            } else {
                rs.last();
                if (rs.getRow() > 0) {
                    System.out.println("Hay empleados en la base de datos.");
                } else {
                    System.out.println("No hay empleados en la base de datos.");
                }
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void mostrarPrimerEmpleado() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM empleados";
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {
                System.out.printf("%-5s %-20s %-10s\n", "ID", "Nombre", "Salario");
                System.out.printf("%-5d %-20s %-10.2f\n", rs.getInt("id"), 
                rs.getString("nombre"), rs.getDouble("salario"));
            } else {
                System.out.println("No hay empleados en la base de datos.");
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
