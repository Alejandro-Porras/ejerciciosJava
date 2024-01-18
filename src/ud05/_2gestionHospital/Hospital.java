package ud05._2gestionHospital;

import ud05._2gestionHospital.Paciente.MaximoEstadoException;

public class Hospital {
    private final int MAXC = 200;
    private Paciente[] listaCamas;
    private int numLibres;

    public Hospital(){
        this.listaCamas= new Paciente[MAXC+1];
        this.numLibres= MAXC;
    }

    public int getNumLibres(){
        return this.numLibres;
    }

    public boolean hayLibres(){
        return this.numLibres>1;
    }

    public int primeraLibre(){
        int pos = 0;
        boolean encontrado = false;
        
        for (int i = 1; i <= MAXC && !encontrado; i++) {
            if (listaCamas[i]==null) {
                pos = i;
                encontrado = true;
            }
        }
        return pos;
    }

    public void ingresarPaciente(String n, int e) throws HospitalLlenoException{
        if (this.hayLibres()) {
            this.numLibres--;
            this.listaCamas[this.primeraLibre()]= new Paciente(n, e);
            System.out.println(n + " ha sido añadido con exito en el hospital.");
        } else {
            throw new HospitalLlenoException();
        }
    }

    static class HospitalLlenoException extends Exception{
        public HospitalLlenoException(){
            super("No hay camas disponibles");
        }
    }

    private void darAltaPaciente(int i){
        for (int j = i; j < MAXC; j++) {
            this.listaCamas[j] = this.listaCamas[j+1];
        }
        this.listaCamas[MAXC] = null; 
        this.numLibres++;
    }

    public void darAltas(){
        for (int i = 1; (i <= MAXC) && (listaCamas[i]!=null); i++) {
            try {
                listaCamas[i].mejorar();
            } catch (MaximoEstadoException e) {
                System.out.println("ERROR : " + e.getMessage());
            }
            
            if (listaCamas[i].getEstado()==6) {
                this.darAltaPaciente(i);
                i--;
            }
        }
    }

    @Override
    public String toString(){
        String str ="Pacientes del hospital:";
        for (int i = 1; (i <= MAXC) && (listaCamas[i]!=null); i++) {
            str += i + ": " + listaCamas[i] + "\n";
        }
        return str;
    }
}
