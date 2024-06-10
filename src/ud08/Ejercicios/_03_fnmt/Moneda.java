package ud08.Ejercicios._03_fnmt;

import java.time.LocalDate;

public class Moneda extends Dinero{
    private double diametro;
    private double peso;

    public Moneda(double valor, LocalDate fechaEmision, double diametro, double peso) {
        super(valor, fechaEmision);
        this.diametro = diametro;
        this.peso = peso;
    }

    @Override
    public String mostrarDatos() {
        
        return  "\nMoneda"+
                super.toString() +
                "\n\tDiametro -> " + this.diametro +
                "\n\tPeso -> " + this.peso;
    }
    
}
