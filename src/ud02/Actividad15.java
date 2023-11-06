package ud02;
import java.util.Scanner;

public class Actividad15 {
    private int codigoProducto;
    private String nombreProducto;
    private String descripcion;
    private String categoria;
    private double peso;
    private double precio;
    private int stock;

    public Actividad15(){

    }

    public Actividad15(int codigoProducto, String nombreProducto, String descripcion,
    String categoria, double peso, double precio, int stock){
    this.codigoProducto=codigoProducto;
    this.nombreProducto=nombreProducto;
    this.descripcion=descripcion;
    this.categoria=categoria;
    this.peso=peso;
    this.precio=precio;
    this.stock=stock;
    }

    public void aumentaStock(int mas){
        this.stock+=mas;
    }

    public void disminuyeStock(int menos){
        this.stock-=menos;
    }

    public double ivaProducto(int iva){
        double precioIva;
        if (iva!=0) {
            precioIva= this.precio+((this.precio*iva)/100);
        } else {
            precioIva= this.precio;
        }
        return precioIva;
    }

    public String mostrarDatos(){
        return "\n+--------------------------\n" +
        "|Proveedor\n" + 
        "|\n" +
        "|Codigo Producto:\t" + this.codigoProducto + "\n" +
        "|Nombre Producto:\t" + this.nombreProducto + "\n" +
        "|Descripcion:\t\t" + this.descripcion + "\n" +
        "|Categoria:\t\t" + this.categoria + "\n" +
        "|Peso:\t\t\t" + this.peso + "\n" +
        "|Precio:\t\t" + this.precio + "\n" +
        "|Stock:\t\t\t" + this.stock + "\n" +
        "+--------------------------\n";   
    }

    public static void main(String[] args) {
    Scanner entrada= new Scanner(System.in);

    int codigoProducto;
    String nombreProducto;
    String descripcion;
    String categoria;
    double peso;
    double precio;
    int stock;
    int aux;
    
    System.out.println("Introduzca los siguientes datos: ");

    System.out.print("Codigo producto de Hardware: ");
    codigoProducto=entrada.nextInt();
    
    System.out.print("Nombre del producto de Hardware: ");
    entrada.nextLine();
    nombreProducto=entrada.nextLine();

    System.out.print("Descripcion del producto de Hardware: ");
    descripcion=entrada.nextLine();

    System.out.print("Categoria del producto de Hardware: ");
    categoria=entrada.nextLine();

    System.out.print("Peso del producto de Hardware: ");
    peso=entrada.nextDouble();

    System.out.print("Precio del producto de Hardware: ");
    precio=entrada.nextDouble();

    System.out.print("Stock del producto de Hardware: ");
    stock=entrada.nextInt();

    Actividad15 productoHardware = new Actividad15(codigoProducto, nombreProducto, descripcion, categoria, peso, precio, stock);

    System.out.println("\n\nIntroduzca los siguientes datos: ");

    System.out.print("Codigo producto de Software: ");
    codigoProducto=entrada.nextInt();
    
    System.out.print("Nombre del producto de Software: ");
    entrada.nextLine();
    nombreProducto=entrada.nextLine();

    System.out.print("Descripcion del producto de Software: ");
    descripcion=entrada.nextLine();

    System.out.print("Categoria del producto de Software: ");
    categoria=entrada.nextLine();

    System.out.print("Peso del producto de Software: ");
    peso=entrada.nextDouble();

    System.out.print("Precio del producto de Software: ");
    precio=entrada.nextDouble();

    System.out.print("Stock del producto de Software: ");
    stock=entrada.nextInt();

    Actividad15 productoSoftware = new Actividad15(codigoProducto, nombreProducto, descripcion, categoria, peso, precio, stock);

    System.out.println("\nProducto 1:\n" + productoHardware.mostrarDatos());

    System.out.println("\nProducto 2:\n" + productoSoftware.mostrarDatos());

    //aumentamos el stock
    productoHardware.aumentaStock(12);

    //decrementamos stock
    productoSoftware.disminuyeStock(5);

    System.out.println("Introduzca el iva del producto de hardware: ");
    aux=entrada.nextInt();
    
    System.out.println("\nProducto 1:\n" + productoHardware.mostrarDatos());
    System.out.println("Precio final con iva (Si no se han introducido datos sera el mismo)");
    System.out.println(productoHardware.ivaProducto(aux));
    
    System.out.println("\nProducto 2:\n" + productoSoftware.mostrarDatos());
    System.out.println("Precio final con iva (Si no se han introducido datos sera el mismo)");
    System.out.println(productoSoftware.ivaProducto(0));

    entrada.close();
    }

}