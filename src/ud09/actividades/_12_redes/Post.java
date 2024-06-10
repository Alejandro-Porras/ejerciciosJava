package ud09.actividades._12_redes;

import java.time.LocalDate;

public class Post {
    private int id;
    private String texto;
    private int likes;
    private LocalDate fecha;
    private int userId;

    // constructor
    public Post(int id, String texto, int likes, LocalDate fecha, int userId) {
        this.id = id;
        this.texto = texto;
        this.likes = likes;
        this.fecha = fecha;
        this.userId = userId;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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

    @Override
    public String toString() {
        return "Post [id=" + id + ", texto=" + texto + ", likes=" + likes + ", fecha=" + fecha + ", userId=" + userId + "]";
    }
}
