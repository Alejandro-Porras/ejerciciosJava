package tests.ud07.Comparable_Comparator;

public class Objeto {
    public int a;
    public int b;
    
    public Objeto(int a, int b) {
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
    }
    
