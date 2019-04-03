package com.fap.lists;

import java.util.LinkedList;

public class LinkedListMy<E> {


    int size = 0;

    int modeCount=0;

    Node<E> first;
    Node<E> last;

    public static void main(String[] args) {
        Node<String> first = new Node<String>(null, "ff", null);
        Node<String> middle = new Node<String>(first, "ss", null);
        first.next=middle;
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    void linkLast(E e){

        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l==null)
            first = newNode;
        else
            l.next = newNode;
        size++;

    }

    boolean add(E e){
        linkLast(e);
        return true;
    }



    E unlink(Node<E> x){
        final E element=x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev==null){
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

    boolean remove(Object o){
        if (o == null) {
            for (LinkedListMy.Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (LinkedListMy.Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }



}
