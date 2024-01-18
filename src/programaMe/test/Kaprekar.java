package programaMe.test;

import java.util.Arrays;

public class Kaprekar {
    public static int convertirArrayInv(int[] v){
        int resu = 0;

        for (int i = 0; i < v.length; i++) {
            resu+=v[i]*(Math.pow(10, i));
        }

        return resu;
    }

    public static int convertirArray(int[] v){
        int resu = 0;
        int cont = 0;

        for (int i = v.length-1; i >= 0; i--) {
            resu+=v[i]*(Math.pow(10, cont));
            cont++;
        }

        return resu;
    }

    public static void main(String[] args) {
        int[] numIni= new int[] {1,2,1,1};
        Arrays.sort(numIni);
        for (int i = 0; i < numIni.length; i++) {
            System.out.print(numIni[i]);
        }

        int inv = convertirArrayInv(numIni);
        int ini = convertirArray(numIni);

        System.out.println("\n\n"+inv);
        System.out.println(ini);

        System.out.println(inv - ini);
    }

}
