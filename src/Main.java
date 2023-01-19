import edu.greenriver.sdev333.ArrayList;
import edu.greenriver.sdev333.*;

import java.util.Iterator;

/**
 * This class creates ArrayList object(s) and tests ArrayList methods.
 * 
 * @author Jasmine David
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<String> friends = new ArrayList<String>();
        System.out.println("Friends ArrayList initial size is " + friends.size());

        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add("Susan");
        friends.add("Tyler");
        friends.add("Usman");
        friends.add("Dee");
        friends.add("Rose");
        friends.add("Blanche");
        friends.add("Dorothy");
        friends.add("Sophia");
        // Test add(int index, ItemType item) method -------------
        friends.add(2, "Wednesday");
        System.out.println("\nTEST add(int index, ItemType item) method --------------------");
        System.out.println("After adding \"Wednesday\" Friends ArrayList size is now: " + friends.size());


        // use iterator to print out names - doesn't run bc missing body and the methods
        // above: import java.util.Iterator;
        System.out.println();
        System.out.println("Initial Friends ArrayList: ");
        Iterator<String> itr = friends.iterator();
        while (itr.hasNext()){
            String name = itr.next();
            System.out.println(name);
        }

        // TEST isEmpty method ---------------------------------------------
        System.out.println("\nTEST isEmpty method --------------------");
        System.out.println("Is Friends ArrayList empty? " + friends.isEmpty());


        // TEST remove(ItemType item) method ---------------------------------------------
        System.out.println("\nTEST contains(ItemType item) method --------------------");
        System.out.println("Friends ArrayList contains \"Wednesday\": " + friends.contains("Wednesday"));

        // TEST remove(int index) method ---------------------------------------------
        int removeIndex = 0;
        friends.remove(removeIndex); // removes "Jess" from List
        System.out.println("\nTEST remove(int index) method --------------------");
        System.out.println("Friends ArrayList after removing index " + removeIndex + " from list: ");
        for (String name : friends) {
            System.out.println(name);
        }

        // create second ArrayList
        List<String> friends2 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            friends2.add("Name"+(i));
        }

        // TEST containsAll method ---------------------------------------------
        System.out.println("\nTEST containsAll method --------------------");
        System.out.println("Friends ArrayList contains all items in friends2 ArrayList: " + friends.containsAll(friends2));


        // Test set method ---------------------------------------------
        System.out.println("\nTEST set method --------------------");
        int setIndex = 3;
        String setName = "Sam";
        friends.set(setIndex, setName);
        System.out.println("Friends ArrayList after setting index " + setIndex + " to \""+ setName + "\": ");
        for (String name : friends) {
            System.out.println(name);
        }

        // Test get method ---------------------------------------------
        System.out.println("\nTEST get method --------------------");
        int getIndex = 5;
        System.out.println("Name at index " + getIndex + ": " + friends.get(getIndex));


        // Test indexOf method ---------------------------------------------
        System.out.println("\nTEST indexOf method --------------------");
        String indexOfName = "Sam";
        System.out.println("Index of \"" + indexOfName + "\": " + friends.lastIndexOf(indexOfName));

        // Test lastIndexOf method ---------------------------------------------
        System.out.println("\nTEST lastIndexOf method --------------------");
        String lastIndexOfName = "Dorothy";
        System.out.println("Last index of \"" + lastIndexOfName + "\": " + friends.lastIndexOf(lastIndexOfName));



        // null pointer for foreach loop - what is really happening behind the scenes is
        // in the Iterator above ^^
//        for (String name : friends) {
//            System.out.println(name);
//
//        }

    }
    
}