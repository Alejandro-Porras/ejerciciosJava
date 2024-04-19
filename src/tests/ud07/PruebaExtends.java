package tests.ud07;

public class PruebaExtends {
    public static <T extends Number> double sumarDecimales (T a, T b){
        return (a.doubleValue() + b.doubleValue());
    }

    public static void main(String[] args) {
        Short a1 = 21;
        Integer b1 = 12;

        System.out.println(sumarDecimales(a1, b1));
    }
}
