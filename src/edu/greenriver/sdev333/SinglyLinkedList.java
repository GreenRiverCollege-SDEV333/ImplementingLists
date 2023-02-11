package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;

//singly linked list will have to take in some generic items
// and implements our interface
public class SinglyLinkedList<ItemType> implements List<ItemType> {

    // Fields - what does a linked list actually have in it?
    //HEAD!!
    private Node head; // we need a node class to store

    private int size;

    // helper/inner classes
    private class Node {
        ItemType data;
        Node next;
        //we created a new class called Node and while we
        // created a new class, the next is going to refer to Node
    }

    public SinglyLinkedList() {
        //initializing to null, there is no nodes our list is empty
        // which means it has no head
        head = null;
        size = 0;

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
        //or head == null;
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
        // assume indexOf is working
        int position = lastIndexOf(item);
        if (position == -1) {
            return false;
        }
        return true;
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
        //assuming the list is empty
        if (head !=  null) {
            Node theNewOne = new Node();
            theNewOne.data = item;
            theNewOne.next = null;
            size++;
        }
        //assuming the list has nodes in it already
        Node current = head;
        while (current.next != null) {
            current = current.next;
            Node theNewNode = new Node();
            theNewNode.data = item;
            theNewNode.next = null;
            current.next = theNewNode;
            size++;
        }
    }
    //

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
        //first check if item is null
        if (item == null) {
            throw new NullPointerException();
        }

        //alternative - easier to write, but less efficient
        /*int position = indexOf(item);
        if (position != -1){
            remove(position);
        }*/

        if (head.data == item) {
            head = head.next;
            size--;
        } else {
            Node current = head;
            Node previous;
            while (current.next != null){
                previous = current;
                current = current.next;

                if (current.data.equals(item)) {
                    previous.next = current.next;
                    size--;
                }
            }
        }
    }

    /**
     * Removes all items from this collection.
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {
        head = null;
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
        return false;
    }

    /**
     * Adds all the items in this specified other collection to this collection.
     *
     * @param otherCollection collection containing items to be added to this collection
     */
    @Override
    public void addAll(Collection<? extends ItemType> otherCollection) {
        // walk through the other collection
        // use for-each loop
        // or an Iterator

        Iterator<ItemType> itr = (Iterator<ItemType>)otherCollection.iterator();
        while (itr.hasNext()){
            ItemType currentItem = itr.next();
            add(0, currentItem);
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        int counter = 0;
        while (counter != index) {
            current = current.next;
            counter++;
        }
        return current.data;
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
        //checking to see if the index is valid
        checkIndex(index);

        // if someone wants to add at the beginning,
        if (index == 0) {
            //I need to change the head
            Node theNewOne = new Node();
            theNewOne.data = item;
            theNewOne.next = head;

            head = theNewOne;
        }

        // making a variable called current that is a copy of head
        Node current = head;

        // start at the same position then move current forward
        // its going to move current forward "x" amount of times according to the index
        // current stops one before the position we want to be at
        for (int i = 0; i < index-1; i++) {
            current = current.next;
        }

        //when I get here, current is pointing to the node *BEFORE* the index
        Node theNewOne = new Node();
        //theNewOne takes the new item
        theNewOne.data = item;
        //we set next equals to current because current has the address of
        // our previous node
        theNewOne.next = current.next;
        // lastly we want our current next to point to theNewOne since it is now before it
        current.next = theNewOne;
        //then increment the size
        size++;


    }

    // adding to the front of my linked list
    public void addFront(ItemType item){
        // we can do this way if we have our add(Int index, ItemType item) working
        // add(0, item);

        // if not, then we need to create a new node that we will be able to link
        // at the front of the list


    }

    private void checkIndex(int index) {
        //throw an exception for someone wanting to remove at a
        // negative index or index greater than the size
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
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
        checkIndex(index);

        // if we are removing at index 0 (our head)
        if (index == 0){
            head = head.next;
        }
        //if we are removing anywhere else/in the middle
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // when I get here, current is pointing to the node BEFORE
            // the one at the index
            current.next = current.next.next;
        }
        //when removing reduce size
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
        //make a counter to keep track of index
        int counter = 0;
        //make a current node
        Node current = head;
        while (current != null) {
            if (current.data.equals(item)){
                return counter;
            }
            counter++;
            current = current.next;
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


    //helper class for the iterator method
    private class OurCustomIterator implements Iterator<ItemType>{

        // field to keep track of the current position
        private Node currentPosition;

        //constructor
        public OurCustomIterator(){
            //initialize it to head (the front of the list)
            currentPosition = head;
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
            //how to tell if were at the end of the list (aka the last node)
            //if current.next == null
            // see if I made it past the last node: if (current == null)
            if (currentPosition != null){
                return true;
            }
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * throws no Such Element Exception if the iteration has no more elements
         */
        @Override
        public ItemType next() {
            ItemType result = currentPosition.data;
            currentPosition = currentPosition.next;
            return result;
        }
    }


    //class for ListIterator
    private class OurEnhancedIterator implements ListIterator<ItemType> {

        private Node currentPosition;

        public OurEnhancedIterator(){
            currentPosition = head;
        }

        @Override
        public boolean hasNext() {
            return currentPosition != null;
        }

        @Override
        public ItemType next() {
            ItemType result = currentPosition.data;
            currentPosition = currentPosition.next;
            return result;
        }

        @Override
        public boolean hasPrevious() {
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
}