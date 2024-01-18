package test_v2.test;

public class EsNavidad {
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("datos introducidos erroneos");
        }else
        if ((Integer.valueOf(args[0]) == 25) && (Integer.valueOf(args[1]) == 12))  {
            System.out.println("Es navidad");
        } else {
            System.out.println("No es navidad");
        }
    }
}
