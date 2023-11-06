package ud02;

import java.util.Scanner;

public class Actividad02 {
    private int velocidad;
    
    Actividad02() {
            velocidad=0;
            }

    public Actividad02(int velocidad){
        this.velocidad = velocidad;
    }

    public int getVelocidad(){
        return this.velocidad;
    }
    public void acelerar(int mas){
        this.velocidad += mas;
    }
    public void frena(int menos){
        if (this.velocidad-menos<0){
            this.velocidad = 0;
        } else {
            this.velocidad -= menos;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int v;

        Actividad02 moto1 = new Actividad02();
        Actividad02 moto2 = new Actividad02(15);

        System.out.println("Aumenta la velocidad de la moto 1: ");
        v= entrada.nextInt();
        System.out.printf("Velocidad antes: %d", moto1.getVelocidad());
        moto1.acelerar(v);
        System.out.printf("\nvelocidad después: %d\n", moto1.getVelocidad());

        System.out.println("Aumenta la velocidad de la moto 2: ");
        v= entrada.nextInt();
        System.out.printf("Velocidad antes: %d", moto2.getVelocidad());
        moto2.acelerar(v);
        System.out.printf("\nvelocidad después: %d\n", moto2.getVelocidad());

        System.out.println("\nFRENAAAAAMOS 100km/h");
        moto1.frena(100);
        moto2.frena(100);

        System.out.printf("\nVelocidad final de moto1: %d",moto1.getVelocidad());
        System.out.printf("\nVelocidad final de moto2: %d",moto2.getVelocidad());
        System.out.println();

        entrada.close();
    }
}
