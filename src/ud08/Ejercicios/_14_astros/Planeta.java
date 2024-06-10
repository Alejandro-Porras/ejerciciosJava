package ud08.Ejercicios._14_astros;

import java.util.ArrayList;

public class Planeta extends Astro{

    private double distancia_al_sol;
    private double orbita_al_sol;
    private ArrayList<Satelite> listaSatelites;

    public Planeta(String nombre, double radio_ecuatorial, double rotacion_eje, double masa, double temperatura_media,
            double gravedad, double distancia_sol, double orbita_sol) {
        super(nombre, radio_ecuatorial, rotacion_eje, masa, temperatura_media, gravedad);
        this.distancia_al_sol=distancia_sol;
        this.orbita_al_sol=orbita_sol;
        this.listaSatelites=new ArrayList<>();
    }

    public double getDistancia_al_sol() {
        return distancia_al_sol;
    }

    public void setDistancia_al_sol(double distancia_al_sol) {
        this.distancia_al_sol = distancia_al_sol;
    }

    public double getOrbita_al_sol() {
        return orbita_al_sol;
    }

    public void setOrbita_al_sol(double orbita_al_sol) {
        this.orbita_al_sol = orbita_al_sol;
    }
    
    public ArrayList<Satelite> getListaSatelites() {
        return listaSatelites;
    }

    public void setListaSatelites(ArrayList<Satelite> listaSatelites) {
        this.listaSatelites = listaSatelites;
    }

    public void anyadirSatelite(Satelite item){
        listaSatelites.add(item);
    }

    @Override
    public String mostrarDatos() {
        String str = super.toString() +
                    "\nDistancia al sol-> " + this.distancia_al_sol +
                    "\nOrbita al sol-> " + this.orbita_al_sol +
                    "\nSATELITES:";
        
        for (Satelite satelite : listaSatelites) {
            str+=satelite;
        }
        return str;
    }
}
