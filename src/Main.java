import edu.greenriver.sdev333.*;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        List<String> friends = new ArrayList<String>();
        System.out.println("initial size is " + friends.size());

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
        System.out.println("size is now " + friends.size());

        //for (int i = 0; i < friends.size(); i++) {
        //    System.out.println(friends.get(i));
        //}

        // above: import java.util.Iterator;
        Iterator<String> itr = friends.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }


        for (String name : friends) {
            System.out.println(name);
        }

        List<Integer> numbers = new ArrayList<>(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.print("numbers list: ");
        for (Integer number : numbers){
            System.out.print(number + " ");
        }

        System.out.println("\n Last index of 5 is: " + numbers.lastIndexOf(5));
        System.out.println("Last index of Josh is: " + friends.lastIndexOf("Josh"));

        List<String> Friend2 = new ArrayList<String>(2);
        Friend2.add("Rover");
        Friend2.add("Ronaldo");

        Friend2.addAll(friends);
        Iterator<String> itr2 = Friend2.iterator();
        System.out.print("All friends (addAll method): ");
        while (itr2.hasNext()) {
            String name = itr2.next();
            System.out.print(name + " ");
        }

        System.out.println("\n" + friends.equals(Friend2));
    }
}