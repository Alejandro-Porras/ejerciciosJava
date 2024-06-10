package ud08.test.punto;

public class Rectangulo {
    private Punto vertice1;
    private Punto vertice2;

    // Constructor sin argumentos
    // crea rectangulo en vertice1 = (0,0)
    // y vertice2 = (1,1)
    public Rectangulo(){
        this.vertice1 = new Punto();
        this.vertice2 = new Punto(1,1);
    }

    // Constructor con argumentos
    public Rectangulo(Punto v1, Punto v2){
        this.vertice1 = v1;
        this.vertice2 = v2;
    }

    // Constructor con argumentos x1 y1, x2 y2
    public Rectangulo(double x1, double y1, double x2, double y2){
        this.vertice1 = new Punto(x1, y1);
        this.vertice2 = new Punto(x2, y2);
    }

    // Constructor copia
    public Rectangulo(Rectangulo r){
        this.vertice1 = new Punto(r.getVertice1());
        this.vertice2 = new Punto(r.getVertice2());
    }

    public Punto getVertice1(){
        return new Punto(vertice1);
    }

    public Punto getVertice2(){
        return new Punto(vertice2);
    }

    public double calcularPerimetroRectangulo(){
        return Math.abs(this.vertice2.getX() - this.vertice1.getX()) * 2 + 
                Math.abs(this.vertice2.getY()-this.vertice1.getY()) * 2;
    }

    public double calcularAreaRectangulo(){
        return Math.abs(this.vertice2.getX() - this.vertice1.getX()) * 
                Math.abs(this.vertice2.getY()-this.vertice1.getY());
    }

    @Override
    public String toString(){
        return "Rectangulo:\n" + 
                "\tVértice 1: " + this.getVertice1() + "\n" + 
                "\tVértice 2: " + this.getVertice2();
    };
}
