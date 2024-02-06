/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tests.test_v2;

/**
 *PruebaCuentaBancaria.java
 * 
 *[Creada el 8 nov 2023, 12:36:09
 *
 *Desarrollada por Mazinger z en la empresa el día 8 nov 2023
 *
 *Puede contactar conmigo en a@a.net.
 *
 * @Autor Mazinger z
 * @Versión 1.0.
 * @Fecha 8 nov 2023
 */
public class PruebaCuentaBancaria {
    public static void main(String args[]) {

        /* Create a new account with no balance */
        CuentaBancaria cuenta1 = new CuentaBancaria(1, "Miguel Pérez");

        /* Create a new account with non zero balance */
        CuentaBancaria cuenta2 = new CuentaBancaria(2, "Jorge D.", 1000);

        System.out.println("Antes del depósito");
        System.out.println("--------------");
        cuenta1.display();
        cuenta1.deposito(100);
        System.out.println("Después del depósito");
        System.out.println("-------------");
        cuenta1.display();
        System.out.println("");

        System.out.println("Antes de la retirada");
        System.out.println("-----------------");
        cuenta2.display();
        cuenta2.retirar(800);
        System.out.println("Después de la retirada");
        System.out.println("----------------");
        cuenta2.display();
        System.out.println("");

        System.out.println("Después de la transferencia");
        System.out.println("--------------");
        cuenta2.transferencia(cuenta1, 50);
        cuenta1.display();
        cuenta2.display();
    }
}
