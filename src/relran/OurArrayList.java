package relran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class OurArrayList <E> implements OurList<E>{

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Object[] source;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }
    //O(1)
    @Override
    public E get(int index) {
        sizeCheck(index);
        return (E) source[index];
    }
    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
        //source = Arrays.copyOf(source,source.length*2);
    }
//O(1)
    @Override
    public void add(E elt) {
        if (size == source.length)
            increaseCapacity();

        source[size] = elt;
        size++;

    }
//O(n)
    @Override
    public E remove(int index) {

        sizeCheck(index);
        E oldValue = (E) source[index];
        int numMoved = size - index -1;
        if(numMoved > 0)
            System.arraycopy(source,index+1,source,index,numMoved);
        source[--size]= null;

        return oldValue;
    }

    private void sizeCheck(int index)  {

        if(index >= size || index < 0){
            throw  new IndexOutOfBoundsException("the index is out the list size.....");
        }
    }
//O(n)
    @Override
    public boolean remove(E elt) {

//        for(int i = 0; i<source.length; i++){
//            if((E)source[i] == elt) {
//                remove(i);
//                return true;
//            }
//    }
        int index = findIndexOfElement(elt);//O(n)
        if(index == -1)
            return false;
        remove(index);//O(n)
        return true;
        // return false;
        }

    @Override
    public int size() {
        return size;
    }
//0 1
    @Override
    public E set(int index, E elt) {

        sizeCheck(index);
        E oldValue = (E) source[index];
        source[index] =  elt;
        return oldValue;

    }
    private  int findIndexOfElement(E elt){
        if(elt == null) {
            for (int i = 0; i < size; i++) {
                if(source[i] == null)
                    return i;

            }
            return -1;
        }else {
            for (int i = 0; i < size; i++) {
                if(elt.equals(source[i]))
                    return i;

            }
            return  -1;
        }

    }
//O(n)
    @Override
    public boolean contains(E elt) {

//        for(int i = 0; i < source.length; i++){
//            if((E)source[i] == elt)
//                return true;
//        }
//        return false;
        return findIndexOfElement(elt) != -1;
    }
    @Override
    public void sort(Comparator<E> comparator){
        E element ;
        for(int j = 0; j < size -1; j++) {
            for (int i = j+1; i < size; i++) {
                if (comparator.compare((E) source[j], (E) source[i]) > 0) {
                    element = (E) source[j];
                    source[j] = source[i];
                    source[i] = element;
                }
            }
        }
//        for(int  i = 0 ;i<size;i++){
//            int minindex = i;
//            E min = (E) source[i];
//            for(int j = i+1; j < size;j++){
//                E currentMin = (E) source[minindex];
//                if(comparator.compare(min,(E)source[j])>0){
//                    minindex = j;
//
//                }
//                E temp = (E) source[i];
//                source [i] =source[minindex];
//                source[minindex] = temp;
//            }
//        }

    }
    @Override
    public E max(Comparator<E> comparator){
        E max = (E)source[0];
        for (int i = 0; i<size; i++){
            if(comparator.compare(max,(E)source[i])<0){
                max = (E)source[i];
            }
        }
        return max;
    }
    @Override
    public E min(Comparator<E> comparator){
        E min = (E)source[0];
        for (int i = 0; i<size; i++){
            if(comparator.compare(min,(E)source[i])>0){
                min = (E)source[i];
            }
        }
        return min;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new ForwardIterator<>((E[])source,this.size);
        return iterator;
    }

    @Override
    public Iterator<E> backwardIterator() {
        Iterator<E> iterator = new BackwardIterator<>((E[])source,this.size);
        return iterator;
    }

    private static class BackwardIterator<T> implements Iterator<T>{

        private int position;
        private T[] source;
        private int size ;

        BackwardIterator(T[] source, int size){
            this.source = source;
            this.position = size-1;
            this.size = size;

        }

        @Override
        public boolean hasNext() {
            return position >= 0;
        }

        @Override
        public T next() {
            if(position < 0){
                throw new IndexOutOfBoundsException();
            }
            T a = source[position];
            position--;
            return a;
        }
    }
    private static class ForwardIterator<T> implements Iterator<T>{
        private int position;
        private T[] source;
        private int size ;
        ForwardIterator(T[] source, int size){
            this.source = source;
            this.position = 0;
            this.size = size;

        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
            if(position >= size){
                throw new IndexOutOfBoundsException();
            }
            T a = source[position];
            position++;
            return a;
        }
    }
}
