package ud09.actividades._12_redes;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements IRepository<Post> {
    private static final String INSERT_QUERY = "INSERT INTO posts (texto, likes, fecha, userId) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM posts WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM posts";
    private static final String UPDATE_QUERY = "UPDATE posts SET texto = ?, likes = ?, fecha = ?, userId = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM posts WHERE id = ?";

    @Override
    public void crear(Post post) throws SQLException {
        try (Connection con = DbConnect.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, post.getTexto());
            pst.setInt(2, post.getLikes());
            pst.setDate(3, Date.valueOf(post.getFecha()));
            pst.setInt(4, post.getUserId());

            int filasInsertadas = pst.executeUpdate();
            if (filasInsertadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    post.setId(id);
                }
            }
        }
    }

    @Override
    public Post obtener(int id) throws SQLException {
        Post post = null;
        try (Connection con = DbConnect.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QUERY)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String texto = rs.getString("texto");
                int likes = rs.getInt("likes");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                int userId = rs.getInt("userId");
                post = new Post(id, texto, likes, fecha, userId);
            }
        }
        return post;
    }

    @Override
    public List<Post> obtenerTodos() throws SQLException {
        List<Post> posts = new ArrayList<>();
        try (Connection con = DbConnect.getInstance().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_QUERY)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String texto = rs.getString("texto");
                int likes = rs.getInt("likes");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                int userId = rs.getInt("userId");
                Post post = new Post(id, texto, likes, fecha, userId);
                posts.add(post);
            }
        }
        return posts;
    }

    @Override
    public void actualizar(Post post) throws SQLException {
        try (Connection con = DbConnect.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(UPDATE_QUERY)) {

            pst.setString(1, post.getTexto());
            pst.setInt(2, post.getLikes());
            pst.setDate(3, Date.valueOf(post.getFecha()));
            pst.setInt(4, post.getUserId());
            pst.setInt(5, post.getId());

            pst.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        try (Connection con = DbConnect.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(DELETE_QUERY)) {

            pst.setInt(1, id);

            pst.executeUpdate();
        }
    }
}

