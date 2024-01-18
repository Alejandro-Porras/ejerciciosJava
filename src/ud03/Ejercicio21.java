package ud03;

import java.util.Scanner;

public class Ejercicio21 {
    private int num;

    public Ejercicio21() {
    }
    public Ejercicio21(int num){
        this.num=num;
    }

    public void imparesHastaN(){
        int num1 = 1;
        while (num1<this.num) {
            if (num1%2!=0) {
                System.out.print(num1 + " ");
            }
            num1++;
        }            
    }

    public void nImpares(){
        int num1 = 1;
        int contador = 1;
        while (contador<=this.num) {
            if (num1%2!=0) {
                System.out.print(num1 + " ");
                contador++;
            }
            num1++;
        }            
    }

    public void cuentaAtras(){
        int num1 = this.num;
        while (num1>=0) {
            System.out.print(num1);
            num1--;            
        }
    }

    public void sumaNPrimeros(){
        int num1 = 1;
        int num = this.num;
        while (num1!=this.num) {
            num=num+num1;
            num1++;            
        }
        System.out.println(num);
    }

    public void mostrarDivisoresN(){
        int contador = 1;
        while (contador-1<this.num) {
            if (this.num%contador==0) {
                System.out.println(contador);
            }
            contador++;
        }
    }

    public void sumaDivisoresN(){
        int contador = 1;
        int num1 = 0;
        while (contador<this.num) {
            if (this.num%contador==0) {
                num1+=contador;
            }
            contador++;
        }
        System.out.println(num1);
    }
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        
        int num;

        System.out.println("Introduzca numero entero: ");
        num=entrada.nextInt();

        Ejercicio21 calculo = new Ejercicio21(num);

        System.out.println();

        // calculo.imparesHastaN();

        // calculo.nImpares();

        // calculo.cuentaAtras();

        // calculo.sumaNPrimeros();
           
        // calculo.mostrarDivisoresN();
        
        calculo.sumaDivisoresN();

        entrada.close();
    }
}
