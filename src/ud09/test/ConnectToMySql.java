package ud09.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToMySql {

    public static void main(String[] args) {
        try {
            // Paso 1: Cargar el controlador JDBC de MySQL
            Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Cargado: " + c.getName());

            //Definir la url de conexión y los parámetros de usuario y contraseña
            // Paso 2: Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA);   
            System.out.println("Conexión completada");

            // Paso 3: Aquí puedes realizar operaciones en la base de datos
            // ...

            // Paso 4: Cerrar la conexión
            conexion.close();
            System.out.println("Conexión cerrada correctamente.");

        } catch (ClassNotFoundException cnfe) {
            System.out.println("ERROR al no encontrarse la clase controlador JDBC: " + cnfe.getMessage());
        } catch (SQLException ex) {
            System.out.println("ERROR al conectar: " + ex.getMessage());
        }
    }
}
