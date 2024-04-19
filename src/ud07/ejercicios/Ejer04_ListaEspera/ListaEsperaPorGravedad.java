package ud07.ejercicios.Ejer04_ListaEspera;

import java.util.TreeSet;

public class ListaEsperaPorGravedad {
    TreeSet<Paciente> listaHospital;

    public ListaEsperaPorGravedad(TreeSet<Paciente> listaHospital) {
        this.listaHospital = new TreeSet<>();
    }

    public void anyadirPaciente(Paciente p){
        this.listaHospital.add(p);
    }

    public Paciente pacientePrioritario(){
        return listaHospital.last();
    }

    public void eliminarPrioritario(){
        listaHospital.removeLast();
    }
}
