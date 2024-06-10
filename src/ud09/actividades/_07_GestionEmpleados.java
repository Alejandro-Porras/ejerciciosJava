package ud09.actividades;

import java.sql.*;
import java.util.Scanner;

import ud09.test.Credenciales;

public class _07_GestionEmpleados {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            Scanner entrada = new Scanner(System.in);

            listarEmpleados(con);

            actualizarSalarios(con);

            listarEmpleados(con);

            eliminarEmpleados(con);

            listarEmpleados(con);

            System.out.print("Ingresa el ID del empleado: ");
            int id = entrada.nextInt();
            mostrarEmpleadoPorId(con, id);

            System.out.print("Ingresa el salario minimo: ");
            double salarioMin = entrada.nextDouble();
            System.out.print("Ingresa el salario maximo: ");
            double salarioMax = entrada.nextDouble();
            buscarEmpleadosPorSalario(con, salarioMin, salarioMax);

            con.close();
            entrada.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }
    public static void listarEmpleados(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM empleados");

        System.out.println("Lista de empleados:");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            double salario = rs.getDouble("salario");
            System.out.println("ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario);
        }
    }

    public static void actualizarSalarios(Connection con) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("UPDATE empleados SET salario = salario * 1.10");
        System.out.println("Salarios actualizados en un 10%");
    }

    public static void eliminarEmpleados(Connection con) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM empleados WHERE salario < 3000");
        System.out.println("Empleados con salario menor a 3000 eliminados");
    }

    public static void mostrarEmpleadoPorId(Connection con, int id) throws SQLException {
        String query = "SELECT * FROM empleados WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.first()) {
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario);
            } else {
                System.out.println("No se encontro empleado con ID: " + id);
            }
        }
    }

    public static void buscarEmpleadosPorSalario(Connection con, double salarioMin, double salarioMax) throws SQLException {
        String query = "SELECT * FROM empleados WHERE salario BETWEEN ? AND ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setDouble(1, salarioMin);
            pst.setDouble(2, salarioMax);
            ResultSet rs = pst.executeQuery();
            System.out.println("Empleados con salario entre " + salarioMin + " y " + salarioMax + ":");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario);
            }
        }
    }
}
