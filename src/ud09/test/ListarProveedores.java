package ud09.test;

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class ListarProveedores {
    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            
            Statement st = conexion.createStatement();

            String sql = "Select * from proveedores";
            ResultSet rs = st.executeQuery(sql);
            System.out.printf("Proveedor -> %-3s %-20s %-20s %-8s \n", "ID", "Nombre", "Fecha ingreso", "Precio");
            while (rs.next()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fecha = "";
                if (rs.getDate(3)==null) {
                    fecha = "Fecha no asignada";
                }else{
                    fecha = rs.getDate(3).toLocalDate().format(dtf);
                }
                
                System.out.printf("Proveedor -> %-3d %-20s %-20s %-8.2f \n", 
                                                        rs.getInt(1), 
                                                        rs.getString(2), 
                                                        fecha, 
                                                        rs.getDouble(4));
            }
            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("ERROR -> " + e.getMessage());
        }
    }
}
