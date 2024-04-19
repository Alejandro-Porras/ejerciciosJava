package ud07.actividades.Actividad04_gestionpacientes;

import java.util.TreeSet;

public class GestionPacientes {
    public static void main(String[] args) {
        TreeSet<Pacientes> ficha = new TreeSet<>();

        ficha.add(new Pacientes("Paco", "Francisco", 19));
        ficha.add(new Pacientes("Enric", "Ferrando", 20));
        ficha.add(new Pacientes("Josue", "Espin", 18));

        System.out.println(ficha.toString());


        //se realiza mejor con el iterator con it.remove y ifs.
        ficha.remove(new Pacientes("Josue", "Espin", 18));

        System.out.println(ficha.toString());
    }
}
