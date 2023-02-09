import edu.greenriver.sdev333.ArrayList;
import edu.greenriver.sdev333.Collection;
import edu.greenriver.sdev333.List;
import edu.greenriver.sdev333.SinglyLinkedList;

import java.util.Iterator;
import java.util.ListIterator;

//ghusenam@users.noreply.github.com


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //List<String> friends = new ArrayList<String>();
        List<String> friends = new SinglyLinkedList<String>();

        System.out.println("Initial size is " + friends.size());

        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add("Susan");
        friends.add("Tyler");
        friends.add("Usman");
        friends.add("Dee");
        friends.add("Dee");
        friends.add("Rose");
        friends.add("Blanche");
        friends.add("Dorothy");
        friends.add("Sophia");

        /*//adding at item and ItemType item
        friends.add(2, "Wednesday");

        //removing at int index, Jess is removed if we remove at index 0
        friends.remove(0);

        System.out.println("Size is now " + friends.size());

        //because we previously removed the person at index 0, Tina
        //would now become index 0
        //use the get method to get the person at index 0
        System.out.println("At index 0 now we have: " + friends.get(0));

        //using the set method to set a new person at a new index
        friends.set(3, "Jazmin");

        //friends.addAll
        //calling indexOf to see if the person is in the list or not
        System.out.println();
        System.out.println("This person is in the list," +
                " So we print out its index: " + friends.indexOf("Jazmin"));
        //printing out -1 if not in the list
        System.out.println("Martin is not on the list, " +
                "so we print out -1: " + friends.indexOf("Martin"));

        //System.out.println("Dee is at: " + friends.lastIndexOf("Dee"));

        //printing out the last index of Dee, she appears on our list twice
        System.out.println("Last index of Dee: " + friends.lastIndexOf("Dee"));

        //printing out everything in our list
        *//*for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }*/

        Iterator<String> itr = friends.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }

        System.out.println();
        //another way to do it, in order for this loop to work we need an iterator
        for (String name : friends) {
            System.out.println(name);
        }

       /* ListIterator<String> fancyItr = friends.listIterator();
        while (fancyItr.hasPrevious()) {
            String name = fancyItr.previous();
            System.out.println(name);
        }*/
    }
}