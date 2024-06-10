package ud08.Ejercicios._09_supermercado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cereales implements EsAlimento{
    private String marca;
    private double precio;
    private String tipo;
    private LocalDate fechaCaducidad;

    public Cereales(String marca, double precio, String tipo) {
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo.toLowerCase().trim();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.toLowerCase().trim();
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
        int calorias = 0;
        switch (this.tipo) {
            case "espelta":
                calorias = 8;
                break;
            case "maíz":
                calorias = 8;
                break;
            case "trigo":
                calorias = 12;
                break;
            default:
                calorias = 15;
                break;
        }
        return calorias;
    }
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\n" + this.getClass().getSimpleName() +
                "\n\tMarca-> " + this.marca +
                "\n\tPrecio-> " + this.precio + 
                "\n\tTipo-> " + this.tipo + 
                "\n\tFecha de caducidad-> " + this.fechaCaducidad.format(dtf) +
                "\n\tCalorias-> " + this.getCalorias();
    }
}
