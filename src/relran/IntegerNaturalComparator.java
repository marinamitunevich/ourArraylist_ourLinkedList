package relran;

import java.util.Comparator;

public class IntegerNaturalComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        //return Integer.compare(o1,o2);
        return o1-o2;
    }
}
