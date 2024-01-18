package test_v2;

public class Ejercicio14 {
    public static void subsecuencia (int[] numeros){
        int cont = 1;
        int x = 0;
        for (int i = 0; i < numeros.length-1; i++) {
            if (numeros[i+1] == numeros[i]+1) {
                cont++;
                x = i+1;
                // System.out.println("Consecutiva en posiciones " +
                //                      i + " y " + (i+1) + " Con valores " +
                //                       numeros[i] + " y " + (numeros[i]+1));
            }
        }
        System.out.print("\nHay "+ cont +" números consecutivos , a partir de la posición "+
                         ((x-(cont-1))) + " a la " + (x) + ": {");
        for (int i = (x-(cont-1)); i <= x; i++) {
            System.out.print(numeros[i]);
            if (i < x) {
                System.out.print(", ");
            } else {
               System.out.print("}\n\n"); 
            }
        }
        
    }
    public static void main(String[] args) {
        int[] numeros = {99,45,34,12,5,46,5,6,7,8,55,30};

        subsecuencia(numeros);
        
    }
}

