package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcularConCSV {
    public static Scanner entrada = new Scanner(System.in);

    public static void menu(){
        limpiarPantalla();
        int opcion = 0;
        do{
        System.out.println("---------HORAS REALIZADAS EN EL PROYECTO---------");
        System.out.println("Equipos:");
        System.out.println("1-HTML");
        System.out.println("2-JavaScript");
        System.out.println("3-CSS");
        System.out.println("4-Salir");
        opcion = entrada.nextInt();
            entrada.nextLine();
            limpiarPantalla();
            switch (opcion) {
                case 1:
                    mostrarDatosHTML();
                    break;
                case 2:
                    mostrarDatosJS();
                    break;
                case 3:
                    mostrarDatosCSS();
                    break;
                case 4:
                    System.out.println("ADIOOOS");
                    break;
            
                default:
                    System.out.println("Numero de opcion incorrecto, intenteló de nuevo.");
                    break;
            }
            pulseParaContinuar();
            limpiarPantalla();
        } while (opcion!=4);
    }

    public static void mostrarDatosHTML(){
        List<String[]> listaCSV = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/tests/Jira1.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineItems = line.split(",");
                listaCSV.add(lineItems);
            }
            br.close();
        }
        catch(Exception e){
            // Handle any I/O problems
        }
        listaCSV.remove(0);
        double total = 0;
        double parcialAlex = 0;
        double parcialArnau = 0;
        double parcialAMachi = 0;
        // Nombre1: Arnau Barberà Gonzàlez, aMachi, Alejandro Porras Sánchez
        for (String[] strings : listaCSV) {
            if (strings[35]!="" && strings[4].equals("Finalizada")) {
                total += (Double.parseDouble(strings[35])/60)/60;
                if (strings[13].equals("Alejandro Porras Sánchez")) {
                    parcialAlex += (Double.parseDouble(strings[35])/60)/60;
                }
                if (strings[13].equals("Arnau Barberà Gonzàlez")) {
                    parcialArnau += (Double.parseDouble(strings[35])/60)/60;
                }
                if (strings[13].equals("aMachi")) {
                    parcialAMachi += (Double.parseDouble(strings[35])/60)/60;
                }
            }
        }
        System.out.println("HTML");
        System.out.printf("Total           -> %-6.2f horas\n\n", total);
        System.out.printf("Parcial Alex    -> %-6.2f horas\n", parcialAlex);
        System.out.printf("Parcial Arnau   -> %-6.2f horas\n", parcialArnau);
        System.out.printf("Parcial AMachi  -> %-6.2f horas\n", parcialAMachi);
    }

    public static void mostrarDatosJS(){
        List<String[]> listaCSV = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/tests/Jira2.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineItems = line.split(",");
                listaCSV.add(lineItems);
            }
            br.close();
        }
        catch(Exception e){
            // Handle any I/O problems
        }
        listaCSV.remove(0);
        double total = 0;
        double parcialMarco = 0;
        double parcialEnric = 0;
        double parcialNico = 0;
        double parcialMiguel = 0;
        // Nombre2: Marco Antonio, Enric Mut Rosell, Nicolás Pérez Gutiérrez, Miguel Del Valle Aspas
        for (String[] strings : listaCSV) {
            if (strings[36]!="" && strings[4].equals("Finalizada")) {
                total += (Double.parseDouble(strings[36])/60)/60;
                if (strings[13].equals("Marco Antonio")) {
                    parcialMarco += (Double.parseDouble(strings[36])/60)/60;
                }
                if (strings[13].equals("Enric Mut Rosell")) {
                    parcialEnric += (Double.parseDouble(strings[36])/60)/60;
                }
                if (strings[13].equals("Nicolás Pérez Gutiérrez")) {
                    parcialNico += (Double.parseDouble(strings[36])/60)/60;
                }
                if (strings[13].equals("Miguel Del Valle Aspas")) {
                    parcialMiguel += (Double.parseDouble(strings[36])/60)/60;
                }
            }
        }
        System.out.println("JavaScript");
        System.out.printf("Total           -> %-6.2f horas\n\n", total);
        System.out.printf("Parcial Marco   -> %-6.2f horas\n", parcialMarco);
        System.out.printf("Parcial Enric   -> %-6.2f horas\n", parcialEnric);
        System.out.printf("Parcial Nicolas -> %-6.2f horas\n", parcialNico);
        System.out.printf("Parcial Miguel  -> %-6.2f horas\n", parcialMiguel);
    }

    public static void mostrarDatosCSS(){
        List<String[]> listaCSV = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/tests/Jira3.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineItems = line.split(",");
                listaCSV.add(lineItems);
            }
            br.close();
        }
        catch(Exception e){
            // Handle any I/O problems
        }
        listaCSV.remove(0);
        double total = 0;
        double parcialIsma = 0;
        double parcialJorge = 0;
        double parcialOmar = 0;
        // Nombre3: Ismael Garcia Grao, Jorge Martínez Llorens, Omar Molero Gimeno
        for (String[] strings : listaCSV) {
            if (strings[37]!="" && strings[4].equals("Finalizada")) {
                total += (Double.parseDouble(strings[37])/60)/60;
                if (strings[13].equals("Ismael Garcia Grao")) {
                    parcialIsma += (Double.parseDouble(strings[37])/60)/60;
                }
                if (strings[13].equals("Jorge Martínez Llorens")) {
                    parcialJorge += (Double.parseDouble(strings[37])/60)/60;
                }
                if (strings[13].equals("Omar Molero Gimeno")) {
                    parcialOmar += (Double.parseDouble(strings[37])/60)/60;
                }
            }
        }
        System.out.println("HTML");
        System.out.printf("Total           -> %-6.2f horas\n\n", total);
        System.out.printf("Parcial Ismael  -> %-6.2f horas\n", parcialIsma);
        System.out.printf("Parcial Jorge   -> %-6.2f horas\n", parcialJorge);
        System.out.printf("Parcial Omar    -> %-6.2f horas\n", parcialOmar);
    }

    public static void limpiarPantalla(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void pulseParaContinuar(){
        System.out.println("Pulse enter para continuar: ");
        entrada.nextLine();
    }
    public static void main(String[] args) {
        menu();
    }
}
