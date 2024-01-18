package programaMe.test;

public class TestMaxMin {
    public static void main(String[] args) {
        int[] v={7,2,1,4};
        System.out.println("---MAXIMO---");
        int max = -1;
        for (int i = v.length-1; i >= 3; i--) {
            if (v[i]>max) {
                max=v[i];
            }
        }

        System.out.println("---MINIMO---");
        int min = 1;
        for (int i = 2+1; i < v.length; i++) {
            if (v[i]<min){
                min=v[i];
            }
        }
        System.out.println(min);
    }
}
