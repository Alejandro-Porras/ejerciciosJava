package examen1;

public class Hospital {
    //Creamos todas las variables que vamos a utilizar.
    private int codHospital;
    private String nombreHospital;
    private String direccion;
    private int telefono;
    private String poblacion;
    private int codPostal;
    private int habitacionesTotales;
    private int habitacionesOcupadas;

    //Creamos el objeto Hospital.
    public Hospital(int codHospital, String nombreHospital, String direccion, int telefono,
    String poblacion, int codPostal, int habitacionesTotales, int habitacionesOcupadas){
        this.codHospital=codHospital;
        this.nombreHospital=nombreHospital;
        this.direccion=direccion;
        this.telefono=telefono;
        this.poblacion=poblacion;
        this.codPostal=codPostal;
        this.habitacionesTotales=habitacionesTotales;
        this.habitacionesOcupadas=habitacionesOcupadas;
    }

    //Creamos el metodo para sumar 1 las habitaciones ocupadas (si son < las maximas).
    public boolean ingresoHospital(){
       if (this.habitacionesOcupadas<habitacionesTotales) {
        habitacionesOcupadas++;
       }
       return this.habitacionesOcupadas<habitacionesTotales;
    }

    //Creamos el metodo para restar 1 las habitaciones ocupadas (si son >0).
    public boolean altaHospital(){
       if (this.habitacionesOcupadas>0) {
        habitacionesOcupadas--;
       }
       return this.habitacionesOcupadas>1;
    }

    // Creamos el metodo toString para ver todos los datos de la instancia.
    @Override

    public String toString(){
        return  "\n Hospital{codHospital=" + this.codHospital + ", nombreHospital=" +
                 this.nombreHospital + ",\n" + //
                "direccion=" + this.direccion + ", telefono=" + this.telefono +
                 ", poblacion=" + this.poblacion + ",\n" + //
                "codPostal=" + this.codPostal +", habitacionesTotales=" + 
                this.habitacionesTotales +", habitacionesOcupadas=" + this.habitacionesOcupadas + "}\n";
    }

    //Creacion de los getters y setters.
    public int getCodHospital() {
        return codHospital;
    }

    public void setCodHospital(int codHospital) {
        this.codHospital = codHospital;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public int getHabitacionesTotales() {
        return habitacionesTotales;
    }

    public void setHabitacionesTotales(int habitacionesTotales) {
        this.habitacionesTotales = habitacionesTotales;
    }

    public int getHabitacionesOcupadas() {
        return habitacionesOcupadas;
    }

    public void setHabitacionesOcupadas(int habitacionesOcupadas) {
        this.habitacionesOcupadas = habitacionesOcupadas;
    }

    //El main donde se ejecuta todo.
    public static void main(String[] args) {
        //Instanciamos el objeto Hospital.
        Hospital hospitalRibera = new Hospital(1, "Hospital de La Ribera",
         "C/ Mayor, 1", 962990033, "Alzira", 46660, 5,
          0);

        //Por pantalla aparecerá que el objeto a sido creado.
        System.out.println("\nObjeto hospital '" + hospitalRibera.getNombreHospital() +"' creado.");
        
        //Colocamos las nuevas habitaciones totales.
        hospitalRibera.setHabitacionesTotales(10);
        
        //Mostramos por pantalla que se ha realizado un cambio y el nuevo numero.
        System.out.println("\nCambio a " + hospitalRibera.habitacionesTotales + " habitaciones totales para " 
        + hospitalRibera.getNombreHospital());

        //Utilizamos el metodo de ingreso.
        hospitalRibera.ingresoHospital();

        //Mostramos por pantalla el nuevo numero de habitaciones.
        System.out.println("\n+Ingreso en hospital: " + hospitalRibera.habitacionesOcupadas + 
        " habitaciones ocupadas de " + hospitalRibera.habitacionesTotales + " habitaciones totales.");

        //Utilizamos el metodo de alta.
        hospitalRibera.altaHospital();

        //Mostramos por pantalla el nuevo numero de habitaciones.
        System.out.println("\n-Alta en hospital: " + hospitalRibera.habitacionesOcupadas + 
        " habitaciones ocupadas de " + hospitalRibera.habitacionesTotales + " habitaciones totales.");

        //Por ultimo, mostramos con el toString todas las instancias.
        System.out.println(hospitalRibera.toString());

    }
}
