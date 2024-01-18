package ud05._1gestionEmpleados;

import java.util.Calendar;
import java.util.Objects;

public class Empleado {
    private String nombre;
    private String dni;
    private int anyoIngreso;
    private double sueldoBrutoAnual;


    public Empleado (String nombre, String dni,
                    int anyoIngreso,double sueldoBrutoAnual){
        this.nombre=nombre;
        this.dni=dni;
        this.anyoIngreso=anyoIngreso;
        this.sueldoBrutoAnual=sueldoBrutoAnual;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getAnyoIngreso() {
        return anyoIngreso;
    }

    public double getSueldoBrutoAnual() {
        return sueldoBrutoAnual;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setAnyoIngreso(int anyoIngreso) {
        this.anyoIngreso = anyoIngreso;
    }

    public void setSueldoBrutoAnual(double sueldoBrutoAnual) {
        this.sueldoBrutoAnual = sueldoBrutoAnual;
    }

    public int antiguedad(){
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);
        return añoActual-getAnyoIngreso()>=0?añoActual-getAnyoIngreso():0;
    }

    public void incrementarSueldo(double porcentaje){
        //setSueldoBrutoAnual(getSueldoBrutoAnual()+(getSueldoBrutoAnual()*porcentaje/100));
        setSueldoBrutoAnual(getSueldoBrutoAnual()*(1+porcentaje/100));
    }

    public String toString(){
        return "\nNombre: \r\t\t\t" + getNombre() +
                "\nDNI: \r\t\t\t" + getDni() +
                "\nAño de ingreso: \r\t\t\t" + getAnyoIngreso() +
                "\nSueldo bruto anual: \r\t\t\t" + getSueldoBrutoAnual();
    }

    public boolean equals(Object o){
        if (this==o) {
            return true;
        }
        if (o==null) {
            return false;
        } 
        if (this.getClass()!=o.getClass()){
            return false;
        }
        final Empleado other = (Empleado) o;
        return Objects.equals(this.dni, other.dni);
    }

    public int compareTo(Empleado o){
        return this.getDni().compareTo(o.getDni());
    }

    public static double calcularIRPF(double salario){
        int irpf;
        if (salario>=0 && salario<800) {
            irpf = 3;
        } else if (salario>=800 && salario<100) {
            irpf = 10;
        } else if (salario>=1000 && salario<1500) {
            irpf = 15;
        } else if (salario>=1500 && salario<2100) {
            irpf = 20;
        } else {
            irpf = 30;
        }

        return salario*irpf/100;
    }
}
