package tests.ud07.Comparable_Comparator;

public class Objeto2 implements Comparable<Objeto2>{
    public int a;
    public int b;
    
    public Objeto2(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public String toString() {
        return "Objeto{" + "a=" + a + ", b=" + b + '}';
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public int compareTo(Objeto2 o) {
        return (this.getA()+this.getB())-(o.getA()+o.getB());
    }
}
    
