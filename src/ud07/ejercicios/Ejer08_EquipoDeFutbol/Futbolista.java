package ud07.ejercicios.Ejer08_EquipoDeFutbol;

import java.util.ArrayList;
import java.util.Iterator;

public class Futbolista implements Deportista, Comparable<Futbolista>{
    private String nombre;
    private int edad;
    private Posicion pos;

    private int anyosProfesional;
    private ArrayList<String> listaEquipos;
    private int totalTrofeos;

    public enum Posicion{
        PORTERO("Portero", 2000, 3000), 
        DEFENSA("Defensa", 2500, 3500),
        CENTROCAMPISTA("Centrocampista", 3500, 4000),
        DELANTERO("Delantero", 4000, 5000);

        private final String nombrePos;
        private final double salaraioMinimo;
        private final double salaraioMaximo;

        private Posicion(String n, double sMin, double sMax){
            this.nombrePos = n;
            this.salaraioMinimo = sMin;
            this.salaraioMaximo = sMax;
        }
        public String getNombrePos() {
            return nombrePos;
        }
        public double getSalaraioMinimo() {
            return salaraioMinimo;
        }
        public double getSalaraioMaximo() {
            return salaraioMaximo;
        }
    }

    public Futbolista(String nombre, int edad, Posicion pos) {
        this.nombre = nombre;
        this.edad = edad;
        this.pos = pos;
        this.anyosProfesional = 0;
        this.totalTrofeos = 0;
        this.listaEquipos = new ArrayList<>();
    }

    public Futbolista(String nombre, int edad, Posicion pos, int anyosProfesional, int totalTrofeos) {
        this.nombre = nombre;
        this.edad = edad;
        this.pos = pos;
        this.anyosProfesional = anyosProfesional;
        this.totalTrofeos = totalTrofeos;
        this.listaEquipos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public Posicion getPosicion() {
        return pos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setPosicion(Posicion posi){
        this.pos = posi;
    }
    public void agregarEquipo(String equipo){
        listaEquipos.add(equipo);
    }

    @Override
    public String toString() {
        return String.format("Nombre: %-15s | Edad: %-15d | Posicion: %-15s"
        , getNombre(), getEdad(), getPosicion().getNombrePos());
    }

    public String todaInformacion(){
        String str = "";
        if (this.listaEquipos.size()>=3) {
            for (int i = listaEquipos.size()-3; i < listaEquipos.size()-1; i++) {
                str += listaEquipos.get(i) + " - ";
            }
            str += listaEquipos.get(listaEquipos.size()-1);
        }else{
            Iterator<String> it = listaEquipos.iterator();

            while (it.hasNext()) {
                str += it.next();
                if (it.hasNext()) {
                    str += " - " ;
                }
            }
        }

        return String.format("| Nombre: %-15s | Edad: %-15d | Posicion: %-15s | Equipos: %-40s |"
        , getNombre(), getEdad(), getPosicion().getNombrePos(), str);
    }


    @Override
    public int getAnyosProfesional() {
        return this.anyosProfesional;
        // throw new UnsupportedOperationException("Unimplemented method 'getAnyosProfesional'");
    }

    @Override
    public ArrayList<String> getListadoEquipos() {
        return new ArrayList<>(this.listaEquipos    );
        // throw new UnsupportedOperationException("Unimplemented method 'getListadoEquipos'");
    }

    @Override
    public int getTotalTrofeos() {
        return this.totalTrofeos; 
        // throw new UnsupportedOperationException("Unimplemented method 'getTotalTrofeos'");
    }

    private int ordenPosicion(Posicion pos){
        switch (pos) {
            case PORTERO:
                return 1;
            case DEFENSA:
                return 2;
            case CENTROCAMPISTA:
                return 3;
            case DELANTERO:
                return 4;
        }
        return 0;
    }

    @Override
    public int compareTo(Futbolista o) {
        if (ordenPosicion(this.getPosicion())-ordenPosicion(o.getPosicion())==0) {
            return this.getNombre().compareTo(o.getNombre());
        } else {
            return ordenPosicion(this.getPosicion())-ordenPosicion(o.getPosicion());
        }
    }
}
