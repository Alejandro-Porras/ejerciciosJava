package ud08.Ejercicios._03_fnmt;

import java.time.LocalDate;

public class Billete extends Dinero {
    private double altura;
    private double anchura;

    public Billete(double valor, LocalDate fechaEmision, double altura, double anchura) {
        super(valor, fechaEmision);
        this.altura = altura;
        this.anchura = anchura;
    }

    @Override
    public String mostrarDatos() {
        
        return "\nBillete"+ 
                super.toString() +
                "\n\tAltura -> " + this.altura +
                "\n\tAnchura -> " + this.anchura;
    }
}
