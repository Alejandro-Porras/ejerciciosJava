package ud06._02maquinaExpendedora;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Surtido {
    private Producto[] listaProductos;
    private static String nombreFichero = "productos.txt";

    public Surtido() throws FileNotFoundException{
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            // Recojemos la linea en la cual nos indica el numero de productos para que no nos moleste.
            br.readLine();
            // Creamos una variable llamada linea, que recoje 
            String linea;
            int cont = 1;
            // Ahora, colocamos el tamaño del array listaProductos(+1 por que empieza en 1);
            listaProductos = new Producto[numProductos()+1];
                // Realizamos un bucle que guarde los valores del archivo
                while ((linea=br.readLine())!=null) {
                    String[] partes = linea.split(" ");
                    listaProductos [cont] = new Producto(partes[0], Double.parseDouble(partes[1]), Integer.parseInt(partes[2]));
                    cont++;
                }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public int numProductos(){
        int numTotal= 0;
            try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
                numTotal = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return numTotal;
    }

    public Producto getProducto(int numProducto) throws RangoInvalidoException{
        int posi = 0;
        if (numProducto>0 && numProducto<=numProductos()) {
            posi = numProducto;
        }else{
            throw new RangoInvalidoException();
        }
        return listaProductos[posi];
    }

    static class RangoInvalidoException extends Exception{
        public RangoInvalidoException(){
            super("El rango introducido es superior o inferior.");
        }
    }

    public String[] getNombresProductos(){
        String[] str = new String[numProductos()+1];
        for (int i = 1; i < str.length; i++) {
            str[i]=listaProductos[i].getNombre();
        }
        return str;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 1; i < listaProductos.length; i++) {
            str += listaProductos[i];
        }
        return str;
    }

    public static void main(String[] args) {
        try {
            Surtido s1 = new Surtido();
            System.out.println(s1);
            System.out.println(s1.numProductos());
            System.out.println(s1.getProducto(4));
            for (int i = 1; i < s1.getNombresProductos().length; i++) {
                System.out.println(s1.getNombresProductos()[i]);
            }

        } catch (FileNotFoundException | RangoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
