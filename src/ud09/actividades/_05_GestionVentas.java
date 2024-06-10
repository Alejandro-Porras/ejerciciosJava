package ud09.actividades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ud09.test.Credenciales;

public class _05_GestionVentas {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            Scanner entrada = new Scanner(System.in);

            System.out.println("Total de ventas:");
            calcularTotalVentas(con);

            System.out.print("Ingresa el nombre del producto: ");
            String producto = entrada.nextLine();
            buscarVentasPorProducto(con, producto);

            entrada.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void calcularTotalVentas(Connection con) throws SQLException {
        String query = "SELECT total FROM ventas";
        double totalVentas = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                totalVentas += rs.getDouble("total");
            }
        }
        System.out.println("total ventas: " + totalVentas);
    }

    public static void buscarVentasPorProducto(Connection con, String producto) throws SQLException {
        String query = "SELECT * FROM ventas WHERE producto LIKE ?";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, producto);
            ResultSet rs = pst.executeQuery();
            System.out.println("Ventas del producto " + producto + ":");
            while (rs.next()) {
                int id = rs.getInt("id");
                String prod = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                double total = rs.getDouble("total");
                System.out.println("ID: " + id + ", Producto: " + prod + ", Cantidad: " + cantidad + ", Total: " + total);
            }
        }
    }
}
