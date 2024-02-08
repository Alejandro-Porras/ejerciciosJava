package ud06._01gestorVuelos;

import java.io.FileNotFoundException;
import java.util.Scanner;

import ud06._01gestorVuelos.Compania.ElementoNoEncontradoException;
import ud06._01gestorVuelos.Compania.ListaCompletaException;
import ud06._01gestorVuelos.Vuelo.PreferenciaNoValidaException;
import ud06._01gestorVuelos.Vuelo.VueloCompletoException;

public class GestorVuelos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Compania c1;
        // ARCHIVO DE ARTURO CON ERROR RAAAAAAAAAAAAAAAAAAAH
        try {
            c1 = new Compania("rossenAir");
            c1.mostrarVuelosIncompletos("València", "Milán");
            System.out.println("A que vuelo quiere hacer la reserva?");
            try {
                c1.buscarVuelo(entrada.nextLine()).reservarAsiento("Manuel Soler Roca", 'v');
            } catch (VueloCompletoException | PreferenciaNoValidaException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(c1);
        } catch (FileNotFoundException | ListaCompletaException | ElementoNoEncontradoException e) {
            System.out.println("Error: "+ e.getMessage());
        }
        entrada.close();
    }
}
