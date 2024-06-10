package ud08.Ejercicios._10_facultad;

public class TestFacultad {
    public static void main(String[] args) {
        // Crear array de personas
        Persona[] personas = new Persona[5];

        // Crear instancias de las subclases y agregarlas al array
        personas[0] = new Estudiante("Juan", "Perez", "123456", "Soltero", "1º Curso");
        personas[1] = new Profesor("María", "González", "987654", "Casado", "Lenguajes");
        personas[2] = new Empleado("Carlos", "Gómez", "456789", "Casado", 2010, 101);
        personas[3] = new PersonalServicio("Laura", "Martínez", "654321", "Soltero", "Biblioteca");
        personas[4] = new Empleado("Ana", "Sánchez", "789123", "Soltero", 2015, 205);

        System.out.println("Antes del cambio:");
        for (Persona persona : personas) {
            System.out.println(persona);
        }

        System.out.println("\n--------------------");

        personas[0].cambiarEstadoCivil("Casado");

        ((Empleado)personas[2]).reasignarDespacho(102);

        ((Estudiante)personas[0]).matricularCurso("2º Curso");

        ((Profesor)personas[1]).cambiarDepartamento("Matemáticas");

        ((PersonalServicio)personas[3]).trasladarSeccion("Decanato");

        System.out.println("\nDespués del cambio:");

        for (Persona persona : personas) {
            System.out.println("\n" + persona);
        }

    }
}
