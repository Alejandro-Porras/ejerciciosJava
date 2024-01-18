package ud04;

import java.util.Arrays;

public class Ejercicio18 {
    public static void imprimeMatriz(int[][] m){
        // for (int i = 0; i < m.length; i++) {
        //     for (int j = 0; j < m[i].length; j++) {
        //         System.out.print(m[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for (int[] vector : m) {
            System.out.println(Arrays.toString(vector));
        }
    }

    public static void limpiarFilas(int[][] m){
        
        for (int f = m.length-1; f >= 0; f--) {
            boolean encontrado = false;
                for (int c = 0; c < m[f].length && !encontrado; c++) {
                    //eliminar las completas
                    //comprobamos si tiene 0, si es true no se elimina
                    
                    if (m[f][c]==0) {
                        encontrado=true;
                    }
                }
            if (!encontrado) {
                for (int col = 0; col < m[f].length; col++) {
                    for (int fil = f; fil >= 1; fil--) {
                        m[fil][col]=m[fil-1][col];
                    }
                    m[0][col]=0;
                }
                f++;
            }
        }
    }
    public static void main(String[] args) {
        int[][] partida = {
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,2,0,0,0,0,0},
            {1,0,2,2,2,2,2,0},
            {1,0,2,4,4,0,3,0},
            {1,1,2,4,4,3,3,3}
        };

        imprimeMatriz(partida);
        limpiarFilas(partida);
        System.out.println();
        imprimeMatriz(partida);
    }
}
