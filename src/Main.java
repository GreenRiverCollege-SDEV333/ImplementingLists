import edu.greenriver.sdev333.ArrayList;
import edu.greenriver.sdev333.*;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * This class creates ArrayList object(s) and tests ArrayList methods.
 *
 * @author Jasmine David
 */
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> friends = new SinglyLinkedList<>();
//        System.out.println("Friends Linked List initial size is " + friends.size());

        friends.add("Tina");
        friends.add("Josh");
        friends.add("Susan");
        friends.add("Tyler");
        friends.add("Usman");
        friends.add("Adriana");
        friends.add("Rose");
        friends.add("Blanche");
        friends.add("Dorothy");
        friends.add("Sophia");
//        // Test add(int index, ItemType item) method -------------
        friends.add( "Wednesday");
//        System.out.println("\nTEST add(int index, ItemType item) method --------------------");
        System.out.println("After adding \"Wednesday\" Friends Linked List size is now: " + friends.size());

        // TEST SINGLY LINKED LIST METHODS:
        // TEST isEmpty method ---------------------------------------------
        System.out.println("\nTEST isEmpty method --------------------");
        System.out.println("Is Friends Linked List empty? " + friends.isEmpty());

        // TEST contains(ItemType item) method ---------------------------------------------
        System.out.println("\nTEST contains(ItemType item) method --------------------");
        System.out.println("Friends Linked List contains \"Adriana\": " + friends.contains("Adriana"));

        // TEST indexOf(ItemType item) method ---------------------------------------------
        System.out.println("\nTEST indexOf(ItemType item) method --------------------");
        System.out.println("Index of \"Adriana\": " + friends.indexOf("Adriana"));

        // TEST add(ItemType item) method ---------------------------------------------
        System.out.println("\nTEST add(ItemType item) method --------------------");
        friends.add("Sheven");
        System.out.println("Friends Linked List after adding \"Sheven\": " + friends.size());

        // TEST add(int index, ItemType item) method ---------------------------------------------
        System.out.println("\nTEST add(int index, ItemType item) method --------------------");
        friends.add(0,"Zack");
        System.out.println("Friends Linked List after adding \"Zack\": ");
        for (String name : friends) {
            System.out.println(name);
        }


        // TEST remove(int index) method ---------------------------------------------
        int removeIndex = 0;
        friends.remove(removeIndex); // removes "Zack" from List
        System.out.println("\nTEST remove(int index) method --------------------");
        System.out.println("Friends Linked List after removing index " + removeIndex + " from list: ");
        for (String name : friends) {
            System.out.println(name);
        }

        // Test get method ---------------------------------------------
        System.out.println("\nTEST get method --------------------");
        int getIndex = 5; // should retrieve "Adriana" from list
        System.out.println("Name at index " + getIndex + ": " + friends.get(getIndex));


        // Test set method ---------------------------------------------
        System.out.println("\nTEST set method --------------------");
        int setIndex = 3;
        String setName = "Sam";
        friends.set(setIndex, setName);
        System.out.println("Friends Linked List after setting index " + setIndex + " to \""+ setName + "\": ");
        for (String name : friends) {
            System.out.println(name);
        }

        // Create 2nd linked list
        List<String> friends2 = new SinglyLinkedList<>();
        friends2.add("Stephanie");
        friends2.add("Alicia");
        friends2.add("Ashley");
        friends2.add("Alicia");


        // Test addAll method and List Iterator ---------------------------------------------
        System.out.println("\nTEST addAll and List Iterator methods --------------------");
        friends.addAll(friends2);
        System.out.println("Friends Linked List after addAll method with friends2 Linked List (using List Iterator): ");
        ListIterator<String> fancyItr = friends.listIterator();
        while(fancyItr.hasNext()) {
            String name = fancyItr.next();
            System.out.println(name);
        }
        System.out.println();
        while (fancyItr.hasNext()){
            String name = fancyItr.previous();
            System.out.println(name);
        }

        // Test lastIndexOf method ---------------------------------------------
        System.out.println("\nTEST lastIndexOf method --------------------");
        String lastIndexOfName = "Alicia";
        System.out.println("Last index of \"" + lastIndexOfName + "\": " + friends.lastIndexOf(lastIndexOfName));

        // TEST remove(ItemType item) method ---------------------------------------------
        friends.remove("Stephanie");
        System.out.println("\nTEST remove(ItemType item method) --------------------");
        System.out.println("Friends Linked List after removing \"Stephanie\" from Linked List: ");
        for (String name : friends) {
            System.out.println(name);
        }


        // TESTING ARRAY LIST METHODS: -----------------------------
//        // use iterator to print out names - doesn't run bc missing body and the methods
//        // above: import java.util.Iterator;
//        System.out.println();
//        System.out.println("Initial Friends LinkedList: ");
//        Iterator<String> itr = friends.iterator();
//        while (itr.hasNext()){
//            String name = itr.next();
//            System.out.println(name);
//        }
//
//        // TEST isEmpty method ---------------------------------------------
//        System.out.println("\nTEST isEmpty method --------------------");
//        System.out.println("Is Friends ArrayList empty? " + friends.isEmpty());
//
//
//        // TEST remove(ItemType item) method ---------------------------------------------
//        System.out.println("\nTEST contains(ItemType item) method --------------------");
//        System.out.println("Friends ArrayList contains \"Wednesday\": " + friends.contains("Wednesday"));
//
//        // TEST remove(int index) method ---------------------------------------------
//        int removeIndex = 0;
//        friends.remove(removeIndex); // removes "Jess" from List
//        System.out.println("\nTEST remove(int index) method --------------------");
//        System.out.println("Friends ArrayList after removing index " + removeIndex + " from list: ");
//        for (String name : friends) {
//            System.out.println(name);
//        }
//
//        // create second ArrayList
//        List<String> friends2 = new SinglyLinkedList<String>();
//        for (int i = 0; i < 10; i++) {
//            friends2.add("Name"+(i));
//        }
//
//        // TEST containsAll method ---------------------------------------------
//        System.out.println("\nTEST containsAll method --------------------");
//        System.out.println("Friends ArrayList contains all items in friends2 ArrayList: " + friends.containsAll(friends2));
//
//
//        // Test set method ---------------------------------------------
//        System.out.println("\nTEST set method --------------------");
//        int setIndex = 3;
//        String setName = "Sam";
//        friends.set(setIndex, setName);
//        System.out.println("Friends ArrayList after setting index " + setIndex + " to \""+ setName + "\": ");
//        for (String name : friends) {
//            System.out.println(name);
//        }
//
//        // Test get method ---------------------------------------------
//        System.out.println("\nTEST get method --------------------");
//        int getIndex = 5;
//        System.out.println("Name at index " + getIndex + ": " + friends.get(getIndex));
//
//
//        // Test indexOf method ---------------------------------------------
//        System.out.println("\nTEST indexOf method --------------------");
//        String indexOfName = "Sam";
//        System.out.println("Index of \"" + indexOfName + "\": " + friends.lastIndexOf(indexOfName));
//
//        // Test lastIndexOf method ---------------------------------------------
//        System.out.println("\nTEST lastIndexOf method --------------------");
//        String lastIndexOfName = "Dorothy";
//        System.out.println("Last index of \"" + lastIndexOfName + "\": " + friends.lastIndexOf(lastIndexOfName));
//
//
//
//        ListIterator<String> fancyItr = friends.listIterator();
//        while(fancyItr.hasNext()) {
//            String name = fancyItr.next();
//            System.out.println(name);
//        }
//        System.out.println();
//        while (fancyItr.hasNext()){
//            String name = fancyItr.previous();
//            System.out.println(name);
//
//        }

//         null pointer for foreach loop - what is really happening behind the scenes is
//         in the Iterator above ^^
//        for (String name : friends) {
//            System.out.println(name);
//
//        }

    }

}