package ud07.actividades;

import java.util.ArrayList;

public class Actividad03 {
    private static int contador = 0;
    private String nombre;
    private int cantidad;
    private double precio;

    public Actividad03() {
        this.nombre = "producto" + contador++;
        this.cantidad = (int)((Math.random()*201));
        this.precio = (double)((int)(Math.random()*10000) + 5)/100;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        // return"\nProducto" + getNombre() +
        //         "\nStock" + getCantidad() +
        //         "\nPrecio" + getPrecio();
        String str = String.format("Producto-> %-20s %3d %5.2f $ \n", getNombre(), getCantidad(), getPrecio());
        return str;
    }

    public static void main(String[] args) {
        ArrayList<Actividad03> productos = new ArrayList<>();

        int numProductos = (int) (Math.random()*11)+1;

        for (int i = 0; i < numProductos; i++) {
            productos.add( new Actividad03());
        }

        double total = 0;
        System.out.println("****** TICKET ******");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i));
            total += productos.get(i).getPrecio()*productos.get(i).getCantidad();
        }
        System.out.println("---------------------------------------------");
        System.out.printf("%30s %10.2f $", "Precio",total);
    }
}