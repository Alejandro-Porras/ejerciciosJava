package fumadas.maquinaFumada;

public class Producto {
    // Atributos
    private String nombre;
    private double precio;
    private int stock;
    
    // Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Decrementar el stock del producto
    public int decrementarStock(){
        return --this.stock;
    }

    // Sobrecarga de metodos del incremento del stock del producto
    // Incrementar el stock del producto
    public int incrementarStock(){
        return ++this.stock;
    }

    // Incrementar el stock del producto por propiedad
    public int incrementarStock(int aumento){
        this.stock+=aumento;
        return this.stock;
    }

    // toString de todos los atributos del objeto Producto
    @Override
    public String toString() {
        return "\nNombre: " + this.nombre + "\r\t\t - Precio: " + this.precio + "\r\t\t\t\t - Stock: " + this.stock;
    }
}
