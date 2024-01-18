package ud04;

public class Ejercicio12 {
    public static boolean EsCapicua(String[] v){
            for (int i = 0; i < v.length; i++) {
                if (!v[i].equals(v[v.length - i - 1])) {
                    return false;
                }
            }
        return true;
        }
    
    public static void main(String[] args) {
        String[] cap = {"a", "n", "a"};
        String[] cap2 = {"p", "n", "a"};
        
        System.out.println(EsCapicua(cap));
        System.out.println(EsCapicua(cap2));
    }
}
