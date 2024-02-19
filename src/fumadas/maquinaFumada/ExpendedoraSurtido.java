package fumadas.maquinaFumada;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import fumadas.maquinaFumada.Surtido.RangoInvalidoException;

public class ExpendedoraSurtido {
    //atributos
    // Solo son necesarios 
    private double credito;
    private Surtido productos;

    //constructor
    public ExpendedoraSurtido() {
        this.credito = 0;
        try {
            this.productos = new Surtido();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //getters
    public double getCredito() {
        return credito;
    }

    //getters modificaos
    // Recoge el numero de producto para comprobar el objeto de tipo Producto de Surtido
    public int getStock(int numProduct) throws RangoInvalidoException {
        return this.productos.getProducto(numProduct).getStock();
    }

    // Recoge el numero de producto para comprobar el objeto de tipo Producto de Surtido
    public double getPrecio(int numProduct) throws RangoInvalidoException {
        return this.productos.getProducto(numProduct).getPrecio();
    }

    //getters para saber cual es la recaudacion y el cambio (estan ya hechos en Surtido, pero para que sea mas facil su uso)
    public double getRecaudacion() {
        return this.productos.getRecaudacion();
    }

    public double getCambio() {
        return this.productos.getCambio();
    }


    // Comentados por su poco/nulo uso
    // Setters (privados pedido por el ejercicio)    
    // private void setCredito(double credito) {
    //     this.credito = credito;
    // }

    // Setters de admin
    public void setCambio(double cambio) {
        this.productos.setCambio(cambio);
    }

    public void setRecaudacion(double recaudacion) {
        this.productos.setRecaudacion(recaudacion);
    }

    // ToString de la clase Surtido
    public String toStringSurtido(){
        return this.productos.toString();
    }

    // Metodo para introducir el credito a la maquina expendedora
    public void introducirDinero(double importe){
        this.credito += importe;
    }

    // Metido para devolverle el dinero al usuario, por lo tanto, credito será 0
    public double solicitarDevolucion(){
        double devolucion = this.credito;
        this.credito = 0;
        return devolucion;
    }

    // Creamos el metodo comprar producto
    // La excepcion RangoInvalido se encuentra en la clase Surtido.
    public double comprarProducto(int producto) throws NoHayCambioException, NoHayProductoException,CreditoInsuficienteException,
     RangoInvalidoException{
        // Creamos la variable que vamos a retornar para no utilizar mas de un return
        double devolucion = 0;
        // Comprobamos que el numero de producto se encuentre en el rango.
        if (producto>0 && producto<=this.productos.numProductos()) {
            // Comprobamos que quede stock de el producto
            if (getStock(producto) >= 1) {
                // Comprobamos que haya suficiente credito para comprar el producto
                if (this.credito >= getPrecio(producto)) {
                    // Comprobamos que haya suficiente cambio para realizar la compra :)
                    if (this.credito-getPrecio(producto)<=this.productos.getCambio()) {
                        // La devolucion es el restante de comprar el producto.
                        devolucion = this.credito-getPrecio(producto);
                        // Credito lo pasamos a 0 ya que vamos a devolver el credito sobrante.
                        this.credito = 0;
                        // Bajamos el stock del producto.
                        this.productos.getProducto(producto).decrementarStock();
                        //Restamos la devolucion al cambio.
                        this.productos.setCambio(this.productos.getCambio() - devolucion);
                        //a Recaudacion le añadimos el precio.
                        this.productos.setRecaudacion(this.productos.getRecaudacion()+getPrecio(producto));
                    // Posibles Excepciones: 
                    }else{
                        throw new NoHayCambioException();
                    }
                }else{
                    throw new CreditoInsuficienteException();
                }
            }else{
                throw new NoHayProductoException();
            }
        }else {
            throw new RangoInvalidoException();
        }
        // Devolvemos el calculo realizado dentro de la anidacion de IF's
        return devolucion;
    }

    // Excepciones
    static class NoHayCambioException extends Exception{
        public NoHayCambioException(){
            super("ERROR: No hay cambio.");
        }
    }

    static class NoHayProductoException extends Exception{
        public NoHayProductoException(){
            super("ERROR: No queda stock del producto seleccionado.");
        }
    }

    static class CreditoInsuficienteException extends Exception{
        public CreditoInsuficienteException(){
            super("ERROR: Credito insuficiente");
        }
    }

    // FUMADA, SOBREESCRITURA DEL ARCHIVO DE TEXTO
    public void guardar(){
        // Recojemos todas las variables antes de machacar el txt.
        int numeroDeProductos = this.productos.numProductos();
        double recaudacion = this.productos.getRecaudacion();
        double cambio = this.productos.getCambio();
        String str = "";
        // Realizamos el bucle que recoje todos los productos añadiendolos con espacio a str
        for (int i = 1; i < numeroDeProductos+1; i++) {
            str+=(this.productos.productoEscritura(i));
            if (i!=numeroDeProductos) {
                str+="\n";
            }
        }
        // Creamos el flujo de salida para reescribir el fichero con la nueva informacion
        try (PrintWriter out = new PrintWriter(new FileWriter(this.productos.getNombreFichero()))) {
            // Variables creadas arriba
            out.println(numeroDeProductos);
            out.println(recaudacion);
            out.println(cambio);
            out.println(str);
        // Excepciones posibles
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void añadirProducto(){
        // Esta linea es para que no salga el warning de no cerrar entrada
        // Si cerramos la entrada el buffer del test se buggea goffy ahhh fallo
        @SuppressWarnings("resource")
        Scanner entrada = new Scanner(System.in);
        // Creamos las variables que necesitamos para crear el nuevo producto
        String nombre;
        double precio;
        int stock;
        
        // Preguntamos por pantalla los datos anteriores...
        System.out.println("Introduzca el nombre del producto");
        nombre = entrada.nextLine();

        System.out.println("Introduzca precio del producto");
        precio = entrada.nextDouble();

        System.out.println("Introduzca stock del producto");
        stock = entrada.nextInt();

        // variables necesaria para guardar y añadir la nueva version del fichero
        int numeroDeProductos = this.productos.numProductos()+1;
        double recaudacion = this.productos.getRecaudacion();
        double cambio = this.productos.getCambio();
        // Mismo bucle que el de guardar (para añadir los productos)
        String str = "";
        for (int i = 1; i < numeroDeProductos; i++) {
            str+=(this.productos.productoEscritura(i));
            if (i<numeroDeProductos-1) {
                str+="\n";
            }
        }
        // Creamos el flujo de salida que utilizaremos para machacar/reescribir el fichero
        try (PrintWriter out = new PrintWriter(new FileWriter(this.productos.getNombreFichero()))) {
            out.println(numeroDeProductos);
            out.println(recaudacion);
            out.println(cambio);
            out.println(str);
            // Añadimos a la ultima fila el nuevo producto separado por ;
            out.println(nombre+";"+precio+";"+stock);
        // Excepciones...
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        // Aqui, lo que hacemos es llamar otra vez al constructor de Surtido para que
        // al volver a llamar a la lista de productos aparezca el nuevo :D
        // (Si lo hago dentro del otro try catch da mal)
        try {
            this.productos = new Surtido();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void eliminarProducto() {
        @SuppressWarnings ("resource")
        Scanner entrada = new Scanner(System.in);

        System.out.println("Que producto quieres eliminar?");
        int codigoProd = entrada.nextInt();
        entrada.nextLine();
        try {
            if (productos.getProducto(codigoProd)!=null) {
                System.out.println("\nProducto introducido valido :)");
            }

            // Recojemos todas las variables antes de machacar el txt.
            int numeroDeProductos = this.productos.numProductos();
            double recaudacion = this.productos.getRecaudacion();
            double cambio = this.productos.getCambio();
            String str = "";
            // Booleano utilizado dentro del for.
            boolean encotrado = false;
            // Realizamos el bucle que recoje todos los productos añadiendolos con espacio a str
            for (int i = 1; i <= this.productos.numProductos(); i++) { 
                // Si I no es igual que el codigo del producto lo añade al str.
                if (i!=codigoProd) {
                    str+=(this.productos.productoEscritura(i));
                        if ((i<this.productos.numProductos()-1 && !encotrado || i<this.productos.numProductos() && encotrado)) {
                            str+="\n";
                        }
                // Si lo encuentra, no lo añade y pasa encontrado a true.
                } else if (i==codigoProd) {
                    encotrado = true;
                }
            }

            if (encotrado) {
                numeroDeProductos--;
            }
            // Creamos el flujo de salida para reescribir el fichero con la nueva informacion
            try (PrintWriter out = new PrintWriter(new FileWriter(this.productos.getNombreFichero()))) {
                // Variables creadas arriba
                out.println(numeroDeProductos);
                out.println(recaudacion);
                out.println(cambio);
                out.println(str);
            // Excepciones posibles
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            // Aqui, lo que hacemos es llamar otra vez al constructor de Surtido para que
            // al volver a llamar a la lista de productos aparezca el nuevo :D
            // (Si lo hago dentro del otro try catch da mal)
            try {
                this.productos = new Surtido();
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } catch (RangoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarProducto() throws InterruptedException {
        @SuppressWarnings ("resource")
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduce el codigo del producto a modificar: ");
        int producto = entrada.nextInt();
        try {
            int eleccion;
            do {
                System.out.print("\033[H\033[2J");  
                System.out.flush(); 
                System.out.println("\u001B[35m" + "\u001B[1m" + "Nombre: " + productos.getProducto(producto).getNombre() +
                 " | " + "Precio: " + productos.getProducto(producto).getPrecio() + " | " +
                  "Stock: " + productos.getProducto(producto).getStock() + "\u001B[0m");
                System.out.println("Que quieres modificar? " + " | " + "1. Nombre" + " | " + "2. Precio" + " | " + "3. Stock" +
                 " | " + "4. Salir");
                eleccion = entrada.nextInt();
                switch (eleccion) {
                    case 1:
                        entrada.nextLine();
                        System.out.println("Nuevo nombre del producto: ");
                        String nuevoNom = entrada.nextLine();
                        productos.getProducto(producto).setNombre(nuevoNom);
                        System.out.println("\u001B[36m" +  "\u001B[1m" + "Cambiando...." + "\u001B[0m");
                        Thread.sleep(1000*2);
                        break;
                    case 2:
                        System.out.println("Nuevo precio del producto: ");
                        double nuevoPrec = entrada.nextDouble();
                        productos.getProducto(producto).setPrecio(nuevoPrec);
                        entrada.nextLine();
                        System.out.println("\u001B[36m" +  "\u001B[1m" + "Cambiando...." + "\u001B[0m");
                        Thread.sleep(1000*2);
                        break;
                    case 3:
                        System.out.println("Nuevo Stock del producto: ");
                        int nuevoStock = entrada.nextInt();
                        productos.getProducto(producto).setStock(nuevoStock);
                        entrada.nextLine();
                        System.out.println("\u001B[36m" +  "\u001B[1m" + "Cambiando...." + "\u001B[0m");
                        Thread.sleep(1000*2);
                        break;
                    default:
                        break;
                }
            } while (eleccion != 4);
        } catch (RangoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
