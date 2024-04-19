package tests.ud06.serializable;

import java.io.Serializable;

public class CreacionCiber implements Serializable{
    private int codigoCiber;
    private transient String nombre;
    private String zona;
    private OrdenadorCiber pc;

    public int getCodigoCiber() {
        return codigoCiber;
    }
    public String getNombre() {
        return nombre;
    }
    public String getZona() {
        return zona;
    }
    public OrdenadorCiber getPc() {
        return pc;
    }

    public CreacionCiber(int codigoCiber, String nombre, String zona, OrdenadorCiber pc){
        this.codigoCiber=codigoCiber;
        this.nombre=nombre;
        this.zona=zona;
        this.pc=pc;
    }

    @Override
    public String toString() {
        return codigoCiber + " " + nombre + " " + zona + "\n" + pc;
    }
}
