package ud08.Ejercicios._14_astros;

public abstract class Astro {
    protected String nombre;
    protected double radio_ecuatorial;
    protected double rotacion_eje;
    protected double masa;
    protected double temperatura_media;
    protected double gravedad;
    
    public Astro(String nombre, double radio_ecuatorial, double rotacion_eje, double masa, double temperatura_media,
            double gravedad) {
        this.nombre = nombre;
        this.radio_ecuatorial = radio_ecuatorial;
        this.rotacion_eje = rotacion_eje;
        this.masa = masa;
        this.temperatura_media = temperatura_media;
        this.gravedad = gravedad;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getRadio_ecuatorial() {
        return radio_ecuatorial;
    }
    public void setRadio_ecuatorial(double radio_ecuatorial) {
        this.radio_ecuatorial = radio_ecuatorial;
    }
    public double getRotacion_eje() {
        return rotacion_eje;
    }
    public void setRotacion_eje(double rotacion_eje) {
        this.rotacion_eje = rotacion_eje;
    }
    public double getMasa() {
        return masa;
    }
    public void setMasa(double masa) {
        this.masa = masa;
    }
    public double getTemperatura_media() {
        return temperatura_media;
    }
    public void setTemperatura_media(double temperatura_media) {
        this.temperatura_media = temperatura_media;
    }
    public double getGravedad() {
        return gravedad;
    }
    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }

    public abstract String mostrarDatos();

    @Override
    public String toString() {
        return "\nNombre-> " + this.nombre +
                "\nRadio ecuatorial-> " + this.radio_ecuatorial + 
                "\nRotacion eje-> " + this.rotacion_eje +
                "\nMasa-> " + this.masa +
                "\nTemperatura media-> " + this.temperatura_media +
                "\nGravedad-> " + this.gravedad;
    }
    
}
