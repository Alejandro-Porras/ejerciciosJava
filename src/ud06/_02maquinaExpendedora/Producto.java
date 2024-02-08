package ud06._02maquinaExpendedora;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int decrementarStock(){
        return --this.stock;
    }

    @Override
    public String toString() {
        return "\nNombre: " + this.nombre + "\r\t\t - Precio: " + this.precio + "\r\t\t\t\t - Stock: " + this.stock;
    }
}
