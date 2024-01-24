import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashEqualsPAir {



    public static void main(String[] args) {
        Pair pair=new Pair(2, 5);
        Pair pair2=new Pair(2, 5);
        Pair pair3=new Pair(3, 5);
        Set<Pair> pairSet=new HashSet<>();
        pairSet.add(pair);
        pairSet.add(pair2);
        System.out.println(pairSet);
        System.out.println(pair2.hashCode());
        System.out.println(pair.hashCode());
        System.out.println(pair3.hashCode());

    }



}

class Pair{
    int elem1,elem2;
    Pair(int elem1,int elem2){
        this.elem1=elem1;
        this.elem2=elem2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return (elem1 == pair.elem1 && elem2 == pair.elem2) || (elem2 == pair.elem1 && elem1 == pair.elem2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elem1, elem2);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "elem1=" + elem1 +
                ", elem2=" + elem2 +
                '}';
    }
}
