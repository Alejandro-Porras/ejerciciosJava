package ud09.actividades;

import java.sql.*;

import ud09.test.Credenciales;

public class _03_GestionAlumnos {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            mostrarAlumnoMasJoven(con);
            mostrarAlumnoMasViejo(con);
            mostrarAlumnosEnOrdenInverso(con);
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void mostrarAlumnoMasJoven(Connection conn) throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("SELECT * FROM alumnos ORDER BY edad ASC LIMIT 1");
        if (rs.first()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int edad = rs.getInt("edad");
            System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
        }
        rs.close();
        st.close();
    }

    public static void mostrarAlumnoMasViejo(Connection conn) throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("SELECT * FROM alumnos ORDER BY edad DESC LIMIT 1");
        if (rs.first()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int edad = rs.getInt("edad");
            System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
        }
        rs.close();
        st.close();
    }

    public static void mostrarAlumnosEnOrdenInverso(Connection conn) throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("SELECT * FROM alumnos ORDER BY edad DESC");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int edad = rs.getInt("edad");
            System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
        }
        rs.close();
        st.close();
    }
}
