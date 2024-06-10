package ud09.actividades._12_redes;

import java.time.LocalDate;

public class Comment {
    private int id;
    private String texto;
    private LocalDate fecha;
    private int userId;
    private int postId;

    // constructor
    public Comment(int id, String texto, LocalDate fecha, int userId, int postId) {
        this.id = id;
        this.texto = texto;
        this.fecha = fecha;
        this.userId = userId;
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", texto=" + texto + ", fecha=" + fecha + ", userId=" + userId + ", postId=" + postId + "]";
    }
}
