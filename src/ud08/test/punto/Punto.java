package ud08.test.punto;

public class Punto {
    private double x;
    private double y;

    // Constructor sin argumentos
    // Crea un punto en (0,0)
    public Punto(){
        this.x = 0;
        this.y = 0;
    }

    // Constructor con argumentos
    // Crea un punto en (x,y)
    public Punto (double x, double y){
        this.x = x;
        this.y = y;
    }

    // Constructor copia
    // Clona el punto p
    public Punto (Punto p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    @Override
    public String toString(){
        return "Punto (" + this.getX() + ", "+ this.getY() + ")";
    };
}
