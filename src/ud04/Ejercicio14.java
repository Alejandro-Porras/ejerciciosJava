package ud04;

public class Ejercicio14 {
    public static boolean mismosValores(double v1[], double v2[]) {
        boolean encontrado = false;
        int i = 0;
        while (i < v1.length && !encontrado) {
        boolean encontrado2 = false;
        int j = 0;
        while (j < v2.length && !encontrado2) {
        if (v1[i] == v2[j]) {
        encontrado2 = true;
        i++;
        } else {
        j++;
        }
        }
        if (encontrado2 == false) {
        encontrado = true;
        }
        }
        return !encontrado;
        }
        
    public static void main(String[] args) {
        double[] v1 = {1,2,3,4,5};
        double[] v2 = {10,7,8,9,5};
        System.out.println(mismosValores(v1, v2));
    }
}
