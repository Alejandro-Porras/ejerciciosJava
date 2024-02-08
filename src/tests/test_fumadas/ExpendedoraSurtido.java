package tests.test_fumadas;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import tests.test_fumadas.Surtido.RangoInvalidoException;

public class ExpendedoraSurtido {
    //atributos
    // Solo son necesarios 
    private double credito;
    private Surtido productos;

    //constructor
    public ExpendedoraSurtido() {
        this.credito = 0;
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

    //getters modificaos
    // Recoge el numero de producto para comprobar el objeto de tipo Producto de Surtido
    public int getStock(int numProduct) throws RangoInvalidoException {
        return this.productos.getProducto(numProduct).getStock();
    }

    // Recoge el numero de producto para comprobar el objeto de tipo Producto de Surtido
    public double getPrecio(int numProduct) throws RangoInvalidoException {
        return this.productos.getProducto(numProduct).getPrecio();
    }

    //getters para saber cual es la recaudacion y el cambio (estan ya hechos en Surtido, pero para que sea mas facil su uso)
    public double getRecaudacion() {
        return this.productos.getRecaudacion();
    }

    public double getCambio() {
        return this.productos.getCambio();
    }


    // Comentados por su poco/nulo uso
    // Setters (privados pedido por el ejercicio)    
    // private void setCredito(double credito) {
    //     this.credito = credito;
    // }

    // Setters de admin
    public void setCambio(double cambio) {
        this.productos.setCambio(cambio);
    }

    public void setRecaudacion(double recaudacion) {
        this.productos.setRecaudacion(recaudacion);
    }

    // ToString de la clase Surtido
    public String toStringSurtido(){
        return this.productos.toString();
    }

    // Metodo para introducir el credito a la maquina expendedora
    public void introducirDinero(double importe){
        this.credito += importe;
    }

    // Metido para devolverle el dinero al usuario, por lo tanto, credito será 0
    public double solicitarDevolucion(){
        double devolucion = this.credito;
        this.credito = 0;
        return devolucion;
    }

    // Creamos el metodo comprar producto
    // La excepcion RangoInvalido se encuentra en la clase Surtido.
    public double comprarProducto(int producto) throws NoHayCambioException, NoHayProductoException,CreditoInsuficienteException,
     RangoInvalidoException{
        // Creamos la variable que vamos a retornar para no utilizar mas de un return
        double devolucion = 0;
        // Comprobamos que el numero de producto se encuentre en el rango.
        if (producto>0 && producto<=this.productos.numProductos()) {
            // Comprobamos que quede stock de el producto
            if (getStock(producto) >= 1) {
                // Comprobamos que haya suficiente credito para comprar el producto
                if (this.credito >= getPrecio(producto)) {
                    // Comprobamos que haya suficiente cambio para realizar la compra :)
                    if (this.credito-getPrecio(producto)<=this.productos.getCambio()) {
                        // La devolucion es el restante de comprar el producto.
                        devolucion = this.credito-getPrecio(producto);
                        // Credito lo pasamos a 0 ya que vamos a devolver el credito sobrante.
                        this.credito = 0;
                        // Bajamos el stock del producto.
                        this.productos.getProducto(producto).decrementarStock();
                        //Restamos la devolucion al cambio.
                        this.productos.setCambio(this.productos.getCambio() - devolucion);
                        //a Recaudacion le añadimos el precio.
                        this.productos.setRecaudacion(this.productos.getRecaudacion()+getPrecio(producto));
                    // Posibles Excepciones: 
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
        // Devolvemos el calculo realizado dentro de la anidacion de IF's
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

    // FUMADA, SOBREESCRITURA DEL ARCHIVO DE TEXTO
    // public void salir(){
    //     int numeroDeProductos = this.productos.numProductos();
    //     double recaudacion = this.productos.getRecaudacion();
    //     double cambio = this.productos.getCambio();
    //     String str = "";
    //     for (int i = 1; i < numeroDeProductos+1; i++) {
    //         str+=(this.productos.productoEscritura(i));
    //         if (i!=numeroDeProductos) {
    //             str+="\n";
    //         }
    //     }
    //     try (PrintWriter out = new PrintWriter(new FileWriter(this.productos.getNombreFichero()))) {
    //         out.println(numeroDeProductos);
    //         out.println(recaudacion);
    //         out.println(cambio);
    //         out.println(str);
    //     } catch (FileNotFoundException e) {
    //         System.out.println("ERROR: " + e.getMessage());
    //     } catch (IOException e) {
    //         System.out.println("ERROR: " + e.getMessage());
    //     }
    // }
}
