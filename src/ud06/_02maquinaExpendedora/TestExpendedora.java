package ud06._02maquinaExpendedora;

import ud06._02maquinaExpendedora.Expendedora.CreditoInsuficienteException;
import ud06._02maquinaExpendedora.Expendedora.NoHayCambioException;
import ud06._02maquinaExpendedora.Expendedora.NoHayProductoException;

public class TestExpendedora {
    public static void main(String[] args) {
        // Creamos el objeto maquina expendedora.
        Expendedora e1 = new Expendedora(12, 3.75, 5);
        
        //Mostramos por pantalla el objeto:
        System.out.println("Maquina Expendedora 1");
        System.out.println(e1);

        //Introducimos 5 euros a nuestro credito
        e1.introducirDinero(5);

        try {
            //realizamos la compra y mostramos la devolucion
            System.out.println("\nDevolucion al comprar 1 producto (e1)");
            System.out.println(e1.comprarProducto(0));
        } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        // Tenemos 0 creditos (ya que nos han devuelto el dinero en el de arriba) y añadimos 2
        e1.introducirDinero(2);

        //solicitamos la devolucion de nuestro money y mostramos cuanto nos ha devuelto
        System.out.println(e1.solicitarDevolucion());

        // Volvemos a introducir 2 euros
        e1.introducirDinero(2);
        try {
            // Intentamos realizar la  compra con credito insuficiente (credito 2 precio 3.75)
            System.out.println("\nSegunda compra del producto. (e1)");
            System.out.println(e1.comprarProducto(0));
        } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        // Creamos la segunda maquina expendedora con 0 de stock para comprobar la excepcion.
        Expendedora e2 = new Expendedora(0, 100, 5000);

        e2.introducirDinero(100);
        try {
            // Intentamos realizar la  compra con credito insuficiente (credito 2 precio 3.75)
            System.out.println("\nPrimera compra del producto. (e2)");
            System.out.println(e2.comprarProducto(0));
        } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        // Creamos la segunda maquina expendedora con 0 de stock para comprobar la excepcion.
        Expendedora e3 = new Expendedora(100, 1, 1);

        e3.introducirDinero(1000000);
        try {
            // Intentamos realizar la  compra con credito insuficiente (credito 2 precio 3.75)
            System.out.println("\nPrimera compra del producto. (e3)");
            System.out.println(e3.comprarProducto(0));
        } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException e) {
            System.out.println(e.getMessage());
        }


    }
}
