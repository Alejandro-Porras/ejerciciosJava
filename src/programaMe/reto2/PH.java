package programaMe.reto2;

import java.util.Scanner;

public class PH {
    public static void mostrarArray(int[][] tablero){
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("\u001B[31m"+tablero[i][j] + "\u001B[0m ");
                }else if (tablero[i][j] == 2) {
                    System.out.print("\u001B[34m"+tablero[i][j] + "\u001B[0m ");
                } else if (tablero[i][j] == 3) {
                    System.out.print("\u001B[33m"+tablero[i][j] + "\u001B[0m ");
                }else{
                    System.out.print(tablero[i][j] + " ");
                } 
            }
            System.out.println();
        }
    }

    public static boolean calculoTablero(int[] tablero, int[] robot, int[] tesoro, int[][] celdas){
        int[][] tableroRelleno =new int[tablero[0]][tablero[1]];

        int[] robotMovil = robot;

        tableroRelleno[robotMovil[0]][robotMovil[1]] = 2;
        tableroRelleno[tesoro[0]][tesoro[1]] = 3;
        
        for (int i = 0; i < celdas.length; i++) {
            tableroRelleno[celdas[i][0]][celdas[i][1]] = 1;
        }

        for (int i = 0; i < tableroRelleno.length; i++) {
            for (int j = 0; j < tableroRelleno[i].length; j++) {
                if (j==0 || j==tableroRelleno[i].length-1) {
                    tableroRelleno[i][j]=1;
                }
                if (i==0 || i==tableroRelleno[i].length-1) {
                    tableroRelleno[i][j]=1;
                }
            }
        }

        boolean encontrado = false;
        boolean utilizado = false;

        

        while (!encontrado) {
            
            // Comprueba si el cofre esta rodeado (una unica vez por programa)
            if (!utilizado) {
                if (tableroRelleno[tesoro[0]-1][tesoro[1]] == 1 && 
                    tableroRelleno[tesoro[0]+1][tesoro[1]] == 1 && 
                    tableroRelleno[tesoro[0]][tesoro[1]-1] == 1 && 
                    tableroRelleno[tesoro[0]][tesoro[1]+1] == 1) {
                    return false;
                }
            }
            utilizado = true;
            boolean encerrado = false;

            while (!encerrado) {
                mostrarArray(tableroRelleno);
                // Comprueba si el robot esta rodeado
                if (tableroRelleno[robotMovil[0]-1][robotMovil[1]] == 1 && 
                    tableroRelleno[robotMovil[0]+1][robotMovil[1]] == 1 && 
                    tableroRelleno[robotMovil[0]][robotMovil[1]-1] == 1 && 
                    tableroRelleno[robotMovil[0]][robotMovil[1]+1] == 1) {
                    return false;
                }else if (  tableroRelleno[robotMovil[0]-1][robotMovil[1]] == 3 || 
                            tableroRelleno[robotMovil[0]+1][robotMovil[1]] == 3 || 
                            tableroRelleno[robotMovil[0]][robotMovil[1]-1] == 3 || 
                            tableroRelleno[robotMovil[0]][robotMovil[1]+1] == 3) {
                    return true;
                }
                // Derecha
                if (robotMovil[0] <= tesoro[0] && tableroRelleno[robotMovil[0]+1][robotMovil[1]] != 1) {
                    tableroRelleno[robotMovil[0]][robotMovil[1]] = 0;
                    robotMovil[0]++;
                    tableroRelleno[robotMovil[0]][robotMovil[1]] = 2;
                // Izquierda
                }else if (robotMovil[0] > tesoro[0] && robotMovil[0]-1 != 1) {
                    tableroRelleno[robotMovil[0]][robotMovil[1]] = 0;
                    robotMovil[0]--;
                    tableroRelleno[robotMovil[0]][robotMovil[1]] = 2;
                // Abajo
                } else if (robotMovil[1] <= tesoro[1] && robotMovil[1]+1 != 1) {
                    tableroRelleno[robotMovil[0]][robotMovil[1]] = 0;
                    robotMovil[1]++;
                    tableroRelleno[robotMovil[0]][robotMovil[1]] = 2;
                // Arriba
                }else if (robotMovil[1] > tesoro[1] && robotMovil[1]-1 != 1) {
                    tableroRelleno[robotMovil[0]][robotMovil[1]] = 0;
                    robotMovil[1]--;
                    tableroRelleno[robotMovil[0]][robotMovil[1]] = 2;
                }
            }


        }
        return true;
    } 
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // String textoTablero = entrada.nextLine();
        // String[] arrayTablero = textoTablero.split(" ");
        // int[] tablero = {Integer.parseInt(arrayTablero[0])+2,Integer.parseInt(arrayTablero[1])+2};

        int[] tablero = {5+2,5+2};

        // String textoRobot = entrada.nextLine();
        // String[] arrayRobot = textoRobot.split(" ");
        // int[] robot = {Integer.parseInt(arrayRobot[0]),Integer.parseInt(arrayRobot[1])};
        int[] robot = {1,1};

        // String textoTesoro = entrada.nextLine();
        // String[] arrayTesoro = textoTesoro.split(" ");
        // int[] tesoro = {Integer.parseInt(arrayTesoro[0]),Integer.parseInt(arrayTesoro[1])};
        int[] tesoro = {5,5};

        // int cantidadCeldas = entrada.nextInt();
        // entrada.nextLine();

        // int[][] celdas = new int[cantidadCeldas][2];
        // for (int i = 0; i < cantidadCeldas; i++) {
        //     String textoCeldas = entrada.nextLine();
        //     String[] arrayCeldas = textoCeldas.split(" ");
        //     celdas[i][0] = Integer.parseInt(arrayCeldas[0]);
        //     celdas[i][1] = Integer.parseInt(arrayCeldas[1]);
        // }

        int[][] celdas = {{1,2},{4,1}};

        if (calculoTablero(tablero, robot, tesoro, celdas)) {
            System.out.println("TESORO");
        } else {
            System.out.println("IMPOSIBLE");
        }

        entrada.close();
    }
}
