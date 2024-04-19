package tests.ud07.Comparable_Comparator;

import java.util.Comparator;

public class ObjetoComparator implements Comparator<Objeto>{
    
    @Override
    public int compare(Objeto o1, Objeto o2) {
        return (o2.getA()+o2.getB())-(o1.getA()+o1.getB());
    }
}
