package ud06._02maquinaExpendedora;

import ud06._02maquinaExpendedora.ExpendedoraSurtido.CreditoInsuficienteException;
import ud06._02maquinaExpendedora.ExpendedoraSurtido.NoHayCambioException;
import ud06._02maquinaExpendedora.ExpendedoraSurtido.NoHayProductoException;
import ud06._02maquinaExpendedora.Surtido.RangoInvalidoException;

public class TestExpendedora2 {
    public static void main(String[] args) {
        // Creamos el objeto maquina expendedora.
        ExpendedoraSurtido e1 = new ExpendedoraSurtido(0);
        
        //Mostramos por pantalla el objeto:
        System.out.println("Maquina Expendedora");
        System.out.println(e1.toStringSurtido());

        //Introducimos 5 euros a nuestro credito
        e1.introducirDinero(100);

        try {
            //realizamos la compra y mostramos la devolucion
            System.out.println("\nDevolucion al comprar 1 producto (e1)");
            System.out.println(e1.comprarProducto(1));
            System.out.println(e1.toStringSurtido());
        } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException | RangoInvalidoException e) {
            System.out.println(e.getMessage());
        }

    }
}
