package relran;

import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class OurLinkedList<E> implements OurList<E>{

    private static class Node<E>{
        Node<E> prev;
        Node<E> next;
        E elt;
        public Node(E elt, Node<E> next, Node<E> prev) {
            this.elt = elt;
            this.next = next;
            this.prev = prev;
        }
    }
    private int size;

    Node<E> first;
    Node<E> last;

    @Override
    public E get(int index) {
        Node<E> node = nodeByIndex(index);
        return node.elt;
    }

    private Node<E> nodeByIndex(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<E> currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public void add(E elt) {
        Node<E> newNode = new Node<>(elt,null,null);
        if(size == 0) {
            last = first = newNode;
        } else{
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;

    }

    @Override
    public E remove(int index) {
        Node <E> toRemove = nodeByIndex(index);
        E res =toRemove.elt;
        removeNode(toRemove);
        return res;
    }

    @Override
    public boolean remove(E elt) {
        Node<E> toRemove = findNodeByElt(elt);
        if(toRemove == null)
            return false;
        removeNode(toRemove);
        return true;
    }

    private void removeNode(Node<E> toRemove) {
        Node<E> prev = toRemove.prev;
        Node<E> next = toRemove.next;
        if(next == null){
            last = prev;
        }else{
            next.prev = prev;
        }
        if(prev == null){
            first = next;
        }else{
            prev.next = next;
        }
        toRemove.elt = null;
        toRemove.next = null;
        toRemove.prev = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E set(int index, E elt) {
        E oldElement = nodeByIndex(index).elt;

        Node<E> needle = nodeByIndex(index);
        needle.elt = elt;
        return oldElement;

    }

    @Override
    public boolean contains(E elt) {
        Node<E> needle = findNodeByElt(elt);
        return needle != null;
    }

    /**
     * the method finds a node with the element inside equals to the 'elt'
     * @param elt
     * @return the node with the element inside equals to the 'elt' if exits or null
     */
    private Node<E> findNodeByElt(E elt) {
        Node<E> currentNode =first;
        if(elt == null){
            while (currentNode != null){
               if(currentNode.elt == null)
                   return currentNode;
               currentNode = currentNode.next;
           }
        }else{
            while (currentNode!= null){
                if(elt.equals(currentNode.elt))
                    return currentNode;
                currentNode = currentNode.next;
            }

        }
        return null;
    }

    @Override
    public void sort(Comparator<E> comparator) {
        E[] array = toArray();
        Arrays.sort(array,comparator);

        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            current.elt = array[i];
            current = current.next;
        }

    }

    private E[] toArray() {
        Object[] copy = new Object[size];

        Iterator<E> iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            copy[i] = iterator.next();
            i++;
        }
        return (E[]) copy;
    }


    @Override
    public E max(Comparator<E> comparator) {
        E[] array = toArray();
        E max = array[0];
        for (int i = 1; i<size; i++){
            if(comparator.compare(max,array[i])<0){
                max = array[i];
            }
        }
        return max;
    }

    @Override
    public E min(Comparator<E> comparator) {
        return max(comparator.reversed());
    }

    @Override
    public Iterator<E> backwardIterator() {
        Iterator<E> iterator = new BackwardIterator<>(this.last);
        return iterator;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new ForwardIterator<>(this.first);
        return iterator;
    }
    //----------------------------------------------------------------
    private static class BackwardIterator<T> implements Iterator<T>{

        Node<T> current;

        public BackwardIterator(Node<T> last) {
            this.current = last;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T res = current.elt;
            current = current.prev;
            return res;
        }
    }
 //------------------------------------------------------------------------
    private static class ForwardIterator<T> implements Iterator<T>{

        Node<T> current;

        public ForwardIterator(Node<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T res = current.elt;
            current = current.next;
            return res;
        }
    }
}
