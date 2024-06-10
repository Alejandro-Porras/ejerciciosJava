package ud09.actividades._12_redes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements IRepository<Usuario> {
    private static final String INSERT_QUERY = "INSERT INTO users (name, lastName) VALUES (?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM users";
    private static final String UPDATE_QUERY = "UPDATE users SET name = ?, lastName = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";

    @Override
    public void crear(Usuario usuario)  throws SQLException {
        try (Connection con = DbConnect.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());

            int filasInsertadas = pst.executeUpdate();
            if (filasInsertadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    usuario.setId(id);
                }
            }
        }    
    }

    @Override
    public Usuario obtener(int id)  throws SQLException {
        Usuario usuario = null;
        try (Connection con = DbConnect.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QUERY)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                usuario = new Usuario(id, nombre, apellido);
            }
        } 
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodos()  throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection con = DbConnect.getInstance().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_QUERY)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Usuario usuario = new Usuario(id, nombre, apellido);
                usuarios.add(usuario);
            }
        } 
        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario)  throws SQLException {
        try (Connection con = DbConnect.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(UPDATE_QUERY)) {

            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            pst.setInt(3, usuario.getId());

            pst.executeUpdate();
        } 
    }

    @Override
    public void eliminar(int id)  throws SQLException {
        try (Connection con = DbConnect.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(DELETE_QUERY)) {

            pst.setInt(1, id);

            pst.executeUpdate();
        } 
    }
}
