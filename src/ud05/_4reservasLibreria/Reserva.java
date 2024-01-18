package ud05._4reservasLibreria;

public class Reserva {
    private String nif;
    private String nombre;
    private String tel;
    private int codigo;
    private int ejemplares;

    public Reserva(String nif, String nombre, String tel, int codigo, int
    ejemplares){
        this.nif=nif;
        this.nombre=nombre;
        this.tel=tel;
        this.codigo=codigo;
        this.ejemplares=ejemplares;
    }

    public Reserva(String nif, String nombre, String tel, int codigo){
        this.nif=nif;
        this.nombre=nombre;
        this.tel=tel;
        this.codigo=codigo;
        this.ejemplares=1;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTel() {
        return tel;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares){
        this.ejemplares=ejemplares;
    }
    
    @Override
    public String toString() {
        return "\nnif: \r\t\t\t" + this.nif +
                "\nnombre: \r\t\t\t" + this.nombre+
                "\nTelefono: \r\t\t\t" + this.tel+
                "\nCodigo: \r\t\t\t" + this.codigo+
                "\nEjemplares: \r\t\t\t" + this.ejemplares;
    }

    public boolean equals(Object o){
        if (this==o) {
            return true;
        }
        if (o==null) {
            return false;
        }
        if (this.getClass()!=o.getClass()) {
            return false;
        }
        final Reserva otro =(Reserva) o;
        return this.getNif().equals(otro.getNif())&&this.getCodigo()==otro.getCodigo();
    }

    public int compareTo(Object o){
        final Reserva otro =(Reserva) o;
        //return this.getCodigo()<otro.getCodigo()?this.getCodigo():otro.getCodigo();
        return this.getCodigo()-otro.getCodigo();
    }
}
