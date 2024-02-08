package ud06._02maquinaExpendedora;

import java.io.FileNotFoundException;

import ud06._02maquinaExpendedora.Surtido.RangoInvalidoException;

public class ExpendedoraSurtido {
        //atributos
    private double credito;
    private double recaudacion;
    private double cambio;
    private Surtido productos;


    //constructor
    public ExpendedoraSurtido(double cambio) {
        this.credito = 0;
        this.recaudacion = 0;
        this.cambio = cambio;
        try {
            this.productos = new Surtido();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
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
    public int getStock(int numProduct) throws RangoInvalidoException {
        return this.productos.getProducto(numProduct).getStock();
    }

    public double getPrecio(int numProduct) throws RangoInvalidoException {
        return this.productos.getProducto(numProduct).getPrecio();
    }

    // Setters (privados pedido por el ejercicio)    
    // private void setCredito(double credito) {
    //     this.credito = credito;
    // }

    // private void setCambio(double cambio) {
    //     this.cambio = cambio;
    // }

    // private void setRecaudacion(double recaudacion) {
    //     this.recaudacion = recaudacion;
    // }

    public String toStringSurtido(){
        return this.productos.toString();
    }

    public void introducirDinero(double importe){
        this.credito += importe;
        System.out.println(this.productos.numProductos());
    }

    public double solicitarDevolucion(){
        double devolucion = this.credito;
        this.credito = 0;
        return devolucion;
    }

    // Creamos el metodo comprar producto
    public double comprarProducto(int producto) throws NoHayCambioException, NoHayProductoException,CreditoInsuficienteException,
     RangoInvalidoException{
        double devolucion = 0;
        if (producto>0 && producto<=this.productos.numProductos()) {
            if (getStock(producto) >= 1) {
                if (this.credito >= getPrecio(producto)) {
                    if (this.credito-getPrecio(producto)<=this.cambio) {
                        // La devolucion es el restante de comprar el producto.
                        devolucion = this.credito-getPrecio(producto);
                        // Credito lo pasamos a 0 ya que vamos a devolver el credito sobrante.
                        this.credito = 0;
                        // Bajamos el stock del producto.
                        this.productos.getProducto(producto).decrementarStock();
                        //Restamos la devolucion al cambio.
                        this.cambio = this.cambio - devolucion;
                        //Recaudacion le añadimos el precio.
                        this.recaudacion += getPrecio(producto);
                    }else{
                        throw new NoHayCambioException();
                    }
                }else{
                    throw new CreditoInsuficienteException();
                }
            }else{
                throw new NoHayProductoException();
            }
        }else {
            throw new RangoInvalidoException();
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
