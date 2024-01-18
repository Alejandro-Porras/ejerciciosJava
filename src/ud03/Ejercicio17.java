package ud03;

import java.util.Scanner;

public class Ejercicio17 {
    private String publicacion;
    private double precio;
    private double precioLibro;
    private double precioRevista;
    private int unidades;


    public Ejercicio17(){

    }
    public Ejercicio17(String publicacion, double precio, int unidades){
        this.publicacion=publicacion;
        this.precio=precio;
        this.unidades=unidades;
    }

    public String seleccionPublicacion(){
        String respuesta; 
        
        if (this.publicacion.toLowerCase().equals("libro")) {
            if (this.unidades>=1&&this.unidades<=5) {
                //por si se quisiera añadir
                //this.precio-=(this.precio*0)/100;
                this.precioLibro=(this.unidades)*this.precio*1;
            } else if (this.unidades>=6 && this.unidades<=10) {
                this.precioLibro=(this.unidades)*(this.precio-(this.precio*10)/100);
            } else if (this.unidades>=11 && this.unidades<=20) {
                this.precioLibro=(this.unidades)*this.precio-(this.precio*15)/100;
            } else if (this.unidades>20) {
                this.precioLibro=(this.unidades)*this.precio-(this.precio*20)/100;
            } else {
                //nulo
                this.precioLibro=0;
            }

            respuesta="El precio de los libros es: " + this.precioLibro;

        } else if (this.publicacion.toLowerCase().equals("revista")) {
            if (this.unidades<=5) {
                //por si se quisiera añadir
                //this.precio-=(this.precio*0)/100;
                this.precioRevista=(this.unidades)*this.precio*1;
            } else if (this.unidades>=6 && this.unidades<=10) {
                this.precioRevista=(this.unidades)*precio-(this.precio*15)/100;
            } else if (this.unidades>=11 && this.unidades<=20) {
                this.precioRevista=(this.unidades)*precio-(this.precio*20)/100;
            } else if (this.unidades>20) {
                this.precioRevista=(this.unidades)*precio-(this.precio*25)/100;
            } else {
                //nulo
                this.precioRevista=0;
            }
            
            respuesta="El precio de las revista es: " + this.precioRevista;

        } else {
            respuesta="No se ha añadido una respuesta correcta";
        }
        
        return respuesta;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String publicacion;
        double precio;
        int unidades;

        System.out.println("\nIntroduzca las primeras publicaciones:");
        System.out.print("Publicacion(Libro/Revista): ");
        publicacion=entrada.nextLine();

        System.out.print("Precio: ");
        precio=entrada.nextDouble();

        System.out.print("Unidades: ");
        unidades=entrada.nextInt();

        Ejercicio17 publi1 = new Ejercicio17(publicacion, precio, unidades);

        System.out.println("\n\nIntroduzca las segundas publicaciones:");
        System.out.print("Publicacion(Libro/Revista): ");
        entrada.nextLine();
        publicacion=entrada.nextLine();

        System.out.print("Precio: ");
        precio=entrada.nextDouble();

        System.out.print("Unidades: ");
        unidades=entrada.nextInt();

        Ejercicio17 publi2 = new Ejercicio17(publicacion, precio, unidades);

        System.out.println("\n\n" + publi1.seleccionPublicacion());
        System.out.println("\n\n" + publi2.seleccionPublicacion());

        

        entrada.close();
    }
}
