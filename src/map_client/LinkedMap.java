package map_client;

public class LinkedMap {
    // helper class
    private class Node {
        KeyType key;
        ValueType value;
        Node next;
    }

    // fields
    private Node head;

    public void put(KeyType theKey, ValueType theValue) {
        // if theKey is in the map already?
        Node current = head;
        while (current != null) {
            if(theKey.equals(current.key)) {
                // I found it !
                current.value = theValue;
            }
            // move current fowar to the next node
            current = current.next;
        }
        // if not, add it
        // add a new node to represent the key-value pair
        Node theNewNode = new Node();
        theNewNode.key = theKey;
        theNewNode.value = theValue;
        theNewNode.next = head;
        head = theNewNode;
    }

    public ValueType get(KeyTyoe theKey) {
        Node current = head;
        while (current != null) {
            if (theKey.equals(current.key)) {
                //  i found the key
                return current.value;
            }
        }

        // get to the end of the loop
        // key not in the list
        return null;
    }
}
