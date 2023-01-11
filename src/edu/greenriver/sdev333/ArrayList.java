package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList<ItemType> implements List<ItemType>{
    //one plain old Java array
    private ItemType[] data;

    //one int to keep track of size
    // ...size is the # of index being used in the data array
    // size != length

    private int size;

    public ArrayList() {
        size = 0;
        data = (ItemType[]) new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(ItemType item) {
        return false;
    }

    @Override
    public Iterator<ItemType> iterator() {
        return null;
    }

    @Override
    public void add(ItemType item) {
        // all above code works until I run out of room
        // when size becomes the same as length
        if(size == data.length) {
            // need to double up array size
            // Step 1 - create a new larger array
            ItemType[] temp = (ItemType[]) new Object[size * 2];

            // Step 2 - copy items from data to temp
            for(int i = 0; i < size; i++) {
                temp[i] = data[i];
            }

            // Step 3 - repoint/reference data to the point to new array
            data = temp;

            // optional
            temp = null;
        } // end of if
        data[size] = item;
        size++;
    } // end of method

    @Override
    public void remove(ItemType item) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsAll(Collection<? extends ItemType> otherCollection) {
        return false;
    }

    @Override
    public void addAll(Collection<? extends ItemType> otherCollection) {

    }

    @Override
    public void removeAll(Collection<? extends ItemType> otherCollection) {

    }

    @Override
    public void retainAll(Collection<? extends ItemType> otherCollection) {

    }

    @Override
    public ItemType get(int index) {
        return null;
    }

    @Override
    public void set(int index, ItemType item) {

    }

    @Override
    public void add(int index, ItemType item) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int indexOf(ItemType item) {
        return 0;
    }

    @Override
    public int lastIndexOf(ItemType item) {
        return 0;
    }

    @Override
    public ListIterator<ItemType> listIterator() {
        return null;
    }
}
