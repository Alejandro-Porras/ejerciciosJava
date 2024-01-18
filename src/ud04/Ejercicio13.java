package ud04;

public class Ejercicio13 {
    public static int SubSecuencia(int[] v){
        int i;
        boolean haySubsecuencia = false;
        for (i=0; i < v.length && !haySubsecuencia; i++) {
            if (i!=v.length-1) {
                if ((v[i])+1==(v[i+1]) && v[i+1]+1==v[i+2]) {
                haySubsecuencia = true;
            }
            }   
        }
        if (i==v.length) {
            i=0;
        }

        return i-1;
    }



    public static void main(String[] args) {
        int[] numeros = {1,3,5,6,8,9,10};

        System.out.println(SubSecuencia(numeros));
    }
}
