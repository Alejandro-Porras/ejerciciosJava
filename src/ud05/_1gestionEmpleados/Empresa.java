package ud05._1gestionEmpleados;

public class Empresa {
    private final int MAX_EMPLEADOS=10;

    private String nombre;
    private Empleado[] plantilla;
    private int numEmpleados;

    public Empresa (String nombre) {
        this.nombre=nombre;
        this.plantilla=new Empleado [MAX_EMPLEADOS];
        this.numEmpleados = 0;
    }

    public void contratar(Empleado e) throws PlantillaCompletaException{
        if (this.numEmpleados<MAX_EMPLEADOS) {
            this.plantilla[numEmpleados++] = e;
        }else{
            throw new PlantillaCompletaException("La plantilla esta completa");
        }
    }

    public void despedir(Empleado e) throws ElementoNoEncontradoException{
        boolean encontrado = false;
        int posicionEncontrado=0;
        for (int i = 0; i < MAX_EMPLEADOS && !encontrado && plantilla[i]!=null; i++) {
            if (plantilla[i].equals(e)) {
                encontrado = true;
                posicionEncontrado = i;
            }
        }
        if (encontrado) {
                for (int j = posicionEncontrado; j < MAX_EMPLEADOS -1; j++) {
                    plantilla[j] = plantilla[j +1];
                }

                plantilla[MAX_EMPLEADOS-1]=null;

                numEmpleados--;
            }else{
                throw new ElementoNoEncontradoException("Empleado no encontrado");
            }
    }

    public void subirTrienio (double porcentaje){
        for (int i = 0; i < numEmpleados; i++) {
            if (plantilla[i].antiguedad()==3) {
                plantilla[i].incrementarSueldo(porcentaje);
            }
        }
    }

    @Override
    public String toString(){
        String str = "Nombre de la empresa:" + nombre + "\n\nEmpleados:\n\n";
        for (int i = 0; i < numEmpleados; i++) {
            str += plantilla[i].toString() + "\n";            
        }
        return str;
    }

    static class PlantillaCompletaException extends Exception {
        public PlantillaCompletaException(String mensaje){
            super(mensaje);
        }
    }

    static class ElementoNoEncontradoException extends Exception {
        public ElementoNoEncontradoException(String mensaje){
            super(mensaje);
        }
    }
}