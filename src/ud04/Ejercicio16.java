package ud04;

public class Ejercicio16 {
    
    public static void generarInfo(int[][]ventas, double[]precios){
        //creamos el bucle para rellenar la informacion de ventas.
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[0].length; j++) {
                ventas[i][j]=(int)(Math.random()*301);
            }
        }
        //creamos el bucle para generar precios.
        for (int i = 0; i < precios.length; i++) {
            precios[i]=(double)((int)(Math.random()*10000))/100;
        }
    }

    public static void mostrar(int[][]ventas, double[]precios){
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                System.out.print(ventas[i][j] + " ");
            }
            System.out.println();
        }
        // //creamos el bucle para generar precios.
        // for (int i = 0; i < precios.length; i++) {
        //     precios[i]=(double)((int)(Math.random()*10000))/100;
        // }
    }

    public static int distribuidorMasVentas(int[][] ventas){
        int aux = 0;
        int maximo = 0;
        int posi= -1;
        int i = 0;
        for ( i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                aux+=ventas[i][j];
            }
            if (aux>maximo) {
                posi=i;
                maximo=aux;
            }
            aux=0;
        }
        return posi+1;
    }

    public static int articuloMasVentas(int[][] ventas){
        int aux = 0;
        int total = 0;
        int posi= -1;
        for (int j = 0; j < ventas[0].length; j++) {
            for (int i = 0; i < ventas.length; i++) {
                aux+=ventas[i][j];
            }
            if (aux>total) {
                posi=j;
                total=aux;
            }
            aux=0;
        }
        return posi+1;
    }

    public static void informeComision(int[][]ventas, double[]precios){
        
        for (int i = 0; i < ventas.length; i++) {
            double suma = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                suma+=ventas[i][j]*precios[j];
            }
            if (suma>30000 && suma<=70000) {
                System.out.printf("Distribuidor: %d | importe total: %.2f | porcentaje de comisión: %d%% | importe de la comisión: %.2f euros \n",
                i+1,suma,5,suma*0.05);
            }else if (suma>70000) {
                System.out.printf("Distribuidor: %d | importe total: %.2f | porcentaje de comisión: %d%% | importe de la comisión: %.2f euros \n",
                i+1,suma,8,suma*0.08);
            }else{
                System.out.println("El distribuidor " + (i+1) + " no ha generado un importe suficiente");
            }
        }
    }

    public static void main(String[] args) {
        int[][] ventas = new int [5] [10];
        double[] precios = new double[10];

        generarInfo(ventas, precios);
        mostrar(ventas, precios);

        System.out.println("El distribuidor con mas ventas es el: "+distribuidorMasVentas(ventas));
        System.out.println("El objeto con mas ventas es el: "+articuloMasVentas(ventas));
        informeComision(ventas, precios);
    }
}
