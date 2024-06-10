package ud09.test;

import java.sql.*;

public class ListarEmpleados3000 {
    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            
            Statement st = conexion.createStatement();

            String sql = "Select * from empleados where salario >= 3000";
            ResultSet rs = st.executeQuery(sql);

            System.out.printf("Proveedor -> %-3s %-20s %-8s \n", "ID", "Nombre", "Salario");
            while (rs.next()) {
                
                System.out.printf("Proveedor -> %-3d %-20s %-8.2f \n", 
                                                        rs.getInt(1), 
                                                        rs.getString(2), 
                                                        rs.getDouble(3));
            }
            rs.close();
            st.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }
}
