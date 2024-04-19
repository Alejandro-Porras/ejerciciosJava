package tests.ud06.serializable;

import java.io.Serializable;

public class OrdenadorCiber implements Serializable{
    private int codigoPc;
    transient private int horasJugadas;
    private int anyo;
    
    public int getcodigoPc() {
        return codigoPc;
    }
    public int getHorasJugadas() {
        return horasJugadas;
    }
    public int getAnyo() {
        return anyo;
    }

    public OrdenadorCiber(int codigoPc, int horasJugadas, int anyo) {
        this.codigoPc = codigoPc;
        this.horasJugadas = horasJugadas;
        this.anyo = anyo;
    }    
    @Override
    public String toString() {
        return codigoPc + " " + horasJugadas + " " + anyo + "";
    }
}
