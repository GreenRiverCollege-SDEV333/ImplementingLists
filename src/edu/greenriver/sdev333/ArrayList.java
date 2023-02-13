package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList<ItemType> implements List<ItemType> {
    // WE NEED FIELDS

    // one plain old Java array
    private ItemType[] data;

    // one int to keep track of size

    // size is number of spots that are not NULL
    // size is different than length
    private int size;


    /**
     * Constructor initializing private fields
     */
    public ArrayList(){
        size = 0;
        data = (ItemType[]) new Object[10];
    }

    /**
     * Second constructor that allows the client to ask for an initial capacity for
     * the underlying data array (instead of using our default of 10)
     * @param capacity the capacity
     */
    public ArrayList(int capacity){
        size = 0;
        data = (ItemType[]) new Object[capacity];
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
        if ( item == null ){
            throw new NullPointerException("Item cannot be null");
        }
        int i = indexOf(item);
        if ( i != -1 ) {
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

    /**
     * Adds the specified item to the collection.
     *
     * @param item item to be added to the collection
     * @throws NullPointerException if the specified item is null
     *                              and this collection does not permit null items
     */
    @Override
    public void add(ItemType item) {

        // HOWEVER: when size becomes length - we run out of room
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
        if ( item == null ){
            throw new NullPointerException("Item cannot be null");
        }
        int i = indexOf(item);
        if( i != -1 ){
            remove(i);
        }
    }

    /**
     * Removes all items from this collection.
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {
        // lazy deletion =
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

        Iterator<ItemType> itr = (Iterator<ItemType>) otherCollection.iterator();
        while (itr.hasNext()){
            ItemType itemToCheck = itr.next();
            if (!contains(itemToCheck)){
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
            throw new IndexOutOfBoundsException("index is beyond size");
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
            throw new IndexOutOfBoundsException("index is beyond size");
        }
        data[index] = item;
    }



    public void addToFront(ItemType item) {
        // create larger array just in case
        ItemType[] temp = (ItemType[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        size++;

        temp[0] = item;
        for (int i = 1; i < size; i++) {
            temp[i] = data[i - 1];
        }
        data = temp;
    }

    public void addToBack(ItemType item) {
        // create larger array just in case
        ItemType[] temp = (ItemType[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        size++;

        temp[size - 1] = item;
        data = temp;
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
    // focus on trying this one

        if ( index < 0 || index >= size() ){
            throw new IndexOutOfBoundsException("Please enter a valid number");
        }
        if ( item == null ){
            throw new NullPointerException("Item cannot be null");
        }

        checkSize();

        for (int i = size; i >= index + 1; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;

    }


    @Override
    public void remove(int index) {
        // shift values left to overwrite the item at index
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
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
        if ( item == null ){
            throw new NullPointerException("Item cannot be null");
        }

        for (int i = 0; i < size; i++) {
            if ( item.equals(data[i])){
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
        if ( item == null ){
            throw new NullPointerException("Item cannot be null");
        }
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

    /**
     * Resizing code ( creates larger array to add new objects to )
     */
    private void checkSize(){
        // HOWEVER: when size becomes length - we run out of room
        if (size == data.length){
            // create new array, double the size, copy elements over

            // create larger array twice the size as the current
            ItemType[] temp = (ItemType[]) new Object[size * 2];

            // copy items from data array to temp array
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }

            // repoint/reference data to point to temp array
            data = temp;

            // optional
            temp = null;
        }
    }

    private class OurCustomIterator implements Iterator<ItemType> {

        //fields
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


    // listIterator to work on
    private class SecondCustomIterator implements ListIterator<ItemType> {
        // fancier Iterator - lets us go forwards and backwards

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
            ItemType result = get(currentPosition);
            currentPosition++;
            return result;
        }


        @Override
        public boolean hasPrevious() {
            // hasNext checked currentPosition with size
            // hasPrevious check currentPosition against 0
            return currentPosition > 0;
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

        /**
         * Removes from the list the last element that was returned by {@link
         * #next} or {@link #previous} (optional operation).  This call can
         * only be made once per call to {@code next} or {@code previous}.
         * It can be made only if {@link #add} has not been
         * called after the last call to {@code next} or {@code previous}.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this list iterator
         * @throws IllegalStateException         if neither {@code next} nor
         *                                       {@code previous} have been called, or {@code remove} or
         *                                       {@code add} have been called after the last call to
         *                                       {@code next} or {@code previous}
         */
        @Override
        public void remove() {

        }

        /**
         * Replaces the last element returned by {@link #next} or
         * {@link #previous} with the specified element (optional operation).
         * This call can be made only if neither {@link #remove} nor {@link
         * #add} have been called after the last call to {@code next} or
         * {@code previous}.
         *
         * @param itemType the element with which to replace the last element returned by
         *                 {@code next} or {@code previous}
         * @throws UnsupportedOperationException if the {@code set} operation
         *                                       is not supported by this list iterator
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list
         * @throws IllegalArgumentException      if some aspect of the specified
         *                                       element prevents it from being added to this list
         * @throws IllegalStateException         if neither {@code next} nor
         *                                       {@code previous} have been called, or {@code remove} or
         *                                       {@code add} have been called after the last call to
         *                                       {@code next} or {@code previous}
         */
        @Override
        public void set(ItemType itemType) {

        }

        /**
         * Inserts the specified element into the list (optional operation).
         * The element is inserted immediately before the element that
         * would be returned by {@link #next}, if any, and after the element
         * that would be returned by {@link #previous}, if any.  (If the
         * list contains no elements, the new element becomes the sole element
         * on the list.)  The new element is inserted before the implicit
         * cursor: a subsequent call to {@code next} would be unaffected, and a
         * subsequent call to {@code previous} would return the new element.
         * (This call increases by one the value that would be returned by a
         * call to {@code nextIndex} or {@code previousIndex}.)
         *
         * @param itemType the element to insert
         * @throws UnsupportedOperationException if the {@code add} method is
         *                                       not supported by this list iterator
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list
         * @throws IllegalArgumentException      if some aspect of this element
         *                                       prevents it from being added to this list
         */
        @Override
        public void add(ItemType itemType) {

        }
    }

}
