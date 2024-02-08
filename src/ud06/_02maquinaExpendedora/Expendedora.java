package ud06._02maquinaExpendedora;

public class Expendedora {
    //atributos
    private double credito;
    private int stock;
    private double precio;
    private double cambio;
    private double recaudacion;

    //constructor
    public Expendedora(int stock, double precio, double cambio) {
        this.stock = stock;
        this.precio = precio;
        this.cambio = cambio;
        this.credito = 0;
        this.recaudacion = 0;
    }

    //getters
    public double getCredito() {
        return credito;
    }

    public double getCambio() {
        return cambio;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    //getters modificaos
    public int getStock(int numProduct) {
        return stock;
    }

    public double getPrecio(int numProduct) {
        return precio;
    }

    // // Setters (privados pedido por el ejercicio)    
    // private void setCredito(double credito) {
    //     this.credito = credito;
    // }

    // private void setStock(int stock) {
    //     this.stock = stock;
    // }

    // private void setPrecio(double precio) {
    //     this.precio = precio;
    // }

    // private void setCambio(double cambio) {
    //     this.cambio = cambio;
    // }

    // private void setRecaudacion(double recaudacion) {
    //     this.recaudacion = recaudacion;
    // }

    @Override
    public String toString() {
        String str = "";
        str += "\n Credito: " + this.credito;
        str += "\n Cambio: " + this.cambio;
        str += "\n Stock: " + this.stock;
        str += "\n Recaudacion: " + this.recaudacion;
        return str;
    }

    public void introducirDinero(double importe){
        this.credito += importe;
    }

    public double solicitarDevolucion(){
        double devolucion = this.credito;
        this.credito = 0;
        return devolucion;
    }

    // Creamos el metodo comprar producto
    public double comprarProducto(int producto) throws NoHayCambioException, NoHayProductoException,CreditoInsuficienteException{
        double devolucion = 0;
        if (this.stock >= 1) {
            if (this.credito >= this.precio) {
                if (this.credito-this.precio<=this.cambio) {
                    // La devolucion es el restante de comprar el producto.
                    devolucion = this.credito-this.precio;
                    // Credito lo pasamos a 0 ya que vamos a devolver el credito sobrante.
                    this.credito = 0;
                    // Bajamos el stock del producto.
                    this.stock--;
                    //Restamos la devolucion al cambio.
                    this.cambio = this.cambio - devolucion;
                    //Recaudacion le añadimos el precio.
                    this.recaudacion += this.precio;
                }else{
                    throw new NoHayCambioException();
                }
            }else{
                throw new CreditoInsuficienteException();
            }
        }else{
            throw new NoHayProductoException();
        }
        return devolucion;
    }

    // Excepciones
    static class NoHayCambioException extends Exception{
        public NoHayCambioException(){
            super("ERROR: No hay cambio.");
        }
    }

    static class NoHayProductoException extends Exception{
        public NoHayProductoException(){
            super("ERROR: No queda stock del producto seleccionado.");
        }
    }

    static class CreditoInsuficienteException extends Exception{
        public CreditoInsuficienteException(){
            super("ERROR: Credito insuficiente");
        }
    }
}
