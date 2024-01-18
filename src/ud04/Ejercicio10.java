package ud04;

public class Ejercicio10 {
    public static int sumaDespuesDeImpar(int[] v){
    int total = 0;
    for (int i = 0; i < v.length; i++) {
            if (v[i]%2!=0) {
                for (int j = i+1; j < v.length; j++) {
                    total+=v[j];
                }
                break;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int[] numeros = new int[4];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*11);
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println("\n"+sumaDespuesDeImpar(numeros));

    }
}
