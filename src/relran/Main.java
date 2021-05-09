package relran;

import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        OurList<Integer> list  = new OurArrayList<>();
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(9);



        list.add(-8);
        list.add(0);
        list.add(-70);
        list.add(20);

        for(int number : list){
            System.out.print(number+" ");
        }

        System.out.println();
        System.out.println("Our List is sorted and iterated in ascending order");
        Comparator<Integer> comparator = new IntegerNaturalComparator();
        list.sort(comparator);

        for(int number : list){
            System.out.print(number+" ");
        }

        System.out.println();
        System.out.println("Our List is iterated in descending order");

        Iterator<Integer> iterator = list.backwardIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }


}
