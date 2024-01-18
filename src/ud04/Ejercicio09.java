package ud04;

public class Ejercicio09 {
    public static void main(String[] args) {
        int cont= 0;
        String[] v1 =  {"miguel","josé","ana","maría"};
        String[] v2 =   {"ana", "luján", "juan", "josé","pepa", "ángela", "sofía", "andrés", "bartolo"} ;
        for (int i = 0; i < v1.length; i++) {
            for (int j = 0; j < v2.length; j++) {
                if (v1[i].equals(v2[j])) {
                    System.out.println(v1[i] + " tiene tocayo en el segundo grupo.");
                    cont++;
                    break;
                }
            }
        }
        System.out.println("Total: " + cont + " personas del primer grupo tienen tocayo.");
    }
}
