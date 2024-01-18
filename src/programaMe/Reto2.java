package programaMe;

import java.util.Scanner;

public class Reto2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int repes=entrada.nextInt();
        entrada.nextLine();
            for (int i = 0; i < repes; i++) {
                int suma= 0;
                String input = entrada.nextLine();
                String[] parts = input.split(" ");
                for (int j = 1; j < parts.length; j++) {
                    suma+=Integer.parseInt(parts[j]);
                }
                System.out.println((Integer.parseInt(parts[0])-suma));
            }
        entrada.close();
    }
}
