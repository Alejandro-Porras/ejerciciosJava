/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package test_v2;

/**
 *CuentaBancaria.java
 * 
 *[Creada el 8 nov 2023, 12:34:21
 *
 *Desarrollada por Mazinger z en la empresa el día 8 nov 2023
 *
 *Puede contactar conmigo en a@a.net.
 *
 * @Autor Mazinger z
 * @Versión 1.0.
 * @Fecha 8 nov 2023
 */

public class CuentaBancaria {
    private int numeroCuenta;
    private String nombreCliente;
    private double balance;

    /* Constructor para crear una cuenta bancaria con balance 0*/
    public CuentaBancaria(int nuevoNumCuenta, String nuevoNombre) {
        this.numeroCuenta = nuevoNumCuenta;
        this.nombreCliente = nuevoNombre;
        this.balance = 0.0;
    }

    /* Constructor para crear una cuenta bancaria con balance  != 0*/
    public CuentaBancaria(int nuevoNumCuenta, String nuevoNombre, double nuevoBalance) {
        this.numeroCuenta = nuevoNumCuenta;
        this.nombreCliente = nuevoNombre;
        this.balance = nuevoBalance;
    }

    /* Método para hacer un depósito en una cuenta*/
    public void deposito(double cantidad) {
        /* Valida la cantidad que se deposita*/
        if (cantidad > 0.0) {
            balance += cantidad;
        } else {
            System.out.println("Transacción errónea!");
        }
    }

    /* Method to make a withdrawal from an account */
    public void retirar(double cantidad) {
        /* Valida la cantidad depositada. El balance debe ser superior a la cantidad que se pretende retirar*/
        if (cantidad > 0.0 && cantidad <= balance) {
            balance -= cantidad;
        } else {
            System.out.println("Transacción errónea!");
        }
    }

    /* Método para transferir una cantidad de una cuenta a otra */
    public void transferencia(CuentaBancaria cuentaDestino, double cantidad) {
        /* Validate the amount being deposited. The balance should be more than the withdrawal amount */
        if (cantidad > 0.0 && cantidad >= this.balance) {
            /* The amount will be deposited to the specified destination account */
            cuentaDestino.deposito(cantidad);

            /* La cantidad será retirada de la cuenta origen que ha iniciado la transferencia.*/
 /* 'this' se refiere al objeto que hace la llamada, el que aparece antes del punto cuando se usa '.transferencia'            */
            this.retirar(cantidad);
        } else {
            System.out.println("Transacción errónea!");
        }
    }

    /* Método para mostrar el estado de la cuenta*/
    public void display() {
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Nombre del cliente: " + nombreCliente);
        System.out.println("Balance: " + balance + " euros");
    }
}
