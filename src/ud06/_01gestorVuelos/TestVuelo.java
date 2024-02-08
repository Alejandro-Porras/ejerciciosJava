package ud06._01gestorVuelos;

import java.time.LocalTime;

import ud06._01gestorVuelos.Vuelo.NumeroAsientoNoValidoException;
import ud06._01gestorVuelos.Vuelo.PreferenciaNoValidaException;
import ud06._01gestorVuelos.Vuelo.VueloCompletoException;

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

        try {
            v1.cancelarReserva(3);
            System.out.println(v1);
        } catch (NumeroAsientoNoValidoException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
