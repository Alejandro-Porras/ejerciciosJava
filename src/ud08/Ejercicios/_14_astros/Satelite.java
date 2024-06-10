package ud08.Ejercicios._14_astros;

public class Satelite extends Astro{
    private double distancia_al_planeta;
    private double orbita_planetaria;
    
    public Satelite(String nombre, double radio_ecuatorial, double rotacion_eje, double masa, double temperatura_media,
            double gravedad, double distancia_planeta, double orbita_planeta) {
        super(nombre, radio_ecuatorial, rotacion_eje, masa, temperatura_media, gravedad);
        this.distancia_al_planeta = distancia_planeta;
        this.orbita_planetaria = orbita_planeta;
    }

    public double getDistancia_al_planeta() {
        return distancia_al_planeta;
    }

    public void setDistancia_al_planeta(double distancia_al_planeta) {
        this.distancia_al_planeta = distancia_al_planeta;
    }

    public double getOrbita_planetaria() {
        return orbita_planetaria;
    }

    public void setOrbita_planetaria(double orbita_planetaria) {
        this.orbita_planetaria = orbita_planetaria;
    }

    @Override
    public String mostrarDatos() {
        return  "\n\tNombre-> " + this.nombre +
                "\n\tRadio ecuatorial-> " + this.radio_ecuatorial + 
                "\n\tRotacion eje-> " + this.rotacion_eje +
                "\n\tMasa-> " + this.masa +
                "\n\tTemperatura media-> " + this.temperatura_media +
                "\n\tGravedad-> " + this.gravedad +
                "\n\tDistancia al planeta-> " + this.distancia_al_planeta +
                "\n\tOrbita planetaria-> " + this.orbita_planetaria;
    }
}
