package ud07.ejercicios.Ejer03_Academia;

public class Aula implements Comparable<Aula>{
    private int codAula;

    public Aula(int codAula) {
        this.codAula = codAula;
    }

    public int getCodAula() {
        return codAula;
    }

    @Override
    public int compareTo(Aula o) {
        return this.codAula-o.codAula;
    }

    @Override
    public String toString() {
        return "Aula numero : " + getCodAula();
    }
}
