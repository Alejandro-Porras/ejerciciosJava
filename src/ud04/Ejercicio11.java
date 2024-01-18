package ud04;

public class Ejercicio11 {
        //no funciona
        public static boolean haypares1(int v[]) {
        int i = 0;
        while (i < v.length && v[i] % 2 != 0) {
            i++;
        }
        if (v[i] % 2 == 0)
            return true;
        else
            return false;
        }
        
        //funciona
        public static boolean haypares2(int v[]) {
        int i = 0;
            while (i < v.length && v[i] % 2 != 0) {
                i++;
            }
            if (i < v.length)
                return true;
            else
                return false;
        }
        
        //funciona
        public static boolean haypares3(int v[]) {
        int i = 0;
            while (v[i] % 2 != 0 && i < v.length) {
                i++;
            }
            if (i < v.length)
                return true;
            else
                return false;
        }
        
        //
        public static boolean haypares4(int v[]) {
        int i = 0;
        boolean encontrado = false;
            while (i <= v.length && !encontrado) {
                if (v[i] % 2 == 0)
                    encontrado = true;
                else
                    i++;
            }
        return encontrado;
        }
        
        //
        public static boolean haypares5(int v[]) {
        int i = 0;
        boolean encontrado = false;
            while (i < v.length && !encontrado){
                if (v[i] % 2 == 0)
                    encontrado = true;
                    i++;
            }
        return encontrado;
        }
        
        //
        //cambiado
        public static boolean haypares6(int v[]) {
        int i = 0;
            while (i < v.length) {
                /*
                 if (v[i] % 2 == 0)
                return true;
                else
                return false;
                 */
            }
            if (v[i] % 2 == 0)
                    return true;
                else
                    return false;
        }
        
        //
        public static boolean haypares7(int v[]) {
        int i = 0;
            while (i < v.length) {
                if (v[i] % 2 == 0)
                    return true;
                    i++;
            }
        return false;
        }

          
    public static void main(String[] args) {
        int[] v = {1,3,5,7,9};

        System.out.println(haypares7(v));
    } 
}
