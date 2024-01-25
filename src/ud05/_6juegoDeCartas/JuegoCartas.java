package ud05._6juegoDeCartas;

import java.util.Scanner;

public class JuegoCartas {
    public static int ganadora( Carta c1, Carta c2, int triunfo){
        //si son iguales
        if (c1.equals(c2)) {
            return 0;
        }
        //compara las opciones con el mismo palo
        if (c1.getPalos()==c2.getPalos()) {
            if (c1.getValor()==1) {
                return 1;
            }
            if (c2.getValor()==1) {
                return -1;
            }
            if (c1.getValor()!=1&&c2.getValor()!=1) {
                return c1.compareTo(c2) > 0 ? 1 : -1;
            }
        }
        //si c1 es el palo del triunfo 
        if (c1.getPalos()==triunfo&&c2.getPalos()!=triunfo) {
            return 1;
        }
        //si c2 es el palo del triunfo
        if (c2.getPalos()==triunfo&&c1.getPalos()!=triunfo) {
            return -1;
        }
 
        //si ninguno es el palo :)
        if (c1.getPalos()!=triunfo&&c2.getPalos()!=triunfo) {
            // if (c1.getValor()==1) {
            //     return 1;
            // }
            // if (c2.getValor()==1) {
            //     return -1;
            // }
            //return c1.compareTo(c2) > 0 ? 1 : -1;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //creamos la carta aleatoria y la mostramos
        Carta c1 = new Carta();
        System.out.println(c1);

        //creamos el palo aleatorio y lo mostramos
        int paloWin =(int)(Math.random()*4);
        System.out.println(Carta.PALOS[paloWin] + paloWin);

        //creamos la carta por usuario
        //creamos el palo.
        // System.out.println("Inserte el palo(0 al 3): ");
        // int palo;
        // do {
        //     palo=entrada.nextInt();
        //     if (palo<0||palo>3) {
        //         System.out.println("Datos erroneos, inserte uno del 0 al 3");
        //     }
        // } while (palo<0||palo>3);

        //creamos el valor
        // System.out.println("Inserte el valor(1 al 12): ");
        // int valor;
        // do {
        //     valor=entrada.nextInt();
        //     if (valor<0||valor>12) {
        //         System.out.println("Datos erroneos, inserte uno del 1 al 12");
        //     }
        // } while (valor<1||valor>12);
        // //construimos la carta
        // Carta c2 = new Carta(palo, valor);
        Carta c2=null;
        boolean valido=false;
        do {
            //creamos el palo.
            int palo;
            System.out.println("Inserte el palo(0 al 3): ");
            palo=entrada.nextInt();
        //creamos el valor            
            int valor;
            System.out.println("Inserte el valor(1 al 12): ");
            valor=entrada.nextInt();
            
            try {
                c2 = new Carta(palo, valor);
                valido=true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                // System.out.println("ERROR! palo o valor no validos");
            }
        } while (!valido);
        

        //Y mostramos c2
        System.out.println(c2);
        
        //utilizamos el metodo ganadora
        if (ganadora(c1, c2, paloWin)>0) {
            System.out.println(c1+" es el ganador");
        } else if (ganadora(c1, c2, paloWin)<0) {
            System.out.println(c2+" es el ganador");
        } else {
            System.out.println("Empate");
        }
        entrada.close();
    }
}
