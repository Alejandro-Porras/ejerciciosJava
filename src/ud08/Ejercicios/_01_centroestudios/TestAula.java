package ud08.Ejercicios._01_centroestudios;

public class TestAula {
    public static void main(String[] args) {
        AulaInformatica aI = new AulaInformatica(6, 4, 5);
        AulaMusica aM = new AulaMusica(6, 4, false);
        Aula a = new Aula(6, 4);

        System.out.println(aI);
        System.out.println(aM);
        System.out.println("Aula\n" +a);
    }
}
