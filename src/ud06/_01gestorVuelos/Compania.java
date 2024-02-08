package ud06._01gestorVuelos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

public class Compania {
    // Variables
    private String nombre;
    private Vuelo[] listaVuelos;
    private int numVuelos;
    private final int MAXVUELOS = 10;

    // Constructor
    public Compania(String n) throws FileNotFoundException, ListaCompletaException{
        this.nombre=n;
        this.listaVuelos=new Vuelo[MAXVUELOS];
        this.leeVuelos();
    }

    // Metodo que lee los vuelos
    private void leeVuelos() throws FileNotFoundException, ListaCompletaException{
        try(BufferedReader br = new BufferedReader(new FileReader(this.nombre+".txt"));) {
            // Construimos el identificador.
            String identificador;
            // Le colocamos valor al identificador y empezamos el bucle en el cual
            // leeremos mientras que la linea del identificador no sea null.
            while ((identificador=br.readLine())!=null) {
                // Creamos e instanciamos todos los valores del vuelo.
                String origen=br.readLine();
                String destino=br.readLine();
                int hSalida=Integer.parseInt(br.readLine());
                int mSalida=Integer.parseInt(br.readLine());
                int hLlegada=Integer.parseInt(br.readLine());
                int mLlegada=Integer.parseInt(br.readLine());
                
                    // Creamos el vuelo y lo añadomos a la lista.
                    if (numVuelos<MAXVUELOS) {
                    this.listaVuelos[numVuelos]= new Vuelo(identificador, origen, destino,
                        LocalTime.of(hSalida, mSalida), LocalTime.of(hLlegada, mLlegada));
                    this.numVuelos++;
                    } else {
                        throw new ListaCompletaException();
                    }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage() + ". polluelo");
        }
    }

    public Vuelo buscarVuelo(String id) throws ElementoNoEncontradoException{
        int posi = -1;
        for (int i = 0; i < MAXVUELOS && listaVuelos[i]!=null; i++) {
            if (id.equals(listaVuelos[i].getIdentificador())) {
                posi = i;
            }
        }
        if (posi==-1) {
            throw new ElementoNoEncontradoException();
        }
        return listaVuelos[posi];
    }

    public void mostrarVuelosIncompletos(String o, String d) throws ElementoNoEncontradoException{
        boolean encontrado = false;
        for (int i = 0; i < MAXVUELOS && listaVuelos[i]!=null; i++) {
            if (listaVuelos[i].getOrigen().equals(o)&&listaVuelos[i].getDestino().equals(d)&&listaVuelos[i].hayLibres()) {
                System.out.println(listaVuelos[i].getIdentificador() + " " + listaVuelos[i].getOrigen() + " " 
                + listaVuelos[i].getDestino() + " " + listaVuelos[i].gethSalida() + " " + listaVuelos[i].gethLlegada());
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new ElementoNoEncontradoException();
        }
    }

    // Excepcion del metodo leer vuelos.
    static class ListaCompletaException extends Exception{
        public ListaCompletaException(){
            super("La lista esta completa.");
        }
    }

    // Excepcion del metodo buscar vuelos
    static class ElementoNoEncontradoException extends Exception{
        public ElementoNoEncontradoException(){
            super("El elemento que busca no se ha encontrado.");
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < MAXVUELOS && listaVuelos[i]!=null; i++) {
            str+="\n" + listaVuelos[i];
        }
        return str;
    }
}
