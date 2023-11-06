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
            if (this.unidades<=5) {
                //por si se quisiera añadir
                //this.precio-=(this.precio*0)/100;
                this.precioLibro=this.precio*1;
            } else if (this.unidades>=6 && this.unidades<=10) {
                this.precioLibro=this.precio-(this.precio*10)/100;
            } else if (this.unidades>=11 && this.unidades<=20) {
                this.precioLibro=this.precio-(this.precio*15)/100;
            } else if (this.unidades>20) {
                this.precioLibro=this.precio-(this.precio*20)/100;
            } else {
                //nulo
                this.precioLibro=0;
            }

            respuesta=precioLibro+ "si";

        } else if (this.publicacion.toLowerCase().equals("revista")) {
            if (this.unidades<=5) {
                //por si se quisiera añadir
                //this.precio-=(this.precio*0)/100;
                this.precioRevista=this.precio*1;
            } else if (this.unidades>=6 && this.unidades<=10) {
                this.precioRevista=precio-(this.precio*15)/100;
            } else if (this.unidades>=11 && this.unidades<=20) {
                this.precioRevista=precio-(this.precio*20)/100;
            } else if (this.unidades>20) {
                this.precioRevista=precio-(this.precio*25)/100;
            } else {
                //nulo
                this.precioRevista=0;
            }
            
            respuesta=precioRevista + "no";

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

        System.out.println("Introduzca las primeras publicaciones:");
        System.out.print("Publicacion: ");
        entrada.nextLine();
        publicacion=entrada.nextLine();

        System.out.print("Precio: ");
        precio=entrada.nextDouble();

        System.out.print("Unidades: ");
        unidades=entrada.nextInt();

        Ejercicio17 publi1 = new Ejercicio17(publicacion, precio, unidades);

        System.out.println("Introduzca las segundas publicaciones:");
        System.out.print("Publicacion: ");
        entrada.nextLine();
        publicacion=entrada.nextLine();

        System.out.print("Precio: ");
        precio=entrada.nextDouble();

        System.out.print("Unidades: ");
        unidades=entrada.nextInt();

        Ejercicio17 publi2 = new Ejercicio17(publicacion, precio, unidades);

        System.out.println(publi1.seleccionPublicacion());
        System.out.println(publi2.seleccionPublicacion());

        entrada.close();
    }
}
