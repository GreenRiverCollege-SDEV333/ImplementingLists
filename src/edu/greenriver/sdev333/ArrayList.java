package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList<ItemType> implements List<ItemType>{

    private ItemType[] data;

    private int size;

    public ArrayList(){
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
        if(size == 0){
            return true;
        }
        return false;
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
        int i = indexOf(item);
        if(i != -1){
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
        return new OurCustomIterator();
    }

    private void checkSize(){
        if(size == data.length){
            //Step1: Create a new larger Array
            ItemType[] temp = (ItemType[]) new Object[size * 2];

            //Step2: copy items from data to temp
            for(int i = 0; i < size; i++){
                temp[i] = data[i];
            }

            //step3: reference data to point to new array
            data = temp;

            temp = null;
        }//end of if(need to resize)
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
    @Override
    public void remove(ItemType item) {
            int i = indexOf(item);
            if(i != -1){
                //if it is found, use the other remove method to do the work
                remove(i);
            }
    }

    /**
     * Removes all items from this collection.
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {

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
        while (itr.hasNext()){
            ItemType itemToCheck = itr.next();
            if(!contains(itemToCheck)){
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
        if(index >= size){
            throw new IndexOutOfBoundsException("Index is beyond size");
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
        if(index >= size){
            throw new IndexOutOfBoundsException("Index is beyond size");
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

            for(int i = size; i >= index + 1; i--){
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
        for(int i = index; i < size -1; i++){
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
        for (int i = 0; i < size; i++){
            if(item.equals(data[i])){
                return i;
            }
        }
        //if we got here; it wasn't in the array
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
        for( int i = data.length - 1; i >= 0; i--){
            if(item.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }
        ArrayList<ItemType> other = (ArrayList<ItemType>) otherObject;
        if(size != other.size){
            return false;
        }
        for(int i = 0; i < size; i++){
            if(!data[i].equals(other.data[i])){
                return false;
            }
        }
        return true;
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
        return new SecondCustomIterator();
    }

    private class OurCustomIterator implements Iterator<ItemType>{

        private int currentPosition;

        public OurCustomIterator(){
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
    }

    private class SecondCustomIterator implements ListIterator<ItemType>{

        private int currentPosition;

        public SecondCustomIterator(){
            currentPosition = 0;
        }
        @Override
        public boolean hasNext() {
            return currentPosition < size();
        }

        @Override
        public ItemType next() {
            ItemType item = get(currentPosition);
            nextIndex();
            return item;
        }

        @Override
        public boolean hasPrevious() {
            return (size-1) >= 0;
        }

        @Override
        public ItemType previous() {
            ItemType item = get(size-1);
            previousIndex();
            return item;
        }

        @Override
        public int nextIndex() {
            return currentPosition++;
        }

        @Override
        public int previousIndex() {
            return currentPosition--;
        }

        @Override
        public void remove() {
            ArrayList.this.remove(data[size]);
        }

        @Override
        public void set(ItemType itemType) {
            data[size] = itemType;
        }

        @Override
        public void add(ItemType itemType) {
            data[size] = itemType;
        }
    }
}//end of ArrayList