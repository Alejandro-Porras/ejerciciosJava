package ud02;

public class Actividad16 {
    private String clave;

    private Actividad16 (){
        this.clave="";
        this.clave += this.generarClave();
        this.clave += this.generarClave();
        this.clave += this.generarClave();
        this.clave += this.generarClave();
        this.clave += this.generarClave();
        this.clave += this.generarClave();
        this.clave += this.generarClave();
        this.clave += this.generarClave();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public char generarClave(){
        return (char)(Math.random()*93+33);
    }

    public static void main(String[] args) {
        Actividad16 password = new Actividad16();
        System.out.println("Contraseña generada aleatoriamente: " + password.getClave());
        password.setClave("SpdtUlAkk");
        System.out.println("contraseña generada manualmente: "+ 
                                password.getClave());
    
    }
}
