package ud04;

public class Ejercicio03 {
    private static final int LANZAMIENTOS = 1000000;
    private static final int FRECUENCIA = 1000;
    
    public static int tiraDado(){
        return (int)(Math.random()*6+1);
    }
    public static void main(String[] args) {
        int[] dado = new int[6];

        for (int i=1; i<=LANZAMIENTOS; i++) {
            switch (tiraDado()) {
                case 1:
                    dado[0]++;
                    break;
                case 2:
                    dado[1]++;
                    break;
                case 3:
                    dado[2]++;
                    break;
                case 4:
                    dado[3]++;
                    break;
                case 5:
                    dado[4]++;
                    break;
                case 6:
                    dado[5]++;
                    break;
            }
        if (i%FRECUENCIA==0) {
            System.out.println("\nNumero de lanzamiento " + i);
            for (int j = 0; j < dado.length; j++) {
                // System.out.println(j+ ": " + (double)(dado[j]*100/i) + "%");
                System.out.printf("\n%d: %.2f%%", j, (double)dado[j]*100/i);
            }
            // System.out.println("1: " + (dado[0]*100/i) + "%"
            //                   +"\n2: " + (dado[1]*100/i)+ "%"
            //                   +"\n3: " + (dado[2]*100/i)+ "%"
            //                   +"\n4: " + (dado[3]*100/i)+ "%"
            //                   +"\n5: " + (dado[4]*100/i)+ "%"
            //                   +"\n6: " + (dado[5]*100/i)+ "%");
        }
        }
    }
}
