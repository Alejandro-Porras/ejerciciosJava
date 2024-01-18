package ud05._3contrarreloj;

public class Corredor {
    private int dorsal;
    private String nombre;
    private double tiempo;
    private static int dorsalSiguiente;
    
    public Corredor(String n){
        this.dorsal= generarDorsal();
        this.nombre=n;
        this.tiempo=0;
    }

    public double getTiempo(){
        return this.tiempo;
    }

    public int getDorsal(){
        return this.dorsal;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setTiempo(double t) throws IllegalArgumentException{
        if (t >= 0) {
            this.tiempo = t;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setTiempo(double t1, double t2) throws IllegalArgumentException{
        if (t2-t1 >=0) {
            this.tiempo = t2-t1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static class IllegalArgumentException extends Exception{
        public IllegalArgumentException (){
            super("Tiempo indicado negativo o nulo");
        }
    }

    @Override
    public String toString() {
        return "("+ this.getDorsal()+") - " + this.getNombre() + " - " + this.getTiempo() + " segundos"; 
    }

    public boolean equals(Object o){
        if (this==o) {
            return true;
        }
        if (o==null){
            return false;
        }
        if (this.getClass()!=o.getClass()) {
            return false;
        }
        final Corredor otro =(Corredor) o;
        return (this.dorsal==otro.dorsal);
    }

    public int compareTo (Corredor o){
        return this.dorsal<o.dorsal?this.dorsal:o.dorsal;
    }

    public static int generarDorsal(){
        return dorsalSiguiente++;
    }
}
