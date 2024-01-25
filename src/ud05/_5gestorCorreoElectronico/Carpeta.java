package ud05._5gestorCorreoElectronico;

public class Carpeta {
    private final int NMAX = 100;
    private String nombre;
    private Mensaje[] lista;
    private int numMensajes;

    public Carpeta(String nombre){
        this.nombre=nombre;
        this.lista = new Mensaje[NMAX];
        this.numMensajes=0;
    }

    public void añadir(Mensaje m) throws ListaLlenaException, ElementoDuplicadoException{
        boolean encontrado = false;
        if (this.numMensajes<NMAX) {
            for (int i = 0; i < NMAX && !encontrado && lista[i]!=null; i++) {
                if (lista[i].equals(m)) {
                    encontrado=true;
                }
            }
            if (!encontrado) {
                this.lista[numMensajes]=m;
                numMensajes++;
            } else {
                throw new ElementoDuplicadoException();
            }
        }else{
            throw new ListaLlenaException();
        }
    }
    static class ListaLlenaException extends Exception{
        public ListaLlenaException(){
            super("ERROR! Lista llena, no chuta maquinon");
        }
    }
    
    static class ElementoDuplicadoException extends Exception{
        public ElementoDuplicadoException(){
            super("ERROR! Mensaje ya guardado en la lista");
        }
    }

    public void borrar(Mensaje m) throws ElementoNoEncontradoException{
        int posi = 0;
        boolean encontrado = false;
        for (int i = 0; i < NMAX && !encontrado && lista[i]!=null; i++) {
            if (lista[i].equals(m)) {
                encontrado = true;
                posi=i;
            }
        }
        if (encontrado) {
            for (int i = posi; i < NMAX-1 && lista[i]!=null; i++) {
                lista[i]=lista[i+1];
            }
            numMensajes--;
            lista[NMAX-1]=null;
        } else {
            throw new ElementoNoEncontradoException();
        }
    }

    public Mensaje buscar(int codigo) throws ElementoNoEncontradoException{
        int posi = 0;
        boolean encontrado = false;
        for (int i = 0; i < NMAX && !encontrado && lista[i]!=null; i++) {
            if (lista[i].getCodigo()==codigo) {
                encontrado = true;
                posi=i;
            }
        }
        if (!encontrado) {
            throw new ElementoNoEncontradoException();
        }
        return lista[posi];
    }

    static class ElementoNoEncontradoException extends Exception{
        public ElementoNoEncontradoException(){
            super("ERROR! No se ha encontrado el mensaje.");
        }
    }

    @Override
    public String toString() {
        String str = "\nCarpeta (" + this.nombre + ") :";
        str += "\nMensajes totales: " + this.numMensajes;

            for (int i = 0; i < NMAX && this.lista[i]!=null; i++) {
                str+="\n"+ this.lista[i];
            }

        return str;
    }

    public static void moverMensaje(Carpeta origen, Carpeta destino, int codigo)
    throws ElementoNoEncontradoException{
        Mensaje aux;
        aux=origen.buscar(codigo);
            try {
                destino.añadir(aux);
            } catch (ListaLlenaException | ElementoDuplicadoException e) {
                System.out.println(e.getMessage());
            }
            origen.borrar(aux);        
    }
}
