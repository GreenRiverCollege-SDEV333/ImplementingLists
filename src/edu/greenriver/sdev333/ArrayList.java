//created package in local directory so need to bring it in by using keyword package
package edu.greenriver.sdev333;

//imports so we can use the methods from like .hasNext and .next
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList <ItemType> implements List<ItemType>{
    //NEED FIELDS? YES
    //1 plain private common java array
    private ItemType[] data;

    //1 int to keep track of size, the number of spots in data array
    private int size;

    //constructor set initial size to 0 and set the array data to hold 10 items
    public ArrayList() {
        size = 0;
        data = (ItemType[]) new Object[10];
    }

    //
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
    //if the size of my array is 0 then its empty so give me back true and if not false
    //or just give me back 0 if size is 0
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
        int i = indexOf(item);
        if(i != -1) {
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
            //resize up(double up to the array size) step 1 create larger array a temporary array to copy to
            ItemType[] temp = (ItemType[]) new Object[size * 2];
            ///step 2 iterate through, copy items from first array to the second, from data to temp
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }
            //step 3 repoint  data to the new array
            data = temp;
            //now temp is disconnected /optional.
            temp = null;
        }// end of if
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
        //code above works until size = the length, no room left.
        //do check first to not get error then update size
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
        if(i !=-1) {
            remove(i);
        }
    }

    /**
     * Removes all items from this collection.
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {
        //lazy deleting array items
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
        Iterator<ItemType> itr = (Iterator<ItemType>)otherCollection.iterator();
        while (itr.hasNext()) {
            ItemType itemToCheck = itr.next();
            if(!contains(itemToCheck)) {
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
        throw new UnsupportedOperationException("Not going to work");

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
        if (index > size){
            throw new IndexOutOfBoundsException("index is beyond the size");
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
    //adding item at specific index without overwriting the current item at the index
    public void add(int index, ItemType item) {
        //error checking method created already and now invoked
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
        //shift values left to overwrite the item at index
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

    //gives the index # of the item in arraylist given by the user
    @Override
    public int indexOf(ItemType item) {
        for (int i = 0; i < size; i++) {
            if(item.equals(data[i])) {
                return i;
            }
        }
        // if -1 returned then item is not in the array
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

    //Making class inside another class so not making a new file
    private class OurCustomIterator implements Iterator<ItemType> {
        //fields only 1 below
        private int currentPosition;
        //need constructor
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
    }

    private class SecondCustomIterator implements ListIterator<ItemType> {
        //fancier Iterator - allows us to go forwards and back
        private int currentPosition;
        public SecondCustomIterator() {
            currentPosition =0;
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

}// end of class ArrayList
