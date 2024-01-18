package test_v2;

import java.util.Scanner;
public class Persona {
/*
 private static String nombre;
    private static int edad;
    private static String dni;
    private static  String sexo;
    private static double peso;
    private static double altura;
 */
//los sexo te los he pasado todos a char

String nombre;
int edad;
String dni;
char sexo;
double peso;
double altura;

    //te faltaba el getNombre
    public String getNombre() {
        return nombre;
    }

    //te faltaba el setNombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    /*
    public Persona (){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }
     */

    public Persona (){
        this.nombre = "Omar";
        this.edad = 18;
        this.dni = "53928312M";
        this.sexo = 'H';
        this.peso = 72;
        this.altura = 1.77;
    }

    /*
    public Persona(String nombre, int edad, String dni, String sexo, double peso, double altura){
        nombre = null;
        edad = 0;
        dni = null;
        dni = null;
        peso = 0.0;
        altura = 0.0;
    }
     */
    public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, char sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    /*
    public void calcularIMC(){
        double pesoIdeal = (peso/(Math.pow(altura,2)));

        if (pesoIdeal < 20 ) {
            System.out.println("bajo Peso");
        } if (pesoIdeal >= 20 && pesoIdeal <= 25) {
            System.out.println("Ideal");
        } else {
            System.out.println("sobre Peso");
        }

    }
    */
    public String calcularIMC(){
        double pesoIdeal = (peso/(Math.pow(altura,2)));

        if (pesoIdeal < 20 ) {
            return "bajo Peso";
        } if (pesoIdeal >= 20 && pesoIdeal <= 25) {
            return "Ideal";
        } else if (pesoIdeal>25) {
            return "sobre Peso";
        } else {
            return "No has puesto un valor valido";
        }
    }

    @Override
    public  String toString(){
        System.out.println("+--------------------------");
        System.out.println("| Persona");
        System.out.println("|");
        System.out.println("|nombre: " + getNombre());
        System.out.println("|edad: " + getEdad());
        System.out.println("|dni: "+ getDni());
        System.out.println("|sexo: "+ getSexo());
        System.out.println("|peso: "+ getPeso() + "Kg");
        System.out.println("|altura: "+ getAltura() + " Metros");
        System.out.println("+--------------------------");
        return null;
    }
    /* 
    public void esMayorDeEdad(double edad){
        if (edad < 18) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
    */
    public String esMayorDeEdad(){
        if (edad < 18) {
            return "False";
        } else {
            return "True";
        }
    }


    public static void main(String[] args) {
        //esto te lo empiezo de nuevo:
        Scanner entrada = new Scanner(System.in);

        String nombre;
        int edad;
        String dni;
        char sexo;
        double peso;
        double altura;

        Persona p1 = new Persona();

        Persona p2 = new Persona("Arnau", 18, 'H');

        System.out.println("\n\nIntroduce el nombre de la persona3: ");
        nombre = entrada.nextLine();
        System.out.println("Introduce la edad de la persona3: ");
        edad = entrada.nextInt();
        System.out.println("Introduce el DNI de la persona3: ");
        dni = entrada.next();
        System.out.println("Introduce el sexo de la persona3: ");
        sexo = entrada.next().charAt(0);
        System.out.println("Introduce el peso de la persona3 (Kg): ");
        peso = entrada.nextDouble();
        System.out.println("Introduce la altura de la persona3 (m):");
        altura = entrada.nextDouble();

        Persona p3 = new Persona(nombre, edad, dni, sexo, peso, altura);

         //Utilizamos el metodo calcularIMC y lo mostramos por pantalla:
        System.out.println("\n\n" + "persona1" + " tiene un IMC: " + p1.calcularIMC());
        System.out.println("persona2" + " tiene un IMC: " + p2.calcularIMC());
        System.out.println("persona3" + " tiene un IMC: " + p3.calcularIMC());

        //Utilizamos el metodo esMayorDeEdad y lo mostramos por pantalla:
        System.out.println("\n¿" + p1.getNombre() + " es mayor de Edad? " + p1.esMayorDeEdad());
        System.out.println("¿" + p2.getNombre() + " es mayor de Edad? " + p2.esMayorDeEdad());
        System.out.println("¿" + p3.getNombre() + " es mayor de Edad? " + p3.esMayorDeEdad()+ "\n");

        p1.toString();
        p2.toString();
        p3.toString();

        /*wtf sdhasni
        Persona persona = new Persona();
        persona.nombre = "Omar";
        persona.edad = 18;
        persona.dni = "23319777P";
        persona.sexo = 'H';
        persona.peso = 72.0;
        persona.altura = 1.77;
        */
        /*
        //Persona 1
        System.out.println("\n Persona 1");
        System.out.println("Nombre "+p1.nombre);
        System.out.println("Edad "+p1.edad+" años");
        System.out.println("DNI "+p1.dni);
        System.out.println("Sexo "+p1.sexo);
        System.out.println("Peso "+p1.peso+" kg");
        System.out.println("Altura: "+p1.altura+ " m");

        //Persona 2
        System.out.println("\n Persona 2");
        System.out.println("nombre: "+p2.nombre);
        System.out.println("edad: "+p2.edad);
        System.out.println("dni: "+p2.dni);
        System.out.println("sexo: "+p2.sexo);
        System.out.println("peso: "+p2.peso+" kg");
        System.out.println("altura: "+p2.altura+" m");


        //Persona3
        System.out.println("\n Persona 3");
        System.out.println("nombre: "+p3.nombre);
        System.out.println("edad: "+p3.edad);
        System.out.println("dni: "+p3.dni);
        System.out.println("sexo: "+p3.sexo);
        System.out.println("peso: "+p3.peso+" kg");
        System.out.println("altura: "+p3.altura+" m");
        */

        entrada.close();
    }


}
