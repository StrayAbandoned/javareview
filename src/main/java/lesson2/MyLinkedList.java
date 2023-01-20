package lesson2;

import java.util.LinkedList;

public class MyLinkedList <E> {
    private int size;
    private MyLinkedList.Node<E> first;
    private MyLinkedList.Node<E> last;



    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
    }

    private void linkFirst(E object) {
        MyLinkedList.Node<E> f = first;
        MyLinkedList.Node<E> node = new MyLinkedList.Node<>(null, object, f);
        first = node;
        if (f == null)
            last = node;
        else
            f.prev = node;
        size++;
    }

    void linkLast(E e) {
        MyLinkedList.Node<E> last = this.last;
        MyLinkedList.Node<E> node = new MyLinkedList.Node<>(last, e, null);
        this.last = node;
        if (last == null)
            first = node;
        else
            last.next = node;
        size++;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }
    public void add(int index, E element) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Wrong index");
        }
        if (index == size)
            linkLast(element);
        else if(index==0){
            linkFirst(element);
        }
            linkPrevious(element, node(index));
    }
    private void linkPrevious(E e, Node<E> index) {
        final MyLinkedList.Node<E> pred = index.prev;
        MyLinkedList.Node<E> node = new MyLinkedList.Node<>(pred, e, index);
        index.prev = node;
        if (pred == null)
            first = node;
        else
            pred.next = node;
        size++;
    }
    private MyLinkedList.Node<E> node(int index) {
        if (index < (size >> 1)) {
            MyLinkedList.Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            MyLinkedList.Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Wrong index");
        }
        return node(index).item;
    }

    public E delete(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Wrong index");
        }
        return unlink(node(index));
    }

    private E unlink(MyLinkedList.Node<E> x) {
        // assert x != null;
        E element = x.item;
        MyLinkedList.Node<E> next = x.next;
        MyLinkedList.Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }


}
