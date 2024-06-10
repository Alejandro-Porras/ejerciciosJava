package ud08.Ejercicios._14_astros;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAstro {
    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Planeta> planetas = new ArrayList<>();

    public static void menu() {
        int respuesta;
        do {
            System.out.println("MENU" + 
                                "\n1-Introducir astro" + 
                                "\n2-Eliminar astro" +
                                "\n3-Mostrar planetas" +
                                "\n4-Mostrar satelites" + 
                                "\n5-Salir");
            respuesta = entrada.nextInt();
            switch (respuesta) {
                case 1:
                    anyadirAstro();
                    break;
                case 2:
                    eliminarAstro();
                    break;
                case 3:
                    mostrarPlanetas();
                    break;
                case 4:
                    mostrarSatelites();
                    break;
                case 5:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("La opcion introducida no es valida.");
                    break;
            }
            System.out.println("Pulse enter para continuar: ");
            entrada.nextLine();
            entrada.nextLine();
            limpiarConsola();
        } while (respuesta != 5);
    }

    public static void anyadirAstro() {
        int respuesta;
        do {
            System.out.println("\n1-Añadir planeta." + "\n2-Añadir satelite." + "\n3-Salir");
            respuesta = entrada.nextInt();
            switch (respuesta) {
                case 1:
                    anyadirPlaneta();
                    break;
                case 2:
                    anyadirSatelite();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("La opcion introducida no es valida.");
                    break;
            }
        } while (respuesta != 3);
    }

    public static void anyadirPlaneta() {
        entrada.nextLine();
        System.out.println("Introduce el nombre del planeta:");
        String nombre = entrada.nextLine();
        System.out.println("Introduce el radio ecuatorial del planeta:");
        double radio = entrada.nextDouble();
        System.out.println("Introduce la rotacion del eje del planeta:");
        double rotacion = entrada.nextDouble();
        System.out.println("Introduce la masa del planeta:");
        double masa = entrada.nextDouble();
        System.out.println("Introduce la temperatura media del planeta:");
        double temperatura = entrada.nextDouble();
        System.out.println("Introduce la gravedad del planeta:");
        double gravedad = entrada.nextDouble();
        System.out.println("Introduce la distancia al sol del planeta:");
        double distancia = entrada.nextDouble();
        System.out.println("Introduce la orbita al sol del planeta:");
        double orbita = entrada.nextDouble();
        Planeta planeta = new Planeta(nombre, radio, rotacion, masa, temperatura, gravedad, distancia, orbita);
        planetas.add(planeta);
        System.out.println("Planeta añadido correctamente.");
    }

    public static void anyadirSatelite() {
        entrada.nextLine();
        System.out.println("Introduce el nombre del satelite:");
        String nombre = entrada.nextLine();
        System.out.println("Introduce el radio ecuatorial del satelite:");
        double radio = entrada.nextDouble();
        System.out.println("Introduce la rotacion del eje del satelite:");
        double rotacion = entrada.nextDouble();
        System.out.println("Introduce la masa del satelite:");
        double masa = entrada.nextDouble();
        System.out.println("Introduce la temperatura media del satelite:");
        double temperatura = entrada.nextDouble();
        System.out.println("Introduce la gravedad del satelite:");
        double gravedad = entrada.nextDouble();
        System.out.println("Introduce la distancia al planeta del satelite:");
        double distancia = entrada.nextDouble();
        System.out.println("Introduce la orbita planetaria del satelite:");
        double orbita = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Introduce el nombre del planeta al que pertenece el satelite:");
        String nombrePlaneta = entrada.nextLine();
        Planeta planeta = buscarPlaneta(nombrePlaneta);
        if (planeta != null) {
            Satelite satelite = new Satelite(nombre, radio, rotacion, masa, temperatura, gravedad, distancia, orbita);
            planeta.anyadirSatelite(satelite);
            System.out.println("satelite añadido correctamente al planeta " + nombrePlaneta);
        } else {
            System.out.println("No se ha encontrado el planeta especificado.");
        }
    }

    public static void eliminarAstro() {
        entrada.nextLine();
        System.out.println("¿Qué tipo de astro desea eliminar?" + 
                            "\n1-Planeta" +
                            "\n2-satelite");
        int tipo = entrada.nextInt();
        entrada.nextLine();

        switch (tipo) {
            case 1:
                System.out.println("Introduce el nombre del planeta que desea eliminar:");
                String nombrePlaneta = entrada.nextLine();
                Planeta planetaEliminar = buscarPlaneta(nombrePlaneta);
                if (planetaEliminar != null) {
                    planetas.remove(planetaEliminar);
                    System.out.println("Planeta eliminado correctamente.");
                } else {
                    System.out.println("No se ha encontrado el planeta especificado.");
                }
                break;
            case 2:
                System.out.println("Introduce el nombre del planeta al que pertenece el satelite:");
                String nombrePlanetaSatelite = entrada.nextLine();
                Planeta planetaSatelite = buscarPlaneta(nombrePlanetaSatelite);
                if (planetaSatelite != null) {
                    System.out.println("Introduce el nombre del satelite que desea eliminar:");
                    String nombreSatelite = entrada.nextLine();
                    ArrayList<Satelite> satelites = planetaSatelite.getListaSatelites();
                    for (Satelite satelite : satelites) {
                        if (satelite.getNombre().equalsIgnoreCase(nombreSatelite)) {
                            satelites.remove(satelite);
                            System.out.println("satelite eliminado correctamente.");
                            return;
                        }
                    }
                    System.out.println("No se ha encontrado el satelite especificado.");
                } else {
                    System.out.println("No se ha encontrado el planeta especificado.");
                }
                break;
            default:
                System.out.println("La opcion introducida no es valida.");
                break;
        }
    }

    public static void mostrarPlanetas() {
        System.out.println("PLANETAS:");
        for (Planeta planeta : planetas) {
            System.out.println(planeta.mostrarDatos());
        }
    }

    public static void mostrarSatelites() {
        entrada.nextLine();
        System.out.println("Introduce el nombre del planeta del que deseas ver los satelites:");
        String nombrePlaneta = entrada.nextLine();
        Planeta planeta = buscarPlaneta(nombrePlaneta);
        if (planeta != null) {
            ArrayList<Satelite> satelites = planeta.getListaSatelites();
            if (!satelites.isEmpty()) {
                System.out.println("satelites del planeta " + nombrePlaneta + ":");
                for (Satelite satelite : satelites) {
                    System.out.println(satelite.mostrarDatos());
                }
            } else {
                System.out.println("El planeta " + nombrePlaneta + " no tiene satelites.");
            }
        } else {
            System.out.println("No se ha encontrado el planeta especificado.");
        }
    }

    public static Planeta buscarPlaneta(String nombre) {
        for (Planeta planeta : planetas) {
            if (planeta.getNombre().equalsIgnoreCase(nombre)) {
                return planeta;
            }
        }
        return null;
    }

    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        menu();
    }
}
