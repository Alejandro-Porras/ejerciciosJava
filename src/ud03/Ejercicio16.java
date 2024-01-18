package ud03;

import java.util.Scanner;

public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int precio;

        System.out.println("Introduzca el precio");
        precio=entrada.nextInt();

        System.out.println("\nImporte de la compra " + precio + " euros");
        System.out.println("Porcentaje de descuento aplicado: 8%");
        if ((precio*8/100)<=12) {
            System.out.println("Descuento aplicado: " + precio*8/100);
            System.out.println("Cantidad a pagar: " + (precio-(precio*8/100)));
        } else {
            System.out.println("Descuento aplicado: " + 12);
            System.out.println("Cantidad a pagar: " + (precio-(12)));
        }
        entrada.close();
    }
}
