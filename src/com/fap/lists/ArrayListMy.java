package com.fap.lists;

import java.util.*;

public class ArrayListMy<V> {

    private Object[] list;
    private int size;

    private static final int DEFAULT_CAPACITY=10;



    public ArrayListMy(int initialCapacity) {
        this.list = new Object[initialCapacity];
    }

    public ArrayListMy() {
        this.list=new Object[DEFAULT_CAPACITY];
    }

    private void checkSize(){
        if (size==list.length){
            int oldCapacity=list.length;
            int newCapacity=oldCapacity+oldCapacity>>1;
            list = Arrays.copyOf(list, newCapacity);
        }
    }

    public boolean add(V value){
        checkSize();
        list[size] = value;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public V get(int index) {
        return (V)list[index];
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean contains(V value){
        return indexOf(value)>=0;
    }


    public int indexOf(V value) {
        for (int i=0; i<size; i++){
            if (value.equals(list[i])){

                return i;
            }
        }
        return -1;
    }

    public V set(int index, V value){
        V oldValue = (V)list[index];
        list[index]=value;
        return oldValue;
    }

    public V remove(int index){

        V oldValue = (V)list[index];
        int numMoved = size - index - 1;
        System.arraycopy(list, index+1, list, index, numMoved);
        size--;
        list[size]=null;

        return oldValue;
    }






    
}
