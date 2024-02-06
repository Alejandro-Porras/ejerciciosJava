package tests.test_v2;

import java.util.Arrays;
import java.util.Scanner;

public class Ordenar {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
       
        int num;

    System.out.print("Intro numero de 4 cifras: ");
    num=entrada.nextInt();

        int[] aNum = {((num%10000-num%1000)/1000),((num%1000-num%100)/100),((num%100-num%10)/10),num%10};

        Arrays.sort(aNum);
        
        for (int i = 0; i < aNum.length; i++) {
            System.out.print(aNum[i]);
        }
        entrada.close();
    }
}
