package ud02;

import java.util.Calendar;

public class Estudiante {
    int nia;
    String nombre;
    int edad;
    String telefono;
    Calendar inscripcion;

    //constructores
    public Estudiante(){
        this.inscripcion = Calendar.getInstance();
    }

    public Estudiante(String nombre){
        this.nombre = nombre;
        this.inscripcion = Calendar.getInstance();
    }

    public Estudiante(int nia, String nombre, int edad, String telefono, Calendar inscripcion){
        this.nia = nia;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.inscripcion = Calendar.getInstance();
    }
        //setters and getters
        public int getNia() {
            return nia;
        }

        public void setNia(int nia) {
            this.nia = nia;
        }

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

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getInscripcion() {
            return this.inscripcion.get(Calendar.DAY_OF_MONTH) + 
                    "/" + (this.inscripcion.get(Calendar.MONTH)+1) + 
                    "/" + this.inscripcion.get(Calendar.YEAR) + 
                    "   " + this.inscripcion.get(Calendar.HOUR_OF_DAY) + 
                    ":" + this.inscripcion.get(Calendar.MINUTE) + 
                    ":" + this.inscripcion.get(Calendar.SECOND);
        }

        public void setInscripcion(Calendar inscripcion) {
            this.inscripcion = inscripcion;
        }

    @Override
    public String toString(){
        
        return "******************\n" +
                "Estudiante: "+ this.nia +
                "\n\tInscripcion: " + this.getInscripcion() +
                "\n\tNombre: "+ this.nombre +
                "\n\tEdad: "+ this.edad +
                "\n\tTelefono: "+ this.telefono +
                "\n******************";
    }

    public static void main(String[] args) throws InterruptedException {
        Estudiante estudiante01= new Estudiante();
        System.out.println(estudiante01.toString());
        Thread.sleep(5000);
        Estudiante estudiante02= new Estudiante("Jose");
        System.out.println(estudiante02.toString());
    }
}
