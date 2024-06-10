package ud08.Ejercicios._07_obra;

public class TestObra {
    public static void main(String[] args){
        // Lineas comentada = error.
        Montador m1 = new Carpintero();
        // No funciona
        // Montador m2 = new Albañil();
        //si funciona pero sale amarillo.
        //Obrero o1 = new Carpintero();
        Obrero o2 = new Albañil();
        //o1.montar("Mesa");
        //o2.levantarMuro();
        //m1.saludar();
        m1.montar("Silla");
        ((Albañil)o2).levantarMuro();
        //((Albañil)o1).levantarMuro();

        // c) ¿Sería correcta la instrucción siguiente?"
        // Te coloca unicamente el codigo del objeto, pero si, funciona.
        Albañil a = new Albañil();
        System.out.println(a.toString());
    }
}
