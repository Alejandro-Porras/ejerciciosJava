package programaMe.reto2;

import java.util.Scanner;

// import java.util.Scanner;

public class PD {

    public static int contar(String f1, String f2, String f3, char tipo){
        int devolver = 0;
        for (int i = 0; i < f1.length(); i++) {
            if (f1.charAt(i) == tipo || f2.charAt(i) == tipo || f3.charAt(i) == tipo) {
                devolver++;
            }
        }
        return devolver;
    }

    public static String comprobar(String f1, String f2, String f3){
        String devolver = "";
        int contX = 0;
        int contO = 0;
        // if (f1.matches("\[XO-\]")) {
            
        // }
        if (f1.length() == 3 && f2.length() == 3 && f3.length() == 3) {
            if (f2.charAt(1) == 'X' || f2.charAt(1) == 'O') {
                if (f2.charAt(1) == 'X') {
                    contX = contar(f1, f2, f3, 'X');
                    contO = contar(f1, f2, f3, 'O');
                    if (contX - contO >= 0 && contX - contO <2) {
                        devolver = "CRUZ";
                    } else {
                        devolver = "IMPOSIBLE";
                    }
                } else {
                    contX = contar(f1, f2, f3, 'X');
                    contO = contar(f1, f2, f3, 'O');
                    if (contO - contX >= 0 && contO - contX <2) {
                        devolver = "CIRCULO";
                    } else {
                        devolver = "IMPOSIBLE";
                    }
                }
            } else {
                devolver = "IMPOSIBLE";
            }
        } else {
            devolver = "IMPOSIBLE";
        }
        return devolver;
    }
    public static void main(String[] args) {
        String fila1, fila2, fila3;
        Scanner input = new Scanner(System.in);
        byte casosPrueba = input.nextByte();

        for (int i = 0; i < casosPrueba; i++) {
            fila1 = input.next();
            fila2 = input.next();
            fila3 = input.next();
        System.out.println(comprobar(fila1, fila2, fila3));
        }
        input.close();
    }
}