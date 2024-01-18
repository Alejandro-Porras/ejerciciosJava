package ud05._1gestionEmpleados;

import ud05._1gestionEmpleados.Empresa.ElementoNoEncontradoException;
import ud05._1gestionEmpleados.Empresa.PlantillaCompletaException;

public class TestEmpleado{
    public static void main(String[] args){
        Empresa empresa1 = new Empresa("CataDAW");
        // Empleado emple1 = new Empleado("Paco", "6192389M", 2010, 1000);
        // Empleado emple2 = new Empleado("Paco", "6192389M", 2010, 1000);
        
        // System.out.println(emple1.getAnyoIngreso());
        // System.out.println(emple1.antiguedad());

        // System.out.println(emple1.getSueldoBrutoAnual());
        // emple1.incrementarSueldo(10);
        // System.out.println(emple1.getSueldoBrutoAnual());
        // System.out.println(emple1.toString());
        // System.out.println(emple1.equals(emple2));
        // System.out.println(emple1.compareTo(emple2));
        // System.out.println(Empleado.calcularIRPF(1));

        Empleado e1 = new Empleado("Marco", "12345678X", 2020, 25000);
        Empleado e2 = new Empleado("Alex", "12345679Y", 2021, 25000);
        Empleado e3 = new Empleado("Miguel", "31231233M", 2023, 25000);
        Empleado e4 = new Empleado("Rafa", "54545454W", 2008, 25000);
        Empleado e5 = new Empleado("Arnau", "00000000W", 2021, 25000);
        Empleado e6 = new Empleado("Jorge", "32132367P", 2018, 25000);
        Empleado e7 = new Empleado("Omar", "09742234S", 2015, 25000);
        Empleado e8 = new Empleado("Alex", "31203123W", 2021, 25000);
        Empleado e9 = new Empleado("Enric", "31209383X", 2018, 25000);

        
            try {
                empresa1.contratar(e1);
                empresa1.contratar(e2);
                empresa1.contratar(e3);
                empresa1.contratar(e4);
                empresa1.contratar(e5);
                empresa1.contratar(e6);
                empresa1.contratar(e7);
                empresa1.contratar(e8);
                empresa1.contratar(e9);
            } catch (PlantillaCompletaException e) {
                System.out.println(e.getMessage());
            }

        empresa1.subirTrienio(10);

        try {
            empresa1.despedir(e9);
        } catch (ElementoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        

        System.out.println(empresa1.toString());
    }
}
