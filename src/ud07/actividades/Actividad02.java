package ud07.actividades;

import java.util.ArrayList;

public class Actividad02 {
    public static void main(String[] args) {
        int numPersonas = (int) (Math.random()*51);
        ArrayList<Integer> listaUsuarios = new ArrayList<>();

        double precio = 0;

        for (int i = 0; i < numPersonas; i++) {
            listaUsuarios.add((int) ((Math.random()*56)+5));
            if (listaUsuarios.get(i)>=5 && listaUsuarios.get(i)<=10) {
                precio+=5;
            }else if (listaUsuarios.get(i)>=11 && listaUsuarios.get(i)<=17) {
                precio+=7.5;                
            } else {
                precio+=9.5;
            }
        }


        System.out.printf("Hay un total de %d personas en la cola.\n", numPersonas);
        System.out.printf("El precio total es %4.2f\n" , precio);
        System.out.println(listaUsuarios);
    }
}
