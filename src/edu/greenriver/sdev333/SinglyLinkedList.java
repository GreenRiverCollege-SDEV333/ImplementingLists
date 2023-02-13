package edu.greenriver.sdev333;

import java.util.Iterator;
import java.util.ListIterator;

public class SinglyLinkedList<ItemType> implements List<ItemType> {

    // FIELDS - what does a linked list actually have in it?
    private Node head;
    private int size;

    // helper/inner classes
    private class Node {
        ItemType data;
        Node next;
    }

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
        if (item == null) {
            throw new NullPointerException("Item is null");
        }
        Node n = head;
        while(n.next != null) {
            if (n.data == item) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    private class OurEnhancedIterator implements ListIterator<ItemType> {

        private Node currentPosition;
        private int currentIndex;

        public OurEnhancedIterator() {
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

    private class OurCustomIterator implements Iterator<ItemType> {
        // fields
        private Node currentPosition;

        public OurCustomIterator() {
            currentPosition = head;
        }

        @Override
        public boolean hasNext() {
            return currentPosition.next != null;
        }

        @Override
        public ItemType next() {
            ItemType result = currentPosition.data;
            currentPosition = currentPosition.next;
            return result;
        }
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
            throw new NullPointerException("Item is null");
        }

        Node newNode = new Node();
        newNode.data = item;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
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
        // check if the item is null
        if (item == null) {
            throw new NullPointerException("Specified item is null");
        }
        // if the head is holding the item
        if (head.data.equals(item)) {
            // set the head equal to head.next (effectively deleting the node)
            head = head.next;
            // decrement size
            size--;
        } else {
            // create a new node to hold the spot of our current node
            Node current = head;
            // create another node that will keep track of the previous node
            Node previous;
            // head is not holding the item, search the LinkedList for the item
            while (current.next != null) {
                // set previous equal to current
                previous = current;
                // set current equal to the next node
                current = current.next;
                // check if current's data is equal to item
                if (current.data.equals(item)) {
                    // it does, delete the node
                    previous.next = current.next;
                    // decrement size
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
        // loop for every item in otherCollection
        for (ItemType it : otherCollection) {
            // check if the current item is contained in the LinkedList
            if (!contains(it)) {
                // if it isn't, return false
                return false;
            }
        }
        // all items were found in the LinkedList, return true
        return true;
    }

    /**
     * Adds all the items in this specified other collection to this collection.
     *
     * @param otherCollection collection containing items to be added to this collection
     */
    @Override
    public void addAll(Collection<? extends ItemType> otherCollection) {
        // loop for each item in otherCollection
        for (ItemType it : otherCollection) {
            // add the current item to the LinkedList
            add(0, it);
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
        // loop for every item in otherCollection
        for (ItemType it : otherCollection) {
            // remove the specified item
            remove(it);
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
        // create a new LinkedList to hold all retained items
        SinglyLinkedList<ItemType> retained = new SinglyLinkedList<>();
        // get each item in the LinkedList
        for (int i=0; i<size; i++) {
            ItemType item = get(i);
            // see if the item equals any item in otherCollection
            for (ItemType it : otherCollection) {
                // if it does
                if (item.equals(it)) {
                    // add that item to the new LinkedList
                    retained.add(item);
                }
            }
        }
        // replace the old LinkedList with the new LinkedList
        head = retained.head;
        size = retained.size;
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
        // check if the index is out bounds
        checkIndex(index);
        // keep track of the current node
        Node current = head;
        // create a counter (we don't have an index system)
        int counter = 0;
        // loop over the LinkedList while count != index
        while (counter != index) {
            // set current equal to the next node
            current = current.next;
            // increment the counter
            counter++;
        }
        // return the current node's data
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
        // check if the index is out of bounds
        checkIndex(index);
        // keep track of the current node
        Node current = head;
        // create a counter
        int counter = 0;
        // loop over the LinkedList while count != index
        while (counter != index) {
            current = current.next;
            counter++;
        }
        // set the current node's data equal to the specified item
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
        // check if the item is null
        if (item == null) {
            throw new NullPointerException("Item is null");
        }
        checkIndex(index);

        if (index == 0) {
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
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
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i=0; i<index-1; i++) {
                current = current.next;
            }

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
        //
        int counter = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return counter;
            }
            counter++;
            current = current.next;
        }
        return 0;
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
        return new OurEnhancedIterator();
    }
}
