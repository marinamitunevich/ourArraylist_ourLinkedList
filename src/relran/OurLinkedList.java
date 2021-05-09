package relran;

import java.security.PrivateKey;
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
        Node<E> node = NodeByIndex(index);
        return node.elt;
    }

    private Node<E> NodeByIndex(int index) {
        Node<E> node = first;
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
        return null;
    }

    @Override
    public boolean remove(E elt) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E set(int index, E elt) {
        return null;
    }

    @Override
    public boolean contains(E elt) {
        return false;
    }

    @Override
    public void sort(Comparator<E> comparator) {

    }

    @Override
    public E max(Comparator<E> comparator) {
        return null;
    }

    @Override
    public E min(Comparator<E> comparator) {
        return null;
    }

    @Override
    public Iterator<E> backwardIterator() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
