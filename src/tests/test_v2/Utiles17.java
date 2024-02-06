package tests.test_v2;

public class Utiles17 {
    // Dada una matríz con el mismo número de filas y de columnas, diseñar los
    // siguientes métodos:

    // método mostrarArray que muestra la array
    public static void mostrarArray(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    // método mostrarDiagonal que muestre por pantalla los elementos de la diagonal principal.
    public static void mostrarDiagonal(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i == j) {
                    System.out.print(m[i][j] + " ");
                }
            }
        }
    }

    // método filaDelMayor que devuelva la fila en que se encuentra el mayor elemento de la matriz.
    public static int filaDelMayor (int[][] m) {
        int max=0;
        int pos=-1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                    pos = i;
                }
            }
        }
        return pos+1;
    }

    // método intercambiarFilas que intercambie los elementos de las filas indicadas.
    public static void intercambiarFilas(int[][] m, int f1, int f2) {
        int[] aux = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                aux[j] = m[f1-1][j];
                m[f1-1][j] = m[f2-1][j];
                m[f2-1][j] = aux[j];
            }
        }
    }

    // método esSimetrica que devuelva true si la matriz m es simétrica.
    // Una matriz es simétrica si tiene el mismo número de filas
    // que de columnas y además m[i][j] = m[j][i] para todo par de índices i,j .
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
        int[][] m={
            {1,5,3},
            {5,4,7},
            {3,7,5}
        };
        
        System.out.println("Array inicial: ");
        mostrarArray(m);
        System.out.println(esSimetrica(m));
        System.out.println();
        intercambiarFilas(m, 1, 3);
        mostrarArray(m);
        System.out.println(esSimetrica(m));
    }
}
