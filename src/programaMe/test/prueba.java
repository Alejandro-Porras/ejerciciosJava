package programaMe.test;

public class prueba {
    public static void main(String[] args) {
        String num = "10001";
        if (num.length()%2!=0) {
            System.out.println("mal");
        }
        if (num.substring(num.length()/2).equals(num.substring(0, num.length()/2))) {
            System.out.println("Bien 1");
        }
        System.out.println(num.substring(0, 2));
        System.out.println(num.substring(num.length()-2, num.length()));
        
    }
}
