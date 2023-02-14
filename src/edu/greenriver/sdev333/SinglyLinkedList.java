package edu.greenriver.sdev333;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.ListIterator;

public class SinglyLinkedList<ItemType> implements List<ItemType> {

    // FIELDS - what does a linked list actually have in it??
    private Node head;
    private int size;

    // helper/inner classes
    private class Node {
        ItemType data;
        Node next;
    }

    /**
     * Constructor
     */
    public SinglyLinkedList() {
        // an empty list has no nodes,
        // which means it has no head, so set head to null
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
        // assume indexOf is working...
//        int position = indexOf(item);
//        if (position == -1) {
//            return false;
//        }
//        return true;
        Node current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
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
        if (item == null) {
            throw new NullPointerException();
        }
        // the index at the end of the list is size - 1
        // example: if list is size 5, last index is 4
        // so we can just insert at the last index
        //add(size() - 1, item);

        if (head == null){
            Node theNewOne = new Node();
            theNewOne.data = item;
            theNewOne.next = head;

            head = theNewOne;
        } else if (head!= null) {
            SinglyLinkedList.Node current = head;

            for (int i = 0; i < size - 1; i++) {
                current = current.next;
            }

            SinglyLinkedList.Node theNewOne = new SinglyLinkedList.Node();
            theNewOne.data = item;
            theNewOne.next = current.next;

            current.next = theNewOne;
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
        if (item == null) {
            throw new NullPointerException();
        }

        // alternative - easier to write, but less efficient
        /*
        int position = indexOf(item);
        if (position != -1) {
            remove(position);
        }
        */

        if (head.data == item) {
            head = head.next;
            size--;
        }
        else {
            Node current = head;
            Node previous;
            while (current.next != null) {
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
        Iterator<ItemType> itr = (Iterator<ItemType>)otherCollection.iterator();
        while (itr.hasNext()) {
            ItemType itemToCheck = itr.next();
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
        // walk through the other collection
        //  for-each loop
        //  or use Iterator

        Iterator<ItemType> itr = (Iterator<ItemType>)otherCollection.iterator();
        while (itr.hasNext()) {
            ItemType currentItem = itr.next();
            add(currentItem);
        }

        /*
        // alternative implementation using a for-each loop
        for (ItemType currentItem : otherCollection) {
            add(currentItem);
        }
        */
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
        for (ItemType currentItem : otherCollection) {
            remove(currentItem);
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
        ListIterator<ItemType> iterator = listIterator();
        while (iterator.hasNext()) {
            ItemType item = iterator.next();
            if (contains(item)) {
                iterator.remove();
                size--;
            }
        }
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
        while (counter != index) {
            current = current.next;
            counter++;
        }
        return current.data;

        /*for (int i = 0; i < index; i++) {
            current = current.next;
        }*/
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
        for (int i = 0; i < index; i++) {
            current = current.next;
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

        if (index == 0) {
            // if someone wants to add at the beginning, I need to change the head
            SinglyLinkedList.Node theNewOne = new SinglyLinkedList.Node();
            theNewOne.data = item;
            theNewOne.next = head;
            head = theNewOne;
        }
        else {
            Node current = head;

            // stop one before the position I want to insert at
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // when I get here, current is pointing the node *BEFORE* the node at the index
            SinglyLinkedList.Node theNewOne = new SinglyLinkedList.Node();
            theNewOne.data = item;
            theNewOne.next = current.next;

            current.next = theNewOne;
        }

        size++;
    }

    public int hashCode() {
        int result = 1;
        for (ItemType item : this)
            result = 31 * result + (item == null ? 0 : item.hashCode());
        return result;
    }

    private void checkIndex(int index) {
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
    private boolean isValidIndex(int index){
        if (index < 0 || index >= size){
            return true;
        }else {
            return false;
        }
    }
    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            head = head.next;
        }
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // when I get here - current is pointing to the node BEFORE the one at index

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
//        int counter = 0;
//        Node current = head;
//        while (current != null) {
//            if (current.data.equals(item)) {
//                return counter;
//            }
//            counter++;
//            current = current.next;
//        }
//
//        // if we get here, it's not found
//        return -1;
        int index = 0;
        Node current = head;
        while (current != null) {
            if (item == null && current.data == null) {
                return index;
            } else if (item != null && item.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
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
        if (head == null) {
            return -1;
        }

        int index = -1;
        int currentIndex = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                index = currentIndex;
            }
            current = current.next;
            currentIndex++;
        }

        return index;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        SinglyLinkedList<ItemType> other = (SinglyLinkedList<ItemType>) otherObject;
        if (size != other.size) {
            return false;
        }
        Node current1 = head;
        Node current2 = other.head;
        while (current1 != null) {
            if (!current1.data.equals(current2.data)) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
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
        return new OurEnhancedIterator();
    }

    private class OurCustomIterator implements Iterator<ItemType> {

        // field
        private Node currentPosition;

        public OurCustomIterator() {
            currentPosition = head;
        }

        @Override
        public boolean hasNext() {
            // see if I'm on the last node: if (current.next == null)
            // see if I made it past the last node: if (current == null)
            if (currentPosition != null) {
                return true;
            }
            return false;
        }

        @Override
        public ItemType next() {
            ItemType result = currentPosition.data;
            currentPosition = currentPosition.next;
            return result;
        }
    }

    private class OurEnhancedIterator implements ListIterator<ItemType> {

        private Node currentPosition;
        private int currentIndex;

        public OurEnhancedIterator() {
            currentPosition = head;
            currentIndex = 0;
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