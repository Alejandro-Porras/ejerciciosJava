package ud08.Ejercicios._09_supermercado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vino implements EsAlimento, EsLiquido, ConDescuento{
    private String marca;
    private String tipo;
    private double gradosAlcohol;
    private double precio;
    private double volumen;
    private String envase;
    private double descuento;
    private LocalDate fechaCaducidad;

    public Vino(String marca, String tipo, double gradosAlcohol, double precio) {
        this.marca = marca;
        this.tipo = tipo;
        this.gradosAlcohol = gradosAlcohol;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public void setVolumen(double v) {
        this.volumen = v;
    }

    @Override
    public double getVolumen() {
        return volumen;
    }

    @Override
    public void setTipoEnvase(String env) {
        this.envase = env;
    }

    @Override
    public String getTipoEnvase() {
        return envase;
    }

    @Override
    public void setDescuento(double des) {
        this.descuento = des;
    }

    @Override
    public double getDescuento() {
        return descuento;
    }

    @Override
    public double getPrecioDescuento() {
        return ((descuento*precio)/100)-precio ;
    }
    @Override
    public void setCaducidad(LocalDate fc) {
        fechaCaducidad = fc;
    }

    @Override
    public LocalDate getCaducidad() {
        return fechaCaducidad;
    }

    @Override
    public int getCalorias() {
        return (int) (gradosAlcohol*10);
    }
    
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\n" + this.getClass().getSimpleName() +
                "\n\tMarca-> " + this.marca +
                "\n\tPrecio-> " + this.precio + 
                "\n\tTipo-> " + this.tipo +    
                "\n\tFecha de caducidad-> " + this.fechaCaducidad.format(dtf) +
                "\n\tVolumen-> " + this.volumen + 
                "\n\tEnvase-> " + this.envase +
                "\n\tDescuento-> " + this.descuento + 
                "\n\tPrecio con descuento -> " + this.getPrecioDescuento() + 
                "\n\tCalorias-> " + this.getCalorias();
    }
}
