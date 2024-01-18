package ud03;

import java.util.Scanner;

public class Ejercicio20 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String x;
        int y;

        System.out.print("Introduzca x: ");
        x = entrada.next();

        System.out.print("Introduzca y: ");
        y = entrada.nextInt();
        
        String a;
        String b;

        a = (y%2==1)?"VALIDO":"NO VALIDO";
        b = (y%2==0)?"VALIDO":"NO VALIDO";
        
        System.out.println((x.equals("a"))?a:b);

        entrada.close();
    }
}
