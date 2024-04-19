package ud07.ejercicios.Ejer02_Biblioteca;

public class Libro implements Comparable<Libro>{
    private String titulo;
    private String autor;
    private String estanteria;
    
    public Libro(String titulo, String autor, String estanteria) {
        this.titulo = titulo;
        this.autor = autor;
        this.estanteria = estanteria;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getEstanteria() {
        return estanteria;
    }
    @Override
    public int compareTo(Libro o) {
        return this.getTitulo().compareTo(o.getTitulo());
    }
}
