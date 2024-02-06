package tests.test_v2;

public class Contras {
    public static void main(String[] args) {
        int contra= 595890;
        int contra2=0;
        do {
            contra2++;
            System.out.println(contra2);
        } while (contra!=contra2);
        if (contra==contra2) {
            System.out.println("Contraseña encontrada " + contra2);
        }
    }
}
