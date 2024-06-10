package ud08.Ejercicios._08_preguntas3;

public class CuestionHerencia {
    public static void main (String a[]){
        String tmp;
        @SuppressWarnings("unused")
        Derivada derivada;
        Derivada2 derivada2;
        Base base;

        // Lineas con fallo comentadas

        derivada2 = new Derivada2(); 
        base = derivada2;
        tmp = derivada2.metodo1(); 
        System.out.println("1) "+tmp);
        tmp = derivada2.metodoIn2("EDA!!"); 
        System.out.println("2) "+tmp);
        tmp = base.metodo1();
        System.out.println("3) "+tmp);
        tmp = base.metodo2("EDA!!"); 
        System.out.println("4) "+tmp);
        tmp = derivada2.metodoIn3();
        System.out.println("5) "+tmp);
        tmp = derivada2.metodo4();
        // System.out.println("6) "+tmp);
        // tmp = base.metodo3();
        System.out.println("7) "+tmp);
        derivada = new Derivada();
        derivada2 = new Derivada2();
        base = new Base();
        // Distinta ref = new Distinta();
        // tmp = ref.prueba(derivada2); 
        // System.out.println("8) "+tmp);
        // tmp = ref.prueba(derivada); 
        // System.out.println("9) "+tmp);
        // tmp = ref.prueba(base); 
        // System.out.println("10) "+tmp); 

    }
}
