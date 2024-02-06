package tests.test_v2;

import java.util.Scanner;

public class Examen {
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    //Setters and Getters
     public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    //Constructores.Valores por defecto Mis datos
    public Examen (){
        this.nombre = "Marco";
        this.edad = 18;
        this.sexo = 'H';
        this.DNI = "31046911Q";
        this.peso = 85;
        this.altura = 1.70;
    }
    //Constructores.Insertar valores al crearlo
    public Examen (String nombre, int edad, char sexo, String DNI,
                    double peso, double altura){

        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.DNI = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    //Metodos
    public String calcularIMC(){
        double calculo;
        String pesoIdeal;

        calculo =(peso/(Math.pow(altura,2)));
            if (calculo < 20) {
                pesoIdeal = "Bajo Peso";
            } else if (calculo <= 25) {
                pesoIdeal = "Peso ideal";
            } else {
                pesoIdeal = "Sobre Peso";
            }
            return pesoIdeal;
    }

    public boolean esMayorDeEdad (){
        
        if (edad < 18) {
            return false;
        }
        return true;
    }

    @Override
    public String toString (){
        return "\n+--------------------------\n" +
               "| Persona\n" + 
               "|\n" +
               "|Nombre:" + "    " + this.nombre + "\n" +
               "|Edad:" + "      " + this.edad + "\n" +
               "|Sexo:" + "      " + this.sexo + "\n" +
               "|DNI:" + "       " + this.DNI + "\n" +
               "|Peso:" + "      " + this.peso + "\n" +
               "|Altura:" + "    " + this.altura + "\n" +
               "+--------------------------\n";
    }
    public static void main(String[] args) {
        //Variables
        Scanner input = new Scanner(System.in);
        String nombre;
        int edad;
        char sexo;
        String DNI;
        double peso;
        double altura;
        
        //Creamos un objeto por defecto y uno con atributos datos en el constructor
        Examen persona1 = new Examen();
        Examen persona2 = new Examen("Juanjo",29,'H',"31046911Q",140,1.90);

        System.out.println("Crearemos a una persona, introduce sus datos: ");
        System.out.println("Introduce el nombre: ");
        nombre = input.next();
        System.out.println("Introduce la edad: ");
        edad = input.nextInt();
        System.out.println("Introduce el sexo, H(hombre) o M(mujer): ");
        sexo = input.next().charAt(0);

        System.out.println("Introduce el DNI sin letra: ");
        DNI = input.next();

        System.out.println("Introduce el peso: ");
        peso = input.nextDouble();
        System.out.println("Introduce la altura: ");
        altura = input.nextDouble();

        //Creamos otra persona pero con los datos dados
        Examen persona3 = new Examen(nombre,edad,sexo,DNI,peso,altura);
    
        System.out.println(persona1.toString());
        System.out.println(persona1.nombre + " tiene un IMC: " + persona1.calcularIMC());
        System.out.println(persona1.nombre + " es mayor de edad?: " + persona1.esMayorDeEdad());
        
        System.out.println(persona2.toString());
        System.out.println(persona2.nombre + " tiene un IMC: " + persona2.calcularIMC());
        System.out.println(persona2.nombre + " es mayor de edad?: " + persona2.esMayorDeEdad());
        
        System.out.println(persona3.toString());
        System.out.println(persona3.nombre + "tiene un IMC: " + persona3.calcularIMC());
        System.out.println(persona3.nombre + "es mayor de edad?: " + persona3.esMayorDeEdad());
        
    input.close();
    }
   
}
