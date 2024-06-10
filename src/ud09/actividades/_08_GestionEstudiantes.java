package ud09.actividades;

import java.sql.*;

import ud09.test.Credenciales;

public class _08_GestionEstudiantes {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM estudiantes");

            mostrarPosicionEstudiante(rs);
            validarPosicionCursor(rs);
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void mostrarPosicionEstudiante(ResultSet rs) throws SQLException {
        if (rs.next()) {
            int posicion = rs.getRow();
            System.out.println("Posicion actual del estudiante: " + posicion);
        } else {
            System.out.println("No hay estudiantes en la base de datos.");
        }
    }

    public static void validarPosicionCursor(ResultSet rs) throws SQLException {
        if (rs.isBeforeFirst()) {
            System.out.println("El cursor esta antes del primer registro.");
        } else if (rs.isFirst()) {
            System.out.println("El cursor esta en el primer registro.");
        } else if (rs.isLast()) {
            System.out.println("El cursor esta en el ultimo registro.");
        } else if (rs.isAfterLast()) {
            System.out.println("El cursor esta despues del ultimo registro.");
        } else {
            System.out.println("El cursor esta en una posicion intermedia.");
        }
    }
}
