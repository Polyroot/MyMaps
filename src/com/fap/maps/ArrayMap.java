package com.fap.maps;

public class ArrayMap<K,V> {

    private Object[][] pairs;
    int index;

    public ArrayMap(int length) {
        pairs = new Object[length][2];

    }

    public void put(K key, V value){
        index++;
        if (index >= pairs.length) throw new ArrayIndexOutOfBoundsException();
        pairs[index] = new Object[]{key, value};
    }

    public V get(K key){

        for (int i=0; i < index; i++)
            if (pairs[i][0] == key)
                return (V) pairs[i][1];
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<index; i++){
            stringBuilder.append(pairs[i][0]);
            stringBuilder.append(" : ");
            stringBuilder.append(pairs[i][1]);
            if (i<index-1) stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
