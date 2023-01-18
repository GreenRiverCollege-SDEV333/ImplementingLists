package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;

public class Arraylist<ItemType> implements List<ItemType>{
    //WE NEED FIELDS!!

    // one plain old java array
    private ItemType[] data;

    // one int to keep track of size
    // size is the number of elements that are not null in the array
    //size is different from length
    private int size;

    // constructor

    public Arraylist(){
        size = 0;
        data =(ItemType[]) new Object[10];
    }

    public Arraylist(int intCapacity){
        size = 0;
        data =(ItemType[]) new Object[intCapacity];
    }


    /**
     * Returns the number of items in this collection.
     *
     * @return the number of items in this collection
     */
    @Override
    public int size() {

        return size ;
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

        // create an enhanced for loop to check each item in the list for the item being passed through
        // to the contains method
        for (ItemType E : data) {
            if (E.equals(item))
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
    public void checkSize(){
        if(size == data.length){
            //***********resize up(double up the array size**************//

            //Step 1 - create a new larger array
            ItemType[] temp =  (ItemType[]) new Object[size*2];

            //Step 2 - copy items for data to temp
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }

            //Step 3 - repoint/reference data to point to new array
            data = temp;

            temp = null;


        }// end of if need to re
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

        for (int i = 0; i < size; i++) {
            if(data[i].equals(item)){
                for (int j = i; j < size -1; j++) {
                    data[j] = data[j +1];
                }
               data[size-1] = null;
                size--;

            }

        }
    }

    /**
     * Removes all items from this collection.
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {

        // lazy deletion - length will still be whatever it last was
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
//        Iterator<ItemType> itr = (Iterator<ItemType>) otherCollection.iterator();
//        while(itr.hasNext()){
//            ItemType itemToCheck = itr.next();
//            if(!contains(itemToCheck)){
//                return false;
//            }
//        }
//
//        return true;

// this is the other way to write this method
        for (ItemType itemToCheck : otherCollection) {
            if (!contains(itemToCheck)) {
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
        throw new UnsupportedOperationException(" Not Implemented");
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
            throw new IndexOutOfBoundsException();
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
            throw new IndexOutOfBoundsException();
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
            for (int i = size ; i >= index +1; i--) {
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
        public void remove ( int index){

            //create a loop to iterate through the array
            for (int i = 0; i < size; i++) {
                // conditional looks to see if the parameter passed is in the array
                if (i == index) {
                    // if the parameter exists in the array, we iterate through the list again, as many times as there are elements in our array
                    for (int j = i; j < size - 1; j++) {
                        // we replace the element occupying the index we passed as parameter with the next element in line, and we shift all elements toward the head of the array
                        data[j] = data[j + 1];
                    }
                    // after all items have been shift, we decrement the size of the array list
                    data[size - 1] = null;
                    size--;

                }

            }
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

        int result = 0;

        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])){
                result = i;
                return result;
            }
            else{
                result = -1;
            }
        }
            return result;
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

        //fields
        private int currentPosition;

        public OurCustomIterator(){
            currentPosition = 0;
        }


        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentPosition < size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public ItemType next() {
            ItemType result = get(currentPosition);
            currentPosition++;
            return result;
        }
    }

    private class SecondCustomerIterator implements ListIterator<ItemType>{
        // Fancier ITerator - lets us go forwards and backwards

        private int currentPosition;

        public SecondCustomerIterator(){
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
            //hasNext check curretnPosition with size
            //hasPrevious check currentPosition against 0
            return currentPosition <  0;
        }

        @Override
        public ItemType previous() {
            ItemType result = get(currentPosition);
            currentPosition--;
            return result;
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

    // this is a method i had to create as i was not able to do a toString to check what was in my arrayListd
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

