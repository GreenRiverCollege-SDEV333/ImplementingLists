package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList<ItemType> implements List<ItemType> {

    // WE NEED FIELDS!!

    //one plain old Java array
    private ItemType[] data;

    // one int to keep track of size
    // size is the # of spots that are used in the data array
    // size is DIFFERENT than length (size = indices that are NOT null, length is # of indices in the array)
    private int size;

    public ArrayList() {
        size = 0;
        data = (ItemType[]) new Object[10];
    }

    /**
     * Returns the number of items in this collection.
     *
     * @return the number of items in this collection
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this collection contains no items.
     *
     * @return true if this collection contains no items
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this collection contains the specified item.
     *
     * @param item items whose presence in this collection is to be tested
     * @return true if this collection contains the specified item
     * @throws NullPointerException if the specified item is null
     *                              and this collection does not permit null items
     */
    @Override
    public boolean contains(ItemType item) {
        return indexOf(item) >= 0;
    }

    /**
     * Returns an iterator over the elements in this collection.
     *
     * @return an Iterator over the elements in this collection
     */
    @Override
    public Iterator<ItemType> iterator() {
        return new OurCustomIterator();
    }

    private void checkSize() {
        if (size == data.length) {
            // resize (double up the array size)
            ItemType[] nextData = (ItemType[]) new Object[data.length * 2];
            // loop over the original array and copy its indices over to the new array
            int i = 0;
            for (ItemType it : data) {
                // copy over each index to the new array
                nextData[i] = data [i];
                // increment our counter to move to the next index
                i++;
            }
            // set data equal to the new array (old array will be garbage collected)
            data = nextData;
        }
    }

    /**
     * Adds the specified item to the collection.
     *
     * @param item item to be added to the collection
     * @throws NullPointerException if the specified item is null
     *                              and this collection does not permit null items
     */
    @Override
    public void add(ItemType item) {

        checkSize();
        // array is not capped out, add the specified element to the next available index
        data[size] = item;
        // increment size
        size++;
    }

    /**
     * Removes a single instance of the specified item from this collection,
     * if it is present.
     *
     * @param item item to be removed from this collection, if present
     * @throws NullPointerException if the specified item is null
     *                              and this collection does not permit null items
     */
    @Override
    public void remove(ItemType item) {
        int i = indexOf(item);
        if (i != -1) {
            // if it's found, use the other remove method to do the work
            remove(i);
        }
    }

    /**
     * Removes all items from this collection.
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {
        // lazy deletion
        size = 0;
    }

    /**
     * Returns true if this collection contains all the items
     * in the specified other collection.
     *
     * @param otherCollection collection to be checked for containment in this collection
     * @return true if this collection contains all the items
     * in the specified other collection
     */
    @Override
    public boolean containsAll(Collection<? extends ItemType> otherCollection) {

        for (ItemType it : otherCollection) {
            if (!contains(it)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all the items in this specified other collection to this collection.
     *
     * @param otherCollection collection containing items to be added to this collection
     */
    @Override
    public void addAll(Collection<? extends ItemType> otherCollection) {
        throw new UnsupportedOperationException("Not implemented");

    }

    /**
     * Removes all of this collection's items that are also contained in the
     * specified other collection. After this call returns, this collection will
     * contain no elements in common with the specified other collection.
     *
     * @param otherCollection collection containing elements to be removed
     *                        from this collection
     */
    @Override
    public void removeAll(Collection<? extends ItemType> otherCollection) {

    }

    /**
     * Retains only the items in this collection that are contained in the
     * specified other collection. In other words, removes from this collection
     * all of its items that are not contained in the specified other collection
     *
     * @param otherCollection collection containing elements to be retained in
     *                        this collection
     */
    @Override
    public void retainAll(Collection<? extends ItemType> otherCollection) {

    }

    /**
     * Returns the item at the specified position in this list
     *
     * @param index index of the item to return
     * @return the item at the specified position in this list
     * @throws IndexOutOfBoundsException if this index is out of range
     *                                   (index < 0 || index >= size())
     */
    @Override
    public ItemType get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    /**
     * Replaces the item at the specified position in this list
     * with the specified item
     *
     * @param index index of the item to replace
     * @param item  item to be stored at the specified position
     * @throws NullPointerException      if the specified item is null
     *                                   and this list does not permit null elements
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index < 0 || index >= size())
     */
    @Override
    public void set(int index, ItemType item) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        data[index] = item;
    }

    /**
     * Inserts the specified item at the specified position in this list.
     * Shifts the item currently at that position (if any) and any subsequent
     * items to the right.
     *
     * @param index index at which the specified item is to be inserted
     * @param item  item to be inserted
     * @throws NullPointerException      if the specified item is null
     *                                   and this list does not permit null elements
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index < 0 || index >= size())
     */
    @Override
    public void add(int index, ItemType item) {
        checkSize();
        if (item == null) {
            throw new NullPointerException("Specified item is null");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = item;
        size++;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent items to the left.
     *
     * @param index the index of the item to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index < 0 || index >= size())
     */
    @Override
    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < data.length; i++) {
            data[i] = data[i+1];
        }
        size--;
    }

    /**
     * Returns the index of the first occurrence of the specified item
     * in this list, or -1 if this list does not contain the item.
     *
     * @param item the item to search for
     * @return the index of the first occurrence of the specified item
     * in this list, or -1 if this list does not contain the item
     * @throws NullPointerException if the specified item is null and this
     *                              list does not permit null items
     */
    @Override
    public int indexOf(ItemType item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        // if we got here, it wasn't in the array
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified item
     * in this list, or -1 if this list does not contain the item.
     *
     * @param item the item to search for
     * @return the index of the first occurrence of the specified item
     * in this list, or -1 if this list does not contain the item
     * @throws NullPointerException if the specified item is null and this
     *                              list does not permit null items
     */
    @Override
    public int lastIndexOf(ItemType item) {
        return 0;
    }

    /**
     * Returns a list iterator over the elements in this list
     * (in proper sequence).
     *
     * @return a list iterator over the elements in this list
     * (in proper sequence)
     */
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
            // does not need to be size - 1
            return currentPosition < size();
        }

        @Override
        public ItemType next() {
            ItemType result = get(currentPosition);
            currentPosition++;
            return result;
        }
    }

    private class SecondCustomIterator implements ListIterator<ItemType> {
        // fancier Iterator - lets us go forwards and backwards

        // fields
        private int currentPosition;

        public SecondCustomIterator() {
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

        @Override
        public boolean hasPrevious() {
            return currentPosition > 0;
        }

        @Override
        public ItemType previous() {
            ItemType result = get(currentPosition-1);
            currentPosition--;
            return result;
        }

        @Override
        public int nextIndex() {
            if (currentPosition+1 < size()) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            return currentPosition+1;
        }

        @Override
        public int previousIndex() {
            if (currentPosition-1 < 0) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            return currentPosition-1;
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

} // end of class ArrayList
