package ud09.actividades;

import java.sql.*;

import ud09.test.Credenciales;

public class _01_gestionEmpleados {
    
    public static void listarEmpleados(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM empleados");
        while (rs.next()) {
            String nombre = rs.getString(2);
            double salario = rs.getDouble(3);
            System.out.println("Empleado: " + nombre + ", Salario: " + salario);
        }
        rs.close();
        st.close();
    }

    public static void actualizarSalarios(Connection con) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("UPDATE empleados SET salario = salario * 1.1");
        st.close();
    }

    public static void eliminarEmpleados(Connection con) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM empleados WHERE salario < 3000");
        st.close();
    }

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            System.out.println("Listado de empleados:");
            listarEmpleados(con);

            actualizarSalarios(con);

            System.out.println("\nListado despues de la actualizacion:");
            listarEmpleados(con);

            eliminarEmpleados(con);

            System.out.println("\nListado despues de la eliminacion:");
            listarEmpleados(con);
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }
}
