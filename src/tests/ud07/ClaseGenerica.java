package tests.ud07;

public class ClaseGenerica<T> {
    T aux;

    public void invertir (T[] lista){
        for (int i = 0; i < lista.length/2; i++) {
            aux = lista[i];
            lista[i] = lista[lista.length - i - 1];
            lista[lista.length - i - 1] = aux;
        }
    }

    public static void main(String[] args) {
        Integer[] numeros = {0,1,2,3,4,5,6,7,8,9};

        ClaseGenerica<Integer> u = new ClaseGenerica<Integer>();

        u.invertir(numeros);

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
        }
    }
}
