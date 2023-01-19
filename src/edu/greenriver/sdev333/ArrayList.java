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
    public ArrayList(int capacity) {
        size = 0;
        data = (ItemType[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
        /*
        Or
        if(size == 0) {
            return true
        } return false
         */
    }

    @Override
    public boolean contains(ItemType item) {
        int i = indexOf(item);
        if (i != -1) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<ItemType> iterator() {
        return new OurCustomIterator();
    }

    private void checkSize() {
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

    }
    @Override
    public void add(ItemType item) {
        checkSize();
        data[size] = item;
        size++;
    } // end of method

    @Override
    public void remove(ItemType item) {
        int i = indexOf(item);
        if(i != -1) {
            // if within index use other remove method to do work
            remove(i);
        }
    }

    @Override
    public void clear() {
        // lazy deletion
        size = 0;
    }

    @Override
    public boolean containsAll(Collection<? extends ItemType> otherCollection) {
        Iterator<ItemType> itr = (Iterator<ItemType>) otherCollection.iterator();
        while(itr.hasNext()) {
            ItemType itemToCheck = itr.next();
            if(contains(itemToCheck)) {
                return false;
            }
        }

        return true;

//        for (ItemType itemToCheck : otherCollection) {
//            if(!contains(itemToCheck)) {
//                return false;
//            }
//        } return true; this way is shorter

        //throw new UnsupportedOperationException("Not Implemented"); // fail fast , fail loud
        //return false;

    }

    @Override
    public void addAll(Collection<? extends ItemType> otherCollection) {
        throw new UnsupportedOperationException("No. t gonna do it!");
    }

    @Override
    public void removeAll(Collection<? extends ItemType> otherCollection) {

    }

    @Override
    public void retainAll(Collection<? extends ItemType> otherCollection) {

    }

    @Override
    public ItemType get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }
        return data[index];
    }

    @Override
    public void set(int index, ItemType item) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }
        data[index] = item;
    }

    @Override
    public void add(int index, ItemType item) {
        if(item.equals(null)) {
            throw new NullPointerException();
        } else if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        checkSize();
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = item;
        size++;

    }

    @Override
    public void remove(int index) {
        //shift values left to overwrite the item at index
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public int indexOf(ItemType item) {

       for (int i = 0; i < size; i++) {
           if(item.equals(data[i])) {
               return i;
           }
       } return  -1; // if not then return -1
    }

    @Override
    public int lastIndexOf(ItemType item) {
        for (int i = size ; i >= 0; i--) {
            if(item.equals(data[i])) {
                return i;
            }
        } return - 1;
    }
    @Override
    public ListIterator<ItemType> listIterator() {

        return null;
    }

    private class OurCustomIterator implements Iterator<ItemType> {
        // fields
        private int currentPosition;

        public OurCustomIterator() {
            currentPosition = 0;
        }
        @Override
        public boolean hasNext() {
            return currentPosition < size();
        }

        @Override
        public ItemType next() {
            ItemType result = get(currentPosition);
            currentPosition++;
            return result;
        }
    } // end of OurCustomIterator class

    private class SecondCustomIterator implements ListIterator<ItemType> {
        // fancier Iterator-lets us go forwards and backwards
        private int currentPosition;

        public SecondCustomIterator() {
            currentPosition = 0;
        }
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public ItemType next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            // hasNext checked currentPosition with size
            // hasPrevious check currentPosition against 0
            return false;
        }

        @Override
        public ItemType previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(ItemType itemType) {

        }

        @Override
        public void add(ItemType itemType) {

        }

    }
}// end of ArrayList class
