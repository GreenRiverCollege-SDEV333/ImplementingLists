package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class ArrayList<ItemType> implements List<ItemType>{
//WE NEED FIELDS

    //one java array
    private ItemType[] data;

    //size (# of spots being used by data array)
    private int size;

    public ArrayList() {
        data = (ItemType[]) new Object[10];
        size = 0;
    }
    public ArrayList(int size) {
        this.size = size;
        data = (ItemType[]) new Object[size];

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
        if(indexOf(item) != -1){
            return true;
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this collection.
     *
     * @return an Iterator over the elements in this collection
     */
    @Override
    public Iterator<ItemType> iterator() {
        return new OurIterator();
    }
    private void checkSize(){
        if(size == data.length){
            //create larger array
            ItemType[] temp = (ItemType[]) new Object[(size * 2)];

            //copy data items to temp
            for(int i =0; i < size; i++){
                temp [i] = data[i];
            }

            //repoint data to temp
            data = temp;

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
        data[size] = item;
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
    //do this one
    @Override
    public void remove(ItemType item) {
        int index = indexOf(item);
        if(index != -1) {
            remove(index);
        }
    }

    /**
     * Removes all items from this collection.
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {
        data = (ItemType[]) new Object[10];
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
        Iterator<ItemType> itr = (Iterator<ItemType>)otherCollection.iterator();
        while (itr.hasNext()) {
            ItemType cur = itr.next();
            if(!contains(cur)){
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
        for (ItemType  item :
            otherCollection) {
            add(item);
        }
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
        for (ItemType  item :
                otherCollection) {
            remove(item);
        }
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
    public boolean isValidIndex(int index){
        return index < size;
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
        if(!isValidIndex(index)){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            return data[index];
        }
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
        if(!isValidIndex(index)){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            data[index] = item;
        }
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
        for (int i = size; i >= index + 1; i--) {
            data[i] = data[i - 1];
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
        for (int i = index; i < size-1; i++){
            data[i] = data[i+1];
        }
        data[size - 1] = null;
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
            if (data[i].equals(item)) {
                return i;
            }
        }
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
        for (int i = size; i >= 0; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
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

    private class OurIterator implements Iterator<ItemType>{
        private int current;

        public OurIterator() {
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public ItemType next() {
            ItemType next = get(current);
            current++;
            return next;

        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super ItemType> action) {
            Iterator.super.forEachRemaining(action);
        }
    }

    private class SecondOurIterator implements ListIterator<ItemType>{
        int current;

        public SecondOurIterator() {
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public ItemType next() {
            ItemType next = get(current);
            current++;
            return next;
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public ItemType previous() {
            if(hasPrevious()){
                ItemType a = get(current--);
                return a;
            }
            return null;
        }

        @Override
        public int nextIndex() {
            if(hasNext()) {
                return current++;
            }
            return -1;
        }

        @Override
        public int previousIndex() {
            if(hasPrevious()){
                return current--;
            }
            return -1;
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
}//end of ArrayList
