package tests.test_v2;

public class PruebaWrappers {
    public static void main(String[] args) {
        int num=91232;
        String texto= Integer.toString( num);

        for (int i = 0; i < texto.length(); i++) {
            System.out.println(texto.charAt(i));
        }

        int num1=Integer.valueOf(texto);
        System.out.println(num1);
    }
}
