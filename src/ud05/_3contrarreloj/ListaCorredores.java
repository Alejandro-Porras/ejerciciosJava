package ud05._3contrarreloj;

public class ListaCorredores {
    private final static int NMAX = 200;
    private Corredor[] lista;
    private int numCorredores;

    public ListaCorredores(){
        this.lista = new Corredor[NMAX];
        this.numCorredores = 0;
    }

    public void anyadir(Corredor c) throws ElementoDuplicadoException{
        boolean encontrado=false;
        int i;
        for (i = 0; i < NMAX && !encontrado && this.lista[i]!=null; i++) {
            if (c.equals(this.lista[i])) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            this.lista[i]= c;
            this.numCorredores++;
        } else {
            throw new ElementoDuplicadoException();
        }
    }

    static class ElementoDuplicadoException extends Exception{
        public ElementoDuplicadoException(){
            super("Corredor ya inscrito en la lista");
        }
    }

    public void insertarOrdenado(Corredor c) throws ListaLlenaException{
        boolean encontrado =false;
        int i;
        if (numCorredores<NMAX) {
            for (i = 0; lista[i]!=null && !encontrado; i++) {
                if (c.getTiempo()<lista[i].getTiempo()) {
                    encontrado = true;
                }
            }
            for (int j = this.numCorredores; j > i+1; j--) {
                lista[j]=lista[j-1];
            }
            this.lista[i]=c;
            this.numCorredores++; //ARTUROOOOOOOOOOOOOOOOOOO!!!!!!!!!!!!! DECIR ARTURO :)))))))))))))))))))))) ESKIZOOOOOOOOOOOO
        } else {
            throw new ListaLlenaException();
        }
            
    }

    static class ListaLlenaException extends Exception{
        public ListaLlenaException(){
            super("Lista llena, no chuta maquinon");
        }
    }

    public Corredor quitar(int dorsal) throws ElementoNoEncontradoException{
        int pos= 0;
        Corredor corredorEliminado;
        boolean encontrado = false;
            for (int i = 0; i < NMAX && this.lista[i]!=null && !encontrado; i++) {
                if (this.lista[i].getDorsal()==dorsal) {
                    encontrado = true;
                    pos = i;
                }
            }
        if (encontrado) {
            corredorEliminado = this.lista[pos];

            for (int j = pos; j < NMAX-1 && this.lista[j]!=null; j++) {
                this.lista[j] = this.lista[j+1];
            }
            this.lista[NMAX-1]=null;
            this.numCorredores--;
        } else {
            throw new ElementoNoEncontradoException();
        }
        return corredorEliminado;
    }

    static class ElementoNoEncontradoException extends Exception{
        public ElementoNoEncontradoException(){
            super("No se ha encontrado al corredor.");
        }
    }

    @Override
    public String toString(){
        String str = "";
        for (int i = 0; i < NMAX && lista[i]!=null; i++) {
            str+= "\nPosicion: " + (i+1);
            str+="\n\tDorsal: " + this.lista[i].getDorsal();
            str+="\n\tNombre: " + this.lista[i].getNombre();
            str+="\n\tTiempo: " + (double)this.lista[i].getTiempo()/60 + " minutos";

        }
        return str;
    }
}
