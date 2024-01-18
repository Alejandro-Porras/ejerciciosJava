package test_v2.test;

import javax.swing.JOptionPane;

public class Pidonumero {
    public static void main(String[] args) {
        String texto;
        int num;
        do {
            texto=JOptionPane.showInputDialog("texto mensaje"); 
            num=Integer.parseInt(texto);
            System.out.println("El numero introducido es " + num);
        } while (num<1 || num>10);
    }
}
