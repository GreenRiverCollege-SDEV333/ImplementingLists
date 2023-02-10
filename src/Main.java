import edu.greenriver.sdev333.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //test for ArrayList constructor
        List<String> friends = new ArrayList<String>();

        System.out.println("Test isEmpty result: " + friends.isEmpty());

        List<String> nemeses = new SinglyLinkedList<>();

        nemeses.add("BR");
        nemeses.add("H2");
        System.out.println("Initial size is " + friends.size());

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

        //test for size and add(item)
        System.out.println("size is now " + friends.size());

        //test for add(index,item)
        friends.add(2, "Wedensday");

        //test for iterator implementation
        for (String name: friends
        ) {
            System.out.println(name);
        }

        //test for containsAll
        System.out.println(friends.containsAll(nemeses));



    }
}