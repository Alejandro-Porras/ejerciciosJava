package tests.test_fumadas;

import tests.test_fumadas.Expendedora.CreditoInsuficienteException;
import tests.test_fumadas.Expendedora.NoHayCambioException;
import tests.test_fumadas.Expendedora.NoHayProductoException;

public class TestExpendedora {
    public static void main(String[] args) {
        Expendedora expendedora1 = new Expendedora(12, 3.75, 5.00);
        Expendedora expendedora2 = new Expendedora(0, 400.00, 1000.00);
        Expendedora expendedora3 = new Expendedora(20, 400.00, 0);

        //Mostramos el objeto
        System.out.println(expendedora1);

        //Insertamos 5€ a la maquina
        expendedora1.introducirDinero(5.00);
        try {
            //Compramos el producto y mostramos el cambio
            System.out.println(expendedora1.comprarProducto(0));
        } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

         //Insertamos 2€ a la maquina
        expendedora1.introducirDinero(2.00);
        //Devolvemos el credito sin haber comprado
        System.out.println(expendedora1.solicitarDevolucion());

        //Probar excepcion con dinero Insuficiente
        expendedora1.introducirDinero(1.00);
        try {
            System.out.println(expendedora1.comprarProducto(0));
        } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        //Probar excepcion sin Stock
        expendedora2.introducirDinero(400.00);
        try {
            System.out.println(expendedora2.comprarProducto(0));
        } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

         //Probar excepcion sin Cambio para retornar
         expendedora3.introducirDinero(425.00);
         try {
             System.out.println(expendedora3.comprarProducto(0));
         } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException e) {
             System.out.println(e.getMessage());
         }
    }
}
