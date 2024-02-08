package tests.test_fumadas;

public class Expendedora {
    private double credito;
    private int stock;
    private double precio;
    private double cambio;
    private double recaudacion;

    //Constructor
    public Expendedora(int stock, double precio, double cambio) {
        this.credito = 0;
        this.stock = stock;
        this.precio = precio;
        this.cambio = cambio;
        this.recaudacion = 0;
    }

    //Getters and Setters
    public double getCredito() {
        return credito;
    }
    // private void setCredito(double credito) {
    //     this.credito = credito;
    // }
    public double getCambio() {
        return cambio;
    }
    // private void setCambio(double cambio) {
    //     this.cambio = cambio;
    // }
    public double getRecaudacion() {
        return recaudacion;
    }
    // private void setRecaudacion(double recaudacion) {
    //     this.recaudacion = recaudacion;
    // }

    //Getters and Setters especiales
    public int getStock(int producto) {
        return stock;
    }
    // private void setStock(int stock) {
    //     this.stock = stock;
    // }
    public double getPrecio(int producto) {
        return precio;
    }
    // private void setPrecio(double precio) {
    //     this.precio = precio;
    // }

    @Override
    public String toString(){
        String str = "";
        str += "Credito: " + this.credito + " - ";
        str += "Cambio: " + this.cambio + " - ";
        str += "Stock: " + this.stock + " - ";
        str += "Recaudacion: " + this.recaudacion;

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

    public double comprarProducto(int producto) throws NoHayCambioException, NoHayProductoException, CreditoInsuficienteException {
        double devolucion = 0;
        if (this.stock >= 1) {
            if (this.credito >= this.precio) {
                if (this.credito - this.precio <= this.cambio) {
                    // quitar stock, credito a 0, restar cambio, sumar ganancias
                    devolucion = (this.credito - this.precio);
                    this.credito = 0;
                    this.stock--;
                    this.cambio =  this.cambio - devolucion;
                    this.recaudacion += this.precio;
                } else {
                    throw new NoHayCambioException();
                }
            } else {
                throw new CreditoInsuficienteException();
            }
        } else {
            throw new NoHayProductoException();
        }
        return devolucion;
    }

    static class NoHayCambioException extends Exception{
        public NoHayCambioException(){
            super("No hay suficiente cambio en la maquina.");
        }
    }
    static class NoHayProductoException extends Exception{
        public NoHayProductoException(){
            super("No hay stock.");
        }
    }
    static class CreditoInsuficienteException extends Exception{
        public CreditoInsuficienteException(){
            super("No has introducido suficiente dinero.");
        }
    }
}
