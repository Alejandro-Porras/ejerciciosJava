package ud05._2gestionHospital;

import ud05._2gestionHospital.Hospital.HospitalLlenoException;

public class GestorHospital {
    public static void main(String[] args) {
        Hospital h1 = new Hospital();

        try {
            h1.ingresarPaciente("Rafa", 19);
            h1.ingresarPaciente("Ismael", 19);
            h1.ingresarPaciente("Alex", 18);
            h1.ingresarPaciente("Miguel", 18);
            h1.ingresarPaciente("Marco", 18);
        } catch (HospitalLlenoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        while (h1.getNumLibres()<198) {
            h1.darAltas();
            System.out.println(h1.toString());
            System.out.println(h1.getNumLibres());
            System.out.println("-----------");
        }
    }
}
