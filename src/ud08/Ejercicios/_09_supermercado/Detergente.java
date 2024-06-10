package ud08.Ejercicios._09_supermercado;

public class Detergente implements ConDescuento, EsLiquido {
    private String marca;
    private double precio;
    private double volumen;
    private String envase;
    private double descuento;

    
    
    public Detergente(String marca, double precio) {
        this.marca = marca;
        this.precio = precio;
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
    public String toString() {
        return "\n" + this.getClass().getSimpleName() +
                "\n\tMarca-> " + this.marca +
                "\n\tPrecio-> " + this.precio + 
                "\n\tVolumen-> " + this.volumen + 
                "\n\tEnvase-> " + this.envase +
                "\n\tDescuento-> " + this.descuento + 
                "\n\tPrecio con descuento -> " + this.getPrecioDescuento();
    }
}
