
import edu.greenriver.sdev333.*;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // constructor test
        List<String> friends = new ArrayList<>();
        // size test
        System.out.println("Initial size is " + friends.size());
        System.out.println();
        // is empty test - should return true;
        System.out.println(friends.isEmpty());
        System.out.println();

        // add test
        friends.add("Jess");
        // contains test - should return true
        System.out.println(friends.contains("Jess"));
        System.out.println();
        // indexOf test should return 0
        System.out.println(friends.indexOf("Jess"));
        System.out.println();
        // is empty test after the array has an element - should return false
        System.out.println(friends.isEmpty());
        System.out.println();
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
        // alternate add method test (adding at specific index)
        friends.add(2, "Wednesday");
        // size changing after elements added - should return 12
        System.out.println("size is now " + friends.size());
        System.out.println();
        // iterator test - also shows Wednesday added at index 2
        for (String name : friends) {
            System.out.println(name);
        }
        System.out.println();
        // remove test
        friends.remove(0);
        // index 0 removed proof
        for (String name : friends) {
            System.out.println(name);
        }
        System.out.println();
        // get test - should return Wednesday
        System.out.println(friends.get(1));
        System.out.println();
        // set test - should change index 1 to "Stewart"
        friends.set(1, "Stewart");
        System.out.println(friends.get(1));
        System.out.println();

        // second constructor test (Creating ArrayList with a specified size)
        List<String> arrayTwo = new ArrayList<>(20);
        arrayTwo.add("Michael");

        // clear test on new array
        System.out.println(arrayTwo.size());
        arrayTwo.clear();
        System.out.println(arrayTwo.size());
        System.out.println();

        // lastIndex test - should return 2
        arrayTwo.add("Mark");
        arrayTwo.add("James");
        arrayTwo.add("Mark");
        System.out.println(arrayTwo.lastIndexOf("Mark"));

        // addAll test
        List<String> arrayThree = new ArrayList<>();
        arrayThree.add("John");
        arrayThree.add("Jacob");
        arrayTwo.addAll(arrayThree);

    }
}