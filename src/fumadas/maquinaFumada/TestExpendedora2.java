package fumadas.maquinaFumada;

import fumadas.maquinaFumada.ExpendedoraSurtido.CreditoInsuficienteException;
import fumadas.maquinaFumada.ExpendedoraSurtido.NoHayCambioException;
import fumadas.maquinaFumada.ExpendedoraSurtido.NoHayProductoException;
import fumadas.maquinaFumada.Surtido.RangoInvalidoException;

public class TestExpendedora2 {
    public static void main(String[] args) {
        // Creamos el objeto maquina expendedora.
        ExpendedoraSurtido e1 = new ExpendedoraSurtido();
        
        //Mostramos por pantalla el objeto:
        System.out.println("Maquina Expendedora");
        System.out.println(e1.toStringSurtido());

        System.out.println("Recaudacion: " + e1.getRecaudacion());
        System.out.println("Cambio: " + e1.getCambio());
        //Introducimos 5 euros a nuestro credito
        e1.introducirDinero(50);

        try {
            //realizamos la compra y mostramos la devolucion
            System.out.println("\nDevolucion al comprar 1 producto (e1)");
            System.out.println(e1.comprarProducto(1));
            System.out.println(e1.toStringSurtido());
        } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException | RangoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("xd");
        e1.guardar();
        e1.añadirProducto();
        System.out.println(e1.toStringSurtido());
    }
}
