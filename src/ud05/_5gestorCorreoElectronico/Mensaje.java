package ud05._5gestorCorreoElectronico;

public class Mensaje {
    private int codigo;
    private String emisor;
    private String destinatario;
    private String asunto;
    private String texto;
    private static int contador= 1;

    public Mensaje(String emisor, String destinatario, String asunto, String texto){
        this.emisor=emisor;
        this.destinatario=destinatario;
        this.asunto=asunto;
        this.texto=texto;
        this.codigo=contador;
        contador++;
    }

        public int getCodigo() {
            return codigo;
        }

        public String getEmisor() {
            return emisor;
        }

        public String getDestinatario() {
            return destinatario;
        }

        public String getAsunto() {
            return asunto;
        }

        public String getTexto() {
            return texto;
        }

        public static int getContador() {
            return contador;
        }

    public boolean equals(Object o){
        if (this==o) {
            return true;
        }
        if (o==null) {
            return false;
        }
        if (this.getClass()!=o.getClass()){
            return false;
        }
        Mensaje otro = (Mensaje)o;
        return this.getCodigo()==otro.getCodigo();
    }

    public static boolean validarEMail(String email){
        boolean validado = false;
        
        if (email.isEmpty() || email.isBlank() || email.startsWith("@") || email.startsWith(".")) {
            return false;
        }else if (!email.contains("@") || !email.contains(".") || email.contains("@@") || email.contains("..")) {
            return false;
        } else {
            int primerArroba = email.indexOf('@');
            if (email.indexOf("@", primerArroba+1)>primerArroba) {
                return false;
            }else{
                validado = email.indexOf(".", primerArroba+1)>primerArroba+2;
            }
        }
           
        return validado;
    }
        
    @Override
    public String toString() {
        String str ="\n";
        str+="+++++++++++++++++++++++++++++++++++++++++++++++++";
        str+="\n+"+this.getCodigo()+")" ;
        str+="\n+ Emisor: \n"+this.getEmisor();
        str+="\n+ Destinatario: \n"+this.getDestinatario();
        str+="\n+ Asunto: \n"+this.getAsunto();
        str+="\n+ Texto: \n"+this.getTexto();
        str+="\n+++++++++++++++++++++++++++++++++++++++++++++++++";
        return str;
    }

    
        // public static void main(String[] args) {
        //     Mensaje m1 = new Mensaje("paco", "manulo", "caca", "cacota");
        //     Mensaje m2 = new Mensaje("paco", "manulo", "caca", "cacota");

            
        //     System.out.println(m1);
        //     System.out.println(m2);
        // }
    


}
