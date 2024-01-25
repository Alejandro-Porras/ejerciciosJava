package ud05._6juegoDeCartas;

public class Carta {
    private int palos;
    private int valor;
    public static final int OROS = 0;
    public static final int COPAS = 1;
    public static final int ESPADAS = 2;
    public static final int BASTOS = 3;

    public final static String[] PALOS= {"oros", "copas", "espadas", "bastos"};

    public Carta(){
        this.palos= (int)(Math.random()*4);
        this.valor= (int)(Math.random()*12+1);
    }

    public Carta(int palo, int valor) throws IllegalArgumentException{
        if (palo<=BASTOS&&palo>=OROS && valor<=12 && valor>=1) {
            this.palos=palo;
            this.valor=valor;
        } else {
            throw new IllegalArgumentException("ERROR! No has añadido un valor correcto");
        }
    }

    public int getPalos() {
        return palos;
    }

    public void setPalos(int palos) {
        this.palos = palos;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public static int getOros() {
        return OROS;
    }

    public static int getCopas() {
        return COPAS;
    }

    public static int getEspadas() {
        return ESPADAS;
    }

    public static int getBastos() {
        return BASTOS;
    }

    public int compareTo(Carta o){
        int calculo= 0;
        if (this.getPalos()!=o.getPalos()) {
            calculo = this.getPalos()-o.getPalos();
        } else {
            calculo = this.getValor()-o.getValor();
        }
        return calculo;
    }

    public boolean equals(Carta o){
        if (this==o) {
           return true; 
        }
        if(o==null){
            return false;
        }
        return this.getPalos()==o.getPalos() && this.getValor()==o.getValor();
    }

    public Carta sigPalo (){
        Carta c1;
        if (this.palos<3) {
            c1= new Carta(this.palos+1, this.valor);
        }else{
            c1= new Carta(0, this.valor);
        }

        return c1;
    }

    @Override
    public String toString() {
        return this.getValor()+" de "+PALOS[this.getPalos()];
    }

    // public static void main(String[] args) {
    //     Carta c1 = new Carta(3, 11);
    //     Carta c2 = new Carta(0, 12);

    //     System.out.println(c1);

    //     System.out.println(c2);

    //     System.out.println(c1.compareTo(c2));

    //     System.out.println(c1.equals(c2));
    // }
}
