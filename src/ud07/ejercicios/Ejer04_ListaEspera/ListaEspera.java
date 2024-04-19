package ud07.ejercicios.Ejer04_ListaEspera;

import java.util.ArrayList;

public class ListaEspera {
    ArrayList<Paciente> listaHospital;

    public ListaEspera(ArrayList<Paciente> listaHospital) {
        this.listaHospital = new ArrayList<>();
    }

    public void anyadirPaciente(Paciente p){
        this.listaHospital.add(p);
    }

    public Paciente pacientePrioritario(){
        return listaHospital.get(0);
    }

    public void eliminarPrioritario(){
        listaHospital.remove(0);
    }
    
}
