package ud05._4reservasLibreria;

public class ListaReservas {
    private final int NMAX = 100;
    private Reserva[] lista;
    private int numReservas;
    
    public int getNumReservas() {
        return numReservas;
    }

    public ListaReservas(){
        this.lista = new Reserva[NMAX];
        this.numReservas = 0;
    }

    public void reservar(String nif, String nombre, String telefono, int libro, int
    ejemplares) throws ListaLlenaException, ElementoDuplicadoException{
        Reserva r1 = new Reserva(nif, nombre, telefono, libro, ejemplares);
        if (this.numReservas<NMAX) {
            boolean encontrado = false;
            for (int i = 0; i < NMAX && this.lista[i]!=null && !encontrado; i++) {
                if(this.lista[i].equals(r1)){
                    encontrado = true;
                }
            } 
            if (!encontrado) {
                this.lista[numReservas]= r1;
                this.numReservas++;
            } else {
                throw new ElementoDuplicadoException();
            }
            
        } else {
            throw new ListaLlenaException();
        }
    }
    public void reservar(Reserva r) throws ListaLlenaException, ElementoDuplicadoException{
        if (this.numReservas<NMAX) {
            boolean encontrado = false;
            for (int i = 0; i < NMAX && this.lista[i]!=null && !encontrado; i++) {
                if(this.lista[i].equals(r)){
                    encontrado = true;
                }
            } 
            if (!encontrado) {
                this.lista[numReservas]= r;
                this.numReservas++;
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

    public void cancelar(String nif, int libro) throws ElementoNoEncontradoException{
        boolean encontrado = false;
        int posicion = 0;
        for (int i = 0; i < NMAX && lista[i]!=null && !encontrado; i++) {
            if (this.lista[i].getNif().equals(nif) && this.lista[i].getCodigo()==libro) { //error en el equals
                posicion=i;
                encontrado = true;
            }
        }
        if (encontrado) {
            for (int i = posicion; i < NMAX-1 && this.lista[i]!=null; i++) {
                this.lista[i]=this.lista[i+1];
            }
            this.lista[NMAX-1]=null;
            this.numReservas--;
        }else{
            throw new ElementoNoEncontradoException();
        }
    }
    
    static class ElementoNoEncontradoException extends Exception{
        public ElementoNoEncontradoException(){
            super("No se ha encontrado la reserva.");
        }
    }

    @Override
    public String toString() {
        String str = "\nReservas (" + this.numReservas + ") :";
            for (int i = 0; i < NMAX && this.lista[i]!=null; i++) {
                str+="\n"+ (i+1)+ ") " + this.lista[i];
            }
        return str;
    }

    public int numEjemplaresReservadosLibro(int codigo){
        int sumaEjemplares = 0;

        for (int i = 0; i < NMAX && this.lista[i]!=null; i++) {
            if (lista[i].getCodigo()==codigo) {
                sumaEjemplares+=this.lista[i].getEjemplares();
            }
        }

        return sumaEjemplares;
    }

    public void reservasLibro(int codigo){
        String str = "Reservas de libros";
        for (int i = 0; i < NMAX && this.lista[i]!=null; i++) {
            if (this.lista[i].getCodigo()==codigo) {
                str+="\n"+ (i+1) + ") " + this.lista[i].getNombre() + " " + this.lista[i].getTel();
            }
        }
        System.out.println(str);
    }
}
