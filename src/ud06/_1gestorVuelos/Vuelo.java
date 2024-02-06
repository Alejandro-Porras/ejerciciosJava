package ud06._1gestorVuelos;

import java.time.LocalTime;

public class Vuelo {
    private String identificador;
    private String origen;
    private String destino;
    private LocalTime hSalida;
    private LocalTime hLlegada;
    private String[] asiento;
    private int numP;

    public String getIdentificador() {
        return identificador;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public LocalTime gethSalida() {
        return hSalida;
    }

    public LocalTime gethLlegada() {
        return hLlegada;
    }

    public Vuelo(String id, String orig, String dest, LocalTime hsal, LocalTime hlleg){
        this.identificador=id;
        this.origen=orig;
        this.destino=dest;
        this.hSalida=hsal;
        this.hLlegada=hlleg;
        this.asiento= new String[51];
        this.numP=0;
    }

    // public Vuelo(String id, String orig, String dest, LocalTime hsal, LocalTime hlleg, int maxPasa){
    //     this.identificador=id;
    //     this.origen=orig;
    //     this.destino=dest;
    //     this.hSalida=hsal;
    //     this.hLlegada=hlleg;
    //     this.asiento= new String[maxPasa+1];
    //     this.numP=0;
    // }

    public boolean hayLibres(){
        return this.numP<this.asiento.length-1;
    }

    public boolean equals(Object o){
        if (this==o) {
            return true;
        }
        if (o==null) {
            return false;
        }
        if (this.getClass()!=o.getClass()) {
            return false;
        }
        Vuelo otro = (Vuelo) o;
        return this.getIdentificador().equals(otro.getIdentificador());
    }

    public int reservarAsiento(String pas, char prefe) throws VueloCompletoException, PreferenciaNoValidaException{
        int posi = 0;
        char pref = Character.toUpperCase(prefe);
        if (hayLibres()) {
            if (pref == 'V' || pref == 'P') {
                if (asientoLibre(pref)!=0) {
                    posi = asientoLibre(pref);
                    this.asiento[posi] = pas;
                    numP++;
                }else{
                    boolean encontrado = false;
                    for (int i = 1; i < this.asiento.length && !encontrado; i++) {
                        if (i%2==0&&this.asiento[i]==null) {
                            posi = i;
                            encontrado = true;
                        }
                    }
                    this.asiento[posi]=pas;
                    numP++;
                }
            }else{
                throw new PreferenciaNoValidaException();
            }
        }else{
            throw new VueloCompletoException();
        }
        return posi;
    }

    private int asientoLibre(char pref){
        int posi = 0;
        boolean encontrado = false;
            if (pref=='V') {
                for (int i = 1; i < this.asiento.length && !encontrado; i++) {
                    if (i%2!=0&&this.asiento[i]==null) {
                        posi = i;
                        encontrado = true;
                    }
                }
            }else if (pref=='P') {
                for (int i = 1; i < this.asiento.length && !encontrado; i++) {
                    if (i%2==0&&this.asiento[i]==null) {
                        posi = i;
                        encontrado = true;
                    }
                }
            }
        return posi;
    }

    static class VueloCompletoException extends Exception{
        public VueloCompletoException(){
            super("El vuelo esta completo");
        }
    }
    static class PreferenciaNoValidaException extends Exception{
        public PreferenciaNoValidaException(){
            super("La preferencia introducida no es valida");
        }
    }

    public void cancelarReserva(int numAsiento){
        this.asiento[numAsiento]=null;
    }

    @Override
    public String toString() {
        String str = this.identificador + " " + this.origen + " " + this.destino + " " 
        + this.hSalida + " " + this.hLlegada;
        str += "\nPasajeros: ";
            for (int i = 1; i < asiento.length; i++) {
                if (asiento[i]!=null) {
                    str += "\nAsiento " + i + ": " + this.asiento[i];
                } 
            }
        return str;
    }
}