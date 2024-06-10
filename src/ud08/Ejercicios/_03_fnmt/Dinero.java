package ud08.Ejercicios._03_fnmt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Dinero {
    protected double valor;
    protected LocalDate fechaEmision;

    public Dinero(double valor, LocalDate fechaEmision) {
        this.valor = valor;
        this.fechaEmision = fechaEmision;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Dinero money = (Dinero) obj;
        return this.fechaEmision.equals(money.fechaEmision) && 
                this.valor == money.valor;
    }

    public int compareTo(Object o){
        Dinero money = (Dinero) o;
        int devolucion = this.fechaEmision.getYear()-money.fechaEmision.getYear();
        if (devolucion == 0) {
            if (this.valor == money.valor) {
                devolucion = 0;
            }else if (this.valor > money.valor) {
                devolucion = 1;
            } else {
                devolucion = -1;
            }
        }
        return devolucion;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\n\tValor -> " + this.valor +
                "\n\tFecha emision -> " + this.fechaEmision.format(dtf);
    }

    public abstract String mostrarDatos();
}
