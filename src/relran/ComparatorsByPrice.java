package relran;

import java.util.Comparator;

public class ComparatorsByPrice implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return Long.compare(o1.getPrice(),o2.getPrice());
    }
}
