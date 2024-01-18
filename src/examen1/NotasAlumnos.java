package examen1;

import java.util.Scanner;

public class NotasAlumnos {

    //Creamos el menu
    public static void menu(){ 
        int opcion;
        int aux;

        Scanner entrada = new Scanner(System.in);
        
        String[] alumnos = new String[15];
        int[][] calificaciones = new int [15][5];

        System.out.println("Menú de opciones\r\n" + //
                "----------------\r\n" + //
                "1) Generar calificaciones.\r\n" + //
                "2) Relación de estudiantes y sus notas.\r\n" + //
                "3) Número de ejercicios entregados por estudiante.\r\n" + //
                "4) Media de ejercicios entregados por estudiante.\r\n" + //
                "5) Número estudiantes que han entregado todos los ejercicios y tienen una media >= 5.\r\n" + //
                "6) Número estudiantes que han presentado un ejercicio dado.\r\n" + //
                "7) Dado número del ejercicio, mostrar nota media de estudiantes que lo presentaron.\r\n" + //
                "8) Dado número del ejercicio, mostrar la nota más alta obtenida.\r\n" + //
                "9) Dado número del ejercicio, mostrar la nota más baja obtenida.\r\n" + //
                "0) Finalizar.\r");
        do {
        System.out.print("\nIntroduce una opcion: ");
        opcion=entrada.nextInt();

        System.out.println();
            switch (opcion) {
                case 1:
                    generaCalificaciones(calificaciones);
                    generaNombres(alumnos);

                    System.out.println("Notas generadas aleatoriamente para todos los estudiantes.");
                    break;

                case 2:
                    if (alumnos[0]==null) {
                        System.out.println("Primero debe generar las calificaciones.");
                    } else {
                        mostrarNotas(alumnos, calificaciones);

                        System.out.println("\nPulse Intro para continuar...");
                        entrada.nextLine();
                        entrada.nextLine();
                   }
                    break;

                case 3:
                    if (alumnos[0]==null) {
                        System.out.println("Primero debe generar las calificaciones.");
                    } else {
                        System.out.println("Dame un número de estudiante (entre 1 y 15): ");
                        aux = (entrada.nextInt())-1;
                        System.out.println(alumnos[aux] + " ha entregado " + ejerciciosEntregados(alumnos, calificaciones, aux) +
                         " ejercicios");

                        System.out.println("\nPulse Intro para continuar...");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
                   
                    break;

                case 4:
                    if (alumnos[0]==null) {
                        System.out.println("Primero debe generar las calificaciones.");
                    } else {
                        System.out.println("Dame un número de estudiante (entre 1 y 15): ");
                        aux = (entrada.nextInt())-1;
                        System.out.println(alumnos[aux] + " tiene una media de " + mediaEjercicios(alumnos, calificaciones, aux));

                        System.out.println("\nPulse Intro para continuar...");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
                    break;

                case 5:
                    if (alumnos[0]==null) {
                        System.out.println("Primero debe generar las calificaciones.");
                    } else {
                        System.out.println(estudiantesEntreganTodoConNotaMayorA5(alumnos, calificaciones) + " estudiantes");

                        System.out.println("\nPulse Intro para continuar...");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
                    break;

                case 6:
                    if (alumnos[0]==null) {
                        System.out.println("Primero debe generar las calificaciones.");
                    } else {
                        System.out.println("Dame un número de ejercicio (entre 1 y 5): ");
                        aux = (entrada.nextInt())-1;
                        System.out.println(estudiantesEntregaEjercicio(calificaciones, aux) + " estudiantes.");

                        System.out.println("\nPulse Intro para continuar...");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
                    break;

                case 7:
                    if (alumnos[0]==null) {
                        System.out.println("Primero debe generar las calificaciones.");
                    } else {
                        System.out.println("Dame un número de ejercicio (entre 1 y 5): ");
                        aux = (entrada.nextInt())-1;
                        System.out.println("La media es " + estudiantesEntregaEjercicioMedia(calificaciones, aux));

                        System.out.println("\nPulse Intro para continuar...");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
                    break;

                case 8:
                    if (alumnos[0]==null) {
                        System.out.println("Primero debe generar las calificaciones.");
                    } else {
                        System.out.println("Dame un número de ejercicio (entre 1 y 5): ");
                        aux = (entrada.nextInt())-1;
                        System.out.println("La máxima nota es " + estudiantesEntregaEjercicioMax(calificaciones, aux));

                        System.out.println("\nPulse Intro para continuar...");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
                    break;

                case 9:
                    if (alumnos[0]==null) {
                        System.out.println("Primero debe generar las calificaciones.");
                    } else {
                        System.out.println("Dame un número de ejercicio (entre 1 y 5): ");
                        aux = (entrada.nextInt())-1;
                        System.out.println("La mínima nota es " + estudiantesEntregaEjercicioMin(calificaciones, aux));

                        System.out.println("\nPulse Intro para continuar...");
                        entrada.nextLine();
                        entrada.nextLine();
                    }
                    break;

                case 0:
                    System.out.println("Adios!");
                    break;

                default:
                    System.out.println("No has introducido una opcion correcta.");
                    break;
            }
        } while (opcion!=0);
        entrada.close();
    }

    //creamos el metodo que genera los nombres:
    public static void generaNombres(String alumnos[]){
        // array nombres con 50 elementos de tipo String
        String[] nombres = {"Alan", "Alicia", "Andrea", "Andrés", "Antonia",
                            "Antonio", "Celeste", "Gerardo", "Gustavo", "Jesús",
                            "Juan", "Julia", "Luisa", "Noelia", "Paula",
                            "David", "Ferran", "Cesar", "Josep", "Jesus",
                            "Brandon", "Fidel", "Diego", "Leonardo", "Raquel",
                            "Salvador", "Ivan", "Sebastian", "Edgar", "Christian",
                            "Carlos", "Rodrigo", "Patricia", "Rosario", "Zulema",
                            "Maria", "Jose", "Ana", "Isabel", "Laura",
                            "Manuel", "Javier", "Daniel", "Alfredo", "Raul",
                            "Esther", "Victoria", "Belen", "Estefania", "Miguel"
        };
        // array de apellidos con 50 elementos de tipo String
        String[] apellidos = {"Garcia", "Rodriguez", "Gonzalez", "Fernandez", "Lopez",
                              "Martinez", "Sanchez", "Perez", "Gomez", "Martin",
                              "Jimenez", "Hernandez", "Ruiz", "Diaz", "Moreno",
                              "Muñoz", "Alvarez", "Moreno", "Gutierrez", "Alonso",
                              "Navarro", "Torres", "Dominguez", "Vazquez", "Ramos",
                              "Ramirez", "Gil", "Serrano", "Molina", "Blanco",
                              "Morales", "Suarez", "Ortega", "Castro", "Delgado",
                              "Ortiz", "Marin", "Rubio", "Nuñez", "Sanz",
                              "Medina", "Iglesias", "Castillo", "Cortes", "Garrido",
                              "Guerrero", "Lozano", "Cano", "Mendez", "Cruz"
        };
    
        /* ESCRIBE AQUÍ EL CÓDIGO
         * a tener en cuenta:
         *  - generar aleatoriamente nombre y dos apellidos
         *  - tener en cuenta que son 50 elementos por array
         *  - concatenar nombre, apellido1 y apellido2
         */

        //generamos los nombres :
        for (int i = 0; i < alumnos.length; i++) {

            alumnos[i] = nombres[(int)Math.round(Math.random()*49)] + " " 
            + apellidos[(int)Math.round(Math.random()*49)] + " "
            + apellidos[(int)Math.round(Math.random()*49)];
        }
    }

    //Creamos el metodo que genera las notas: 
    public static void generaCalificaciones(int calificaciones [][]){
        for (int i = 0; i < calificaciones.length; i++) {
            for (int j = 0; j < calificaciones[0].length; j++) {
                calificaciones[i][j] = (int)Math.round(Math.random()*(10+1)-1);
            }
        }
    }

    //Creamos el metodo que mostrará las notas:
    public static void mostrarNotas(String alumnos[], int calificaciones [][]){
        System.out.println("\t\t\t\t\t1 2 3 4 5" + 
                            "\n\t\t\t\t\t---------------");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print((i+1) + ". " + alumnos[i]+"\r\t\t\t\t\t");
            for (int j = 0; j < calificaciones[0].length; j++) {
                System.out.print(calificaciones[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Creamos un metodo que mostrará cuantos ejercicios se han entregado
    public static int ejerciciosEntregados(String alumnos[], int calificaciones [][], int num){
        int cont = 0;
            for (int j = 0; j < calificaciones[0].length; j++) {
                if (calificaciones[num][j]>=0) {
                    cont++;
                }
            }
        return cont;
    }

    public static double mediaEjercicios(String alumnos[], int calificaciones [][], int num){
        double aux = 0;
            for (int j = 0; j < calificaciones[num].length; j++) {
                if (calificaciones[num][j]==(-1)) {
                }else{
                    aux+= calificaciones[num][j];
                }
            }
        
        return aux/ejerciciosEntregados(alumnos, calificaciones, num);
    }

    public static int estudiantesEntreganTodoConNotaMayorA5(String alumnos[], int calificaciones [][]){
        int cont=0;
        for (int i = 0; i < calificaciones.length; i++) {
                if (mediaEjercicios(alumnos, calificaciones, i)>=5 &&
                 ejerciciosEntregados(alumnos, calificaciones, i)==calificaciones[0].length) {
                    cont++;
            }
        }
        return cont;
    }

    public static int estudiantesEntregaEjercicio(int calificaciones [][], int num){
        int cont = 0;
        for (int i = 0; i < calificaciones.length; i++) {
                if (calificaciones[i][num]!=-1) {
                    cont++;
                }
        }
        return cont;
    }

    public static double estudiantesEntregaEjercicioMedia(int calificaciones [][], int num){
        int cont = 0;
        double aux = 0;
        for (int i = 0; i < calificaciones.length; i++) {
                if (calificaciones[i][num]!=-1) {
                    aux+= calificaciones[i][num];
                    cont++;
                }
        }
        return aux/cont;
    }

    public static int estudiantesEntregaEjercicioMax(int calificaciones [][], int num){
        int aux = calificaciones[0][num];
        for (int i = 0; i < calificaciones.length-1; i++) {
                if (aux<calificaciones[i+1][num]) {
                    aux = calificaciones[i+1][num];
                }
        }
        return aux;
    }

    public static int estudiantesEntregaEjercicioMin(int calificaciones [][], int num){
        int aux;
        if (calificaciones[0][num]!=-1 ) {
            aux=calificaciones[0][num];
        } else {
            aux=10;
        }
        for (int i = 0; i < calificaciones.length-1; i++) {
                if (aux>calificaciones[i+1][num] && calificaciones[i+1][num]!=-1) {
                    aux = calificaciones[i+1][num];
                }
        }
        return aux;
    }

    public static void main(String[] args) {
        menu();
    }
}