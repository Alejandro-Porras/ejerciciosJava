package ud05._4reservasLibreria;

public class ListaReservas {
    private final int NMAX = 100;
    private Reserva[] lista;
    private int numReservas;
    
    public ListaReservas(){
        this.lista = new Reserva[NMAX];
        this.numReservas = 0;
    }

    public void reservar(String nif, String nombre, String telefono, int libro, int
    ejemplares) throws ListaLlenaException, ElementoDuplicadoException{
        Reserva r1 = new Reserva(nif, nombre, telefono, libro, ejemplares);
        if (numReservas<NMAX) {
            boolean encontrado = false;
            for (int i = 0; i < NMAX && lista[i]!=null && !encontrado; i++) {
                if(lista[i].equals(r1)){
                    encontrado = true;
                }
            } 
            if (!encontrado) {
                lista[numReservas]= r1;
                numReservas++;
            } else {
                throw new ElementoDuplicadoException();
            }
            
        } else {
            throw new ListaLlenaException();
        }
    }
    static class ListaLlenaException extends Exception{
        public ListaLlenaException(){
            super("Lista llena, no chuta maquinon");
        }
    }
    
    static class ElementoDuplicadoException extends Exception{
        public ElementoDuplicadoException(){
            super("Reserva ya inscrita en la lista");
        }
    }
}
