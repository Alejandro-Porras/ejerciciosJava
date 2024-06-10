package ud09.actividades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ud09.test.Credenciales;

public class _06_GestionPedidos {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            Scanner entrada = new Scanner(System.in);

            System.out.print("Ingresa el nombre del cliente: ");
            String cliente = entrada.nextLine();
            listarPedidosPorCliente(con, cliente);

            System.out.print("Ingresa la fecha del pedido (YYYY-MM-DD): ");
            String fecha = entrada.nextLine();
            buscarPedidosPorFecha(con, fecha);

            entrada.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void listarPedidosPorCliente(Connection con, String cliente) throws SQLException {
        String query = "SELECT * FROM pedidos WHERE cliente LIKE ?";
        
        try (PreparedStatement pst = con.prepareStatement(query, 
                                                            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            pst.setString(1, cliente);
            ResultSet rs = pst.executeQuery();
            System.out.println("Pedidos del cliente " + cliente + ":");
            while (rs.next()) {
                int id = rs.getInt("id");
                String prod = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                String fecha = rs.getString("fecha");
                System.out.println("ID: " + id + ", Producto: " + prod + ", Cantidad: " + cantidad + ", Fecha: " + fecha);
            }
        }
    }

    public static void buscarPedidosPorFecha(Connection con, String fecha) throws SQLException {
        String query = "SELECT * FROM pedidos WHERE fecha = ?";
        
        try (PreparedStatement pst = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            pst.setString(1, fecha);
            ResultSet rs = pst.executeQuery();
            System.out.println("Pedidos en la fecha " + fecha + ":");
            if (rs.last()) {
                do {
                    int id = rs.getInt("id");
                    String cliente = rs.getString("cliente");
                    String prod = rs.getString("producto");
                    int cantidad = rs.getInt("cantidad");
                    System.out.println("ID: " + id + ", Cliente: " + cliente + ", Producto: " + prod + ", Cantidad: " + cantidad);
                } while (rs.previous());
            } else {
                System.out.println("No se encontraron pedidos en la fecha especificada.");
            }
        }
    }
}
