package ud09.actividades._12_redes;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements IRepository<Comment> {
    private static final String INSERT_QUERY = "INSERT INTO comments (texto, fecha, userId, postId) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM comments WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM comments";
    private static final String UPDATE_QUERY = "UPDATE comments SET texto = ?, fecha = ?, userId = ?, postId = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM comments WHERE id = ?";

    @Override
    public void crear(Comment comment) throws SQLException {
        try (Connection con = DbConnect.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, comment.getTexto());
            pst.setDate(2, Date.valueOf(comment.getFecha()));
            pst.setInt(3, comment.getUserId());
            pst.setInt(4, comment.getPostId());

            int filasInsertadas = pst.executeUpdate();
            if (filasInsertadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    comment.setId(id);
                }
            }
        }
    }

    @Override
    public Comment obtener(int id) throws SQLException {
        Comment comment = null;
        try (Connection con = DbConnect.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QUERY)) {
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String texto = rs.getString("texto");
                    LocalDate fecha = rs.getDate("fecha").toLocalDate();
                    int userId = rs.getInt("userId");
                    int postId = rs.getInt("postId");
                    comment = new Comment(id, texto, fecha, userId, postId);
                }
            }
            return comment;
        }
    
        @Override
        public List<Comment> obtenerTodos() throws SQLException {
            List<Comment> comments = new ArrayList<>();
            try (Connection con = DbConnect.getInstance().getConnection();
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(SELECT_ALL_QUERY)) {
    
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String texto = rs.getString("texto");
                    LocalDate fecha = rs.getDate("fecha").toLocalDate();
                    int userId = rs.getInt("userId");
                    int postId = rs.getInt("postId");
                    Comment comment = new Comment(id, texto, fecha, userId, postId);
                    comments.add(comment);
                }
            }
            return comments;
        }
    
        @Override
        public void actualizar(Comment comment) throws SQLException {
            try (Connection con = DbConnect.getInstance().getConnection();
                 PreparedStatement pst = con.prepareStatement(UPDATE_QUERY)) {
    
                pst.setString(1, comment.getTexto());
                pst.setDate(2, Date.valueOf(comment.getFecha()));
                pst.setInt(3, comment.getUserId());
                pst.setInt(4, comment.getPostId());
                pst.setInt(5, comment.getId());
    
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