package ud08.Ejercicios._04_centrocomercial;

public abstract class Televisor {
    protected String marca;
    protected String modelo;
    protected double precio;
    protected double pulgadas;
    
    public Televisor(String marca, String modelo, double precio, double pulgadas) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.pulgadas = pulgadas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Televisor tele = (Televisor) obj;
        return this.marca.equals(tele.marca) && 
                this.modelo.equals(tele.modelo);
    }

    public int compareTo(Object o){
        Televisor tele = (Televisor) o;
        int devolucion = this.marca.compareTo(tele.marca);
            if (devolucion == 0) {
                devolucion = this.modelo.compareTo(tele.modelo);
            }
        return devolucion;
    }

    public abstract String resulucion();

    @Override
    public String toString() {
        return "\nMarca -> " + this.marca +
                "\nModelo -> " + this.modelo +
                "\nPrecio -> " + this.precio +
                "\nPulgadas -> " + this.pulgadas + 
                "\nResolucion -> " + this.resulucion();
    }
}
