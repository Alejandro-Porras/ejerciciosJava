package test_v2.test;

public class Pajaro{
    String nombre;
    int posX;
    int posY;

    public Pajaro (){
    }

    public Pajaro (String nombre, int posX, int posY){
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
    }

    public double volar (int posX, int posY){
        double desplazamiento;

        desplazamiento=Math.sqrt(Math.pow(posX, 2) + Math.pow(posY, 2));
        this.posX = posX;
        this.posY = posY;

        return desplazamiento;
    }

    public static void main(String[] args) {
        Pajaro pajaro1= new Pajaro();
        Pajaro pajaro2= new Pajaro("Pajaroto", 3, 12);

        System.out.print("\nPajaro1:");
        System.out.print("\nnombre: "+ pajaro1.nombre);
        System.out.print("\nPosicion X: "+ pajaro1.posX);
        System.out.print("\nPosicion Y: "+ pajaro1.posY);
            System.out.println();
        System.out.print("\nPajaro2:");
        System.out.print("\nnombre: "+ pajaro2.nombre);
        System.out.print("\nPosicion X: "+ pajaro2.posX);
        System.out.print("\nPosicion Y: "+ pajaro2.posY);
            System.out.println();
            System.out.println();
        System.out.printf("Desplaza el pajaro 2: %.2f", 
                            pajaro2.volar(10,7));
        System.out.println();
        System.out.print("\nPajaro2:");
        System.out.print("\nnombre: "+ pajaro2.nombre);
        System.out.print("\nPosicion X: "+ pajaro2.posX);
        System.out.print("\nPosicion Y: "+ pajaro2.posY);

        System.out.println();
        System.out.println(pajaro2.toString());
    }
}