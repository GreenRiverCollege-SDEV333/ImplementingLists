package edu.greenriver.sdev333;

public class SinglyListMain {
    public static void main(String[] args) {
        // create a new LinkedList
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        // check if the list is empty
        System.out.println("Is the list empty? " + list.isEmpty());

        // add some items to the list
        list.add("Jesse");
        list.add("Adam");
        list.add("Jimmy");

        // print the size of the list
        System.out.println("The size of the list is: " + list.size());

        // check if the list contains a specific item
        System.out.println("Does the list contain 'banana'? " + list.contains("banana"));

        // get the index of a specific item in the list
        System.out.println("The index of 'cherry' in the list is: " + list.indexOf("cherry"));

        // remove an item from the list
        list.remove(1);

        // print the updated list
        System.out.println("The updated list is: " + list);

        // get an item from the list
        String item = list.get(0);
        System.out.println("The item at index 0 is: " + item);

        // set an item in the list
        list.set(1, "date");

        // print the updated list
        System.out.println("The updated list is: " + list);

        // clear the list
        list.clear();

        // print the size of the list after clearing it
        System.out.println("The size of the list after clearing it is: " + list.size());
    }
}
