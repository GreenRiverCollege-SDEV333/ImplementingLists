package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<ItemType> implements List<ItemType>{
    // FIELDS - what does a Linked List actually have in it?
    private Node head;
    private int size;

    // helper/inner classes
    private class Node{
        ItemType data;
        Node next;
        Node previous;
    }

    /**
     * Constructor
     */
    public SinglyLinkedList(){
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
        //create node to hold our place
        Node current = head;
        //while our current place does not equal null,we will run
        while(current != null){
            // we will check if  the data field in our current place matches the
            //parameter passed in, and if it does, we return true
            if(current.data == item){
                return true;
            }
            //if current.data does not match our parameter , we set current to point to
            // the next node in the list, until current is null, at which point
            //we will know without a doubt if our parameter is in our list or not
            current = current.next;
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

        return new OurCustomerIterator();
    }



    public void addHead(ItemType item){
        if(head==null){
            head = new Node();
            head.data = item;
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


        //index at thee end of the list is size -1
        //example if list is size 5, last index is 4
        // so we can just insert at the last index
        //add(size() - 1, item);
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = null;
        if(head == null){
            head = newNode;
        }else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            //current is pointing to last node
            current.next = newNode;
        }
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
        if(item == null) {
            throw new NullPointerException();
        }

        //alternative - easier to write but less efficient
        /*int position = indexOf(item);
        if(position != -1){
            remove(position);
        }*/

        if(head.data == item){
            head = head.next;
            size--;
        }
        else{
            Node current = head;
            Node previous;
            while(current.next != null){
                previous = current;
                current = current.next;

                if(current.data.equals(item)){
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
        throw new UnsupportedOperationException();
    }

    /**
     * Adds all the items in this specified other collection to this collection.
     *
     * @param otherCollection collection containing items to be added to this collection
     */
    @Override
    public void addAll(Collection<? extends ItemType> otherCollection) {

        // //walk through the other collection
        //for-each loop
        // or use Iterator
                                //  must cast the iterator
        Iterator<ItemType> itr = (Iterator<ItemType>)otherCollection.iterator();
        while(itr.hasNext()){
            ItemType currentItem = itr.next();
            add(0,currentItem);
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
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
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
        checkIndex(index);

        Node current = head;
        int counter = 0;

        while(counter != index){
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

        checkIndex(index);
        Node current = head;
        int counter = 0;
        while(counter!= index){
            current = current.next;
            counter++;
        }
        current.data = item;


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
       checkIndex(index);

        if (head == null) {
            Node theNewOne = new Node();
            theNewOne.data = item;
            head = theNewOne;
        } else if (index == 0) {
            // if someone wants to add at the beginning, i need to change the head
            Node theNewOne = new Node();
            theNewOne.data = item;
            theNewOne.next = head;

            head = theNewOne;
        } else {
            Node current = head;

            //stop one before the position i want to insert at
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            //when i get here, current is pointing the node *BEFORE* the node at the index
            Node theNewOne = new Node();
            theNewOne.data = item;
            theNewOne.next = current.next;
            current.next = theNewOne;
        }

        size++;
    }

    private void checkIndex(int index){
        if(index < 0 | index > size){
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

        if(index == 0){
            head = head.next;
        }
        else {
            Node current = head;
            //stop one before the position i want to insert at
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // current is point to the node before the one at index
            current.next = current.next.next;
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
        int counter = 0;
        Node current =head;
        while (current != null) {

            if(current.data.equals(item)){
                return counter;
            }
            counter++;
            current = current.next;
        }

        //if we get here, it's not found
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
        // since we return -1 if the item does not appear in our list,
        // we can create a variable called last index to hold that value.
        // we will update this variable as we traverse the linked list, and eventually
        // it will hold the number of the last position our node.data=item will be in
      int lastIndex = -1;
      // we will create a variable to count how many positions we have traveled too,
      // so this number will be updated every time we traverse through our list
        // eventually we will assign last index to this number and our method will be complete
      int index=0;

      // we create a new node to hold our position, and we assign this node the value of whatever our head node is
        // then we go from there
      Node current = head;
      // this is the standard traversal loop we use to traverse through nodes in a linked list
        // if current equals null, then there are no longer any more objects or nodes in our linked list, so the
        //loop will stop
      while (current != null){
          // this conditional if statement says if our current nodes data field is the same as the item we passed into the method
          // then we will set the int variable lastIndex to the value of index
          // at the start, last index is -1, so if current.data never equals item, we will exit this loop when current equals null
          // and our method will return the default -1. Otherwise, if the item passed through our parameter does equal current.data
          // we will update last index to the value of index. we always increment the value of index, and assign current to current.next, so
          // our pointer is  looking to the next node in our list. our loop will run until current equals null, so we will continue to check current.data against
          //our item parameter, and if we get a hit, we will update lastIndex to our newly incremented index value everytime.
          if(current.data.equals(item)){
              lastIndex = index;
          }
            index++;
          current = current.next;
        }
        // we return last index every time, -1 for default but whatever the appropriate index is if we have the item in our list
        return lastIndex;
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
        return new OurEnhancedIterator();
    }

    public String toString(){
        if( head == null){
            return "[]";
        }
        Node current = head;
        String result = "[" ;
        while(current != null){
            result += current.data;
            if(current.next != null){
                result+=",";
            }
            current = current.next;
        }
        return result + "]";
    }

    private class OurCustomerIterator implements Iterator<ItemType>{

        //field
        private Node currentPosition;


        public OurCustomerIterator(){
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
            //see if Im on the last node: if (current.next == null)
            // see if i made it past the last nde:if(current == null)
            if(currentPosition != null){
                return true;
            }
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public ItemType next() {
            ItemType result = currentPosition.data;;
            currentPosition = currentPosition.next;
            return result;
        }
    }

    private class OurEnhancedIterator implements ListIterator<ItemType>{


        private Node currentPosition;
        private Node previousPosition;
        private int currentIndex;

        public OurEnhancedIterator(){
            currentPosition = head;
            currentIndex = 0;
        }
        /**
         * Returns {@code true} if this list iterator has more elements when
         * traversing the list in the forward direction. (In other words,
         * returns {@code true} if {@link #next} would return an element rather
         * than throwing an exception.)
         *
         * @return {@code true} if the list iterator has more elements when
         * traversing the list in the forward direction
         */
        @Override
        public boolean hasNext() {
            return currentPosition != null;
        }

        /**
         * Returns the next element in the list and advances the cursor position.
         * This method may be called repeatedly to iterate through the list,
         * or intermixed with calls to {@link #previous} to go back and forth.
         * (Note that alternating calls to {@code next} and {@code previous}
         * will return the same element repeatedly.)
         *
         * @return the next element in the list
         * @throws NoSuchElementException if the iteration has no next element
         */
        @Override
        public ItemType next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            ItemType result = currentPosition.data;
            currentPosition = currentPosition.next;
            return result;
        }

        /**
         * Returns {@code true} if this list iterator has more elements when
         * traversing the list in the reverse direction.  (In other words,
         * returns {@code true} if {@link #previous} would return an element
         * rather than throwing an exception.)
         *
         * @return {@code true} if the list iterator has more elements when
         * traversing the list in the reverse direction
         */
        @Override
        public boolean hasPrevious() {

            return previousPosition != null;
        }

        /**
         * Returns the previous element in the list and moves the cursor
         * position backwards.  This method may be called repeatedly to
         * iterate through the list backwards, or intermixed with calls to
         * {@link #next} to go back and forth.  (Note that alternating calls
         * to {@code next} and {@code previous} will return the same
         * element repeatedly.)
         *
         * @return the previous element in the list
         * @throws NoSuchElementException if the iteration has no previous
         *                                element
         */
        @Override
        public ItemType previous() {
            if(!hasPrevious()){
                throw new NoSuchElementException();
            }
            currentPosition = previousPosition;
            previousPosition = previousPosition.previous;
            return currentPosition.data;
        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to {@link #next}. (Returns list size if the list
         * iterator is at the end of the list.)
         *
         * @return the index of the element that would be returned by a
         * subsequent call to {@code next}, or list size if the list
         * iterator is at the end of the list
         */
        @Override
        public int nextIndex() {

            return currentIndex;
        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to {@link #previous}. (Returns -1 if the list
         * iterator is at the beginning of the list.)
         *
         * @return the index of the element that would be returned by a
         * subsequent call to {@code previous}, or -1 if the list
         * iterator is at the beginning of the list
         */
        @Override
        public int previousIndex() {
            return currentIndex - 1;
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

