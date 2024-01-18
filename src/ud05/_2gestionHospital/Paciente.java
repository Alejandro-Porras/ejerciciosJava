package ud05._2gestionHospital;

public class Paciente {
    private String nombre;
    private int edad;
    private int estado;

    public Paciente (String n, int e){
        this.nombre=n;
        this.edad=e;
        this.estado=(int)(Math.random()*5)+1;
    }

    public int getEdad(){
        return this.edad;
    }

    public int getEstado(){
        return this.estado;
    } 

    public void mejorar() throws MaximoEstadoException{
        if (this.estado<6) {
            this.estado++;
        } else{
            throw new MaximoEstadoException("El estado del paciente no se puede mejorar");
        }
    }

    static class MaximoEstadoException extends Exception{
        public MaximoEstadoException (String m){
            super(m);
        }
    }

    public void empeorar() throws MinimoEstadoException{
        if (this.estado>1) {
            this.estado--;
        }else{
            throw new MinimoEstadoException("El paciente no puede empeorar");
        }
    }

    static class MinimoEstadoException extends Exception{
        public MinimoEstadoException (String m){
            super(m);
        }
    }

    @Override
    public String toString(){
        return this.nombre + " " + this.edad + " " + this.estado;
    }

    public int compareTo(Paciente o){
        return this.estado!=o.estado?this.estado-o.estado:this.edad-o.edad;
    }

    
}
