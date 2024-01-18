package ud04;

public class Ejercicio17 {
    public static final int TAMAÑO_MATRIZ = 3;

    public static void mostrar(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void mostrarDiagonal(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i==j) {
                    System.out.print(m[i][j]+" "); 
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static int filaDelMayor (int[][] m){
        int posi=-1;
        int max=-1;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j]>max) {
                    max=m[i][j];
                    posi=i+1;
                }
            }
        }
        return posi;
    }

    public static void intercambiarFilas(int[][] m, int f1, int f2){
        int[] aux= new int[m.length];
        for (int j = 0; j < m[f1-1].length; j++) {
                aux[j]=m[f1-1][j];
        }

        for (int j = 0; j < m[f2-1].length; j++) {
                m[f1-1][j]=m[f2-1][j];
        }

        for (int j = 0; j < m[f2-1].length; j++) {
                m[f2-1][j]=aux[j];
        }
    }
    
    // public static boolean esSimetrica (int[][] m){
    //     boolean simetrica = true;
    //     for (int i = 0; i < m.length && simetrica; i++) {
    //         for (int j = 0; j < m[i].length; j++) {
    //             if (m[i][j]!=m[j][i]) {
    //                 simetrica = false;
    //             }
    //         }
    //     }
        
    //     return simetrica;
    // }

    public static boolean esSimetrica (int[][] m) {
        boolean simetrica = true;
        for (int i = 0; i < m.length && simetrica; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != m[j][i]) {
                    simetrica=false;
                }
            }
        }
        return simetrica;
    }

    public static void main(String[] args) {
        // int[][] m= new int[TAMAÑO_MATRIZ][TAMAÑO_MATRIZ];
        int[][] m={
            {1,5,3},
            {5,4,7},
            {3,7,5}
        };
         
        mostrar(m);
        System.out.println();
        System.out.println(esSimetrica(m));
        System.out.println();
        intercambiarFilas(m, 1, 2);
        mostrar(m);
        System.out.println();
        System.out.println(esSimetrica(m));
    }
}
