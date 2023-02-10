package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;

public class SinglyLinkedList<ItemType> implements List<ItemType> {
    //Fields
    private Node head;
    private int size;

    //helper/inner classes
    private class Node {
        ItemType data;
        Node next;

        public Node(ItemType data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public SinglyLinkedList(){
        // an empty list has no nodes, which means it has no head
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
        return head == null;
        //or return size = 0
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
        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
            if (currentNode.data.equals(item)){
                return true;
            }
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
        Node theNewOne = new Node(item, null);
        if (head == null) {
            head = theNewOne;
        } else {
            Node currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = theNewOne;
        }
        size ++;
    }

    public boolean equalsAll(SinglyLinkedList<ItemType> otherCollection) {
        if (otherCollection.equals(this)) {
            return true;
        }

        Node p1 = this.head;
        Node p2 = otherCollection.head;
        while (p1 != null && p2 != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return (p1 == null && p2 == null);
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
        if(item == null){
            throw new NullPointerException();
        }

        if(head.data == item)
        {
            head = head.next;
            size --;
        } else {
            Node current = head;
            Node previous;
            while (current.next != null){
                previous = current;
                current = current.next;

                if (current.data.equals(item)){
                    previous.next = current.next;
                    size --;
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
        //Walk thourgh the other collection
        //for each loop
        //or use iterator

        //CAN DO LIKE THIS
//        Iterator<ItemType> itr = (Iterator<ItemType>)otherCollection.iterator();
//
//        while(itr.hasNext()){
//            ItemType currentItem = itr.next();
//            add(0,currentItem); //add to front for better performance
//        }

        //OR LIKE THIS
        for (ItemType item : otherCollection
             ) {
            add(0,item);
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
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
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
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = item;
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
//        Check this
//        if(index ==0){
//            //if someone wants to add at the beginning
//            Node theNewOne = new Node(item, head);
//            head = theNewOne;
            if (index == 0){
                Node theNewOne = new Node(item, head);
                head = theNewOne;
            }
//        }

        //take me to index
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        //create new node set next to current.next
        Node newNode = new Node(item, currentNode.next);
        //increment size
        size++;
        //update currentnode.next to new node
        currentNode.next = newNode;

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

        //take me to index
        Node currentNode = head;

        //index = 0 (remove head)
        if(index ==  0){
            head = currentNode.next;
        }

        //index less than 0 do nothing
        else if (index < 0 || index >=size() )
        {
            throw new IndexOutOfBoundsException();
        }

        //
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;
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
        Node current = head;
        while (current != null)
        {
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
        int lastIndex = -1;
        int counter = 0;
        for (ItemType currentItem : this
             ) {
            if(currentItem.equals(item)){
                lastIndex = counter;
            }
            counter ++;
        }
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
        return null;
    }

    public boolean isValidIndex(int index){
        if (index > 0 && index < size()){
            return true;
        } else {
            return false;
        }
    }

    private class OurCustomIterator implements Iterator<ItemType>{
        private Node currentPosition;

        public OurCustomIterator() {

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
            ItemType result = currentPosition.data; //currentPosition.data
            currentPosition = currentPosition.next; //currentPosition.next;
            return result;
        }
    }

//    private class secondCustomIterator implements ListIterator<ItemType> {
//        //fancier iterator - lets us go forward and backwards
//        private Node currentPosition;
//
//        public secondCustomIterator(){
//            currentPosition = head;
//        }
//        @Override
//        public boolean hasNext() {
//            return currentPosition.next != null;
//        }
//
//        @Override
//        public Node next() {
//            return currentPosition.next;
//        }
//
//        @Override
//        public boolean hasPrevious() {
//            // current position greater than 0
//            return currentPosition != head;
//        }
//
//        @Override
//        public ItemType previous() {
//            //Not sure
//            return o;
//        }
//
//        @Override
//        public int nextIndex() {
//            return indexOf(currentPosition.next.data);
//        }
//
//        @Override
//        public int previousIndex() {
//            return currentPosition --;
//        }
//
//        @Override
//        public void remove() {
//
//        }
//
//        @Override
//        public void set(ItemType itemType) {
//
//        }
//
//        @Override
//        public void add(ItemType itemType) {
//
//        }
//    }
}
