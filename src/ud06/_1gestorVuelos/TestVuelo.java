package ud06._1gestorVuelos;

import java.time.LocalTime;

import ud06._1gestorVuelos.Vuelo.PreferenciaNoValidaException;
import ud06._1gestorVuelos.Vuelo.VueloCompletoException;

public class TestVuelo {
    public static void main(String[] args) {
        // Vuelo v1 = new Vuelo("IB101", "Valencia", "París", 
        // LocalTime.of(19, 5), LocalTime.of(21, 0), 2);

        Vuelo v1 = new Vuelo("IB101", "Valencia", "París", 
        LocalTime.of(19, 5), LocalTime.of(21, 0));

        try {
            v1.reservarAsiento("Miguel Fernández", 'v');
            v1.reservarAsiento("Ana Folgado", 'v');
            v1.reservarAsiento("David Más", 'p');

        } catch (VueloCompletoException | PreferenciaNoValidaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(v1);
    }
}
