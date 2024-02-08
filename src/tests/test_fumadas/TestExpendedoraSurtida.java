package tests.test_fumadas;

import java.util.Scanner;

import tests.test_fumadas.ExpendedoraSurtido.CreditoInsuficienteException;
import tests.test_fumadas.ExpendedoraSurtido.NoHayCambioException;
import tests.test_fumadas.ExpendedoraSurtido.NoHayProductoException;
import tests.test_fumadas.Surtido.RangoInvalidoException;

public class TestExpendedoraSurtida {

    public static String menuExpen(String user){
        String str = "Usuario: " + user + "\n";
        str += "*********************************" + "\n";
        str += "*\t" + "\u001B[35m" + "\u001B[1m" + "    EXPENDEDORA" + "\u001B[0m" + "\t\t*" + "\n";
        str += "*\t" + "1. Introducir dinero" + "\t*" + "\n";
        str += "*\t" + "2. Comprar producto" + "\t*" + "\n";
        str += "*\t" + "3. Devolver dinero" + "\t*" + "\n";
        str += "*\t" + "4. Mostrar productos" + "\t*" + "\n";
        str += "*\t" + "5. Salir" + "\t\t*" + "\n";
        str += "*********************************" + "\n";
        return str;
    }
    public static String menuAdmin(String user){
        String str = "";
        if (user.equals("alex")) {
            str = "Usuario: " + "\u001B[31m" + "\u001B[4m" + user + "\u001B[0m" + "\n";
        } else {
            str = "Usuario: " + "\u001B[32m" + "\u001B[4m" + user + "\u001B[0m" + "\n";
        }
        str += "*********************************" + "\n";
        str += "*\t" + "\u001B[35m" + "\u001B[1m" + "    EXPENDEDORA" + "\u001B[0m" + "\t\t*" + "\n";
        str += "*\t" + "1. Ver recaudacion" + "\t*" + "\n";
        str += "*\t" + "2. Ver cambio" + "\t\t*" + "\n";
        str += "*\t" + "3. Insertar Cambio" + "\t*" + "\n";
        str += "*\t" + "4. Salir" + "\t\t*" + "\n";
        str += "*********************************" + "\n";
        return str;
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        ExpendedoraSurtido expendedora1 = new ExpendedoraSurtido();
        int eleccion;
        String user;

        outerLoop: do {
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            System.out.print("Introduzca usuario o Salir: ");
            user = input.nextLine().toLowerCase();
            
            switch (user) {
                case "salir":
                    break outerLoop;
                case "alex":
                    //seguimos
                case "marco":
                    do {
                        System.out.print("\033[H\033[2J");  
                        System.out.flush(); 
                        System.out.println(menuAdmin(user));
                        eleccion = input.nextInt();
                        switch (eleccion) {
                            case 1:
                                System.out.println("La maquina tiene una recaudacion de: " + expendedora1.getRecaudacion());
                                System.out.println("\u001B[36m" +  "\u001B[1m" + "Regresando al menu...." + "\u001B[0m");
                                Thread.sleep(1000*2);
                                break;
                            case 2:
                                System.out.println("La maquina tiene un cambio de: " + expendedora1.getCambio());
                                System.out.println("\u001B[36m" +  "\u001B[1m" + "Regresando al menu...." + "\u001B[0m");
                                Thread.sleep(1000*2);
                                break;
                            case 3:
                                System.out.print("Introduce el cambio extra a la maquina: ");
                                double cambio = input.nextDouble();
                                expendedora1.setCambio(cambio);
                                System.out.println("\u001B[36m" +  "\u001B[1m" + "Regresando al menu...." + "\u001B[0m");
                                Thread.sleep(1000*2);
                                break;
                            default:
                                input.nextLine();
                                break;
                        }
                    } while (eleccion != 4);
                    break;
            
                default:
                do {
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    System.out.println(menuExpen(user));
                    eleccion = input.nextInt();
                    switch (eleccion) {
                        case 1:
                            System.out.print("Introduce el dinero a la maquina: ");
                            double dinero = input.nextDouble();
                            expendedora1.introducirDinero(dinero);
                            System.out.println("\u001B[36m" +  "\u001B[1m" + "Regresando al menu...." + "\u001B[0m");
                            Thread.sleep(1000*2);
                            break;
                        case 2:
                            System.out.print("Introduce el codigo de un producto para comprar: ");
                            int producto = input.nextInt();
                            
                            try {
                                expendedora1.comprarProducto(producto);
                                System.out.print("\033[H\033[2J");  
                                System.out.flush();
    
                                //Barra de carga
                                int totalIteraciones = 50;
                                for (int i = 0; i <= totalIteraciones; i++) {
                                    int progreso = (int) ((double) i / totalIteraciones * 100);
                                    System.out.print("\r[");
                                    for (int j = 0; j < totalIteraciones; j++) {
                                        if (j < i) {
                                            if (progreso < 50) {
                                                System.out.print("\u001B[31m█");
                                            } else if (progreso < 75) {
                                                System.out.print("\u001B[33m█");
                                            } else {
                                                System.out.print("\u001B[32m█");
                                            }
                                        } else {
                                            System.out.print(" ");
                                        }
                                    }
                                    System.out.print("] " + progreso + "%");
                                    Thread.sleep(100);
                                }
                                System.out.println();
                                System.out.println("Producto comprado :)");
                                System.out.println("\u001B[0m");
                            } catch (NoHayCambioException | NoHayProductoException | CreditoInsuficienteException
                                    | RangoInvalidoException e) {
                                        System.out.println(e.getMessage());
                            }
                                
                            
                            Thread.sleep(1000*2);
                            break;
                        case 3:
                            System.out.println("Tu devolucion fue de: " + expendedora1.solicitarDevolucion());
                            System.out.println("\u001B[36m" +  "\u001B[1m" + "Regresando al menu...." + "\u001B[0m");
                            Thread.sleep(1000*2);
                            break;
                    
                        case 4:
                            System.out.println(expendedora1.toStringSurtido());
                            System.out.println("\u001B[36m" +  "\u001B[1m" + "Regresando al menu...." + "\u001B[0m");
                            Thread.sleep(1000*5);
                            
                            break;
                    
                        default:
                            input.nextLine();
                            break;
                    }
                } while (eleccion != 5);
                break;
            }
        } while (true);
        input.close();
    }
}
