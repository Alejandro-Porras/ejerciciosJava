package ud09.actividades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ud09.test.Credenciales;

public class _04_GestionLibros {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            Scanner entrada = new Scanner(System.in);

            System.out.print("Ingresa la década (ejemplo: 1990): ");
            int decada = entrada.nextInt();
            mostrarLibrosPorDecada(con, decada);

            entrada.nextLine();
            System.out.print("Ingresa el nombre del autor: ");
            String autor = entrada.nextLine();
            buscarLibroPorAutor(con, autor);

            con.close();
            entrada.close();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void mostrarLibrosPorDecada(Connection con, int decada) throws SQLException {
        String query = "SELECT * FROM libros WHERE anio_publicacion BETWEEN ? AND ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, decada);
            pst.setInt(2, decada + 9);
            ResultSet rs = pst.executeQuery();
            System.out.println("Libros publicados en la década de " + decada + " - " + (decada + 9) + ":");
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anho = rs.getInt("anio_publicacion");
                System.out.println("Título: " + titulo + ", Autor: " + autor + ", Año de Publicación: " + anho);
            }
        }
    }

    public static void buscarLibroPorAutor(Connection con, String autor) throws SQLException {
        String sql = "SELECT * FROM libros WHERE autor LIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, autor);
            ResultSet rs = pst.executeQuery();
            System.out.println("Libros escritos por el autor " + autor + ":");
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                int anho = rs.getInt("anio_publicacion");
                System.out.println("Título: " + titulo + ", Año de Publicación: " + anho);
            }
        }
    }
    

    
}
