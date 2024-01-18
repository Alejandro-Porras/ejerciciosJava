package ud05._2gestionHospital;

import ud05._2gestionHospital.Paciente.MaximoEstadoException;

public class TestPaciente {
    public static void main(String[] args) {
    Paciente p1 = new Paciente("Antonio", 20);
    Paciente p2 = new Paciente("Miguel", 30);   
    
    System.out.println("___________ESTADOS PACIENTES___________");
    System.out.println(p1);
    System.out.println(p2);

        System.out.println(
            "El de menor estado es: " + (p1.compareTo(p2)<0?p1:p2)
        );

        while (p1.getEstado() != p2.getEstado()) {
            if (p1.getEstado() < p2.getEstado()) {
                try {
                    p1.mejorar();
                } catch (MaximoEstadoException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            } else {
                try {
                    p2.mejorar();
                } catch (MaximoEstadoException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }
        System.out.println("paciente1: " + p1);
        System.out.println("paciente2: " + p2);
    }
}
