package fumadas.maquinaFumada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Surtido {
    // Atributos
    private Producto[] listaProductos;
    // Atributo con el cual indicamos la ruta del archivo 
    // "IMPORTANTE, YA QUE EN FUTURA VERSION SE GUARDARA AHI TAMBIEN"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private String nombreFichero = "./src/fumadas/files/productos.txt";

    // IMPORTANTE PARA LA ESCRITURA.
    public String getNombreFichero() {
        return nombreFichero;
    }

    // Atributos que se encuentran dentro del archivo
    private double recaudacion;
    private double cambio; 

    public Surtido() throws FileNotFoundException{
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            // Recojemos la linea en la cual nos indica el numero de productos para que no nos moleste.
            br.readLine();
            // Recojemos las lineas de recaudacion y de cambio:
            this.recaudacion = Double.parseDouble(br.readLine());
            this.cambio = Double.parseDouble(br.readLine());
            // Creamos una variable llamada linea, que recoje 
            String linea;
            int cont = 1;
            // Ahora, colocamos el tamaño del array listaProductos(+1 por que empieza en 1);
            listaProductos = new Producto[numProductos()+1];
                // Realizamos un bucle que guarde los valores del archivo
                while ((linea=br.readLine())!=null) {
                    // Dividimos la linea con ; para poder guardar los diferentes valores
                    String[] partes = linea.split(";");
                    // Creamos el Objeto
                    listaProductos [cont] = new Producto(partes[0], Double.parseDouble(partes[1]), Integer.parseInt(partes[2]));
                    // Sumamos el contador que utilizaremos para guardar los datous
                    cont++;
                }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Lee la primera linea del archivo donde dice el numero de productos.
    public int numProductos(){
        int numTotal= 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
                numTotal = Integer.parseInt(br.readLine());
                br.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return numTotal;
    }

    // Si esta dentro del rango, te devuelve la informacion del producto.
    public Producto getProducto(int numProducto) throws RangoInvalidoException{
        int posi = 0;
        if (numProducto>0 && numProducto<=numProductos()) {
            posi = numProducto;
        }else{
            throw new RangoInvalidoException();
        }
        return listaProductos[posi];
    }

    // Si esta dentro del rango, te devuelve la informacion del producto.
    public String productoEscritura(int numProducto){
        return  this.listaProductos[numProducto].getNombre() + ";" +
                this.listaProductos[numProducto].getPrecio() + ";" + 
                this.listaProductos[numProducto].getStock();
    }

    // Excepcion del metodo de arriba.
    static class RangoInvalidoException extends Exception{
        public RangoInvalidoException(){
            super("El rango introducido es superior o inferior.");
        }
    }

    // Te devuelve todos los nombres de los productos
    public String[] getNombresProductos(){
        String[] str = new String[numProductos()+1];
        for (int i = 1; i < str.length; i++) {
            str[i]=listaProductos[i].getNombre();
        }
        return str;
    }

    // Getters de los atributos del archivo.
    public double getRecaudacion() {
        return this.recaudacion;
    }

    public double getCambio() {
        return this.cambio;
    }

    // Setters de los atributos del archivo.
    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }
    
    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    // toString el cual va a ser modificau.
    @Override
    public String toString (){
        String str = "";
        str += "*****************************************" + "\n";
        str += "*\t\t" + "\u001B[35m" + "\u001B[1m" + "PRODUCTOS" + "\u001B[0m" + "\t\t*" + "\n";
        str += "*\t" + "\u001B[34m" + "Codigo" +  "\t" + "Nombre" + "\t" + "Precio" + "\t" + "Stock" + "\u001B[0m" +"\t*" + "\n";
        for (int i = 1; i < this.listaProductos.length; i++) {
                str += "*\t" + i + "\t" + listaProductos[i].getNombre() + "\t" + listaProductos[i].getPrecio() + "\t" + listaProductos[i].getStock() + "\t*" + "\n";  
        }
        str += "*****************************************";
        return str;
    }
}
