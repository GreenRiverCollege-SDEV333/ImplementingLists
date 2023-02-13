import edu.greenriver.sdev333.*;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();
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
        friends.add(2, "Wednesday");
        System.out.println("size is now " + friends.size());

        //for (int i = 0; i < friends.size(); i++) {
        //    System.out.println(friends.get(i));
        //}

        // above iterator import
        Iterator<String> itr = friends.iterator();
        while(itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }

        for (String name : friends) {
            System.out.println(name);
        }

        System.out.println();

        ListIterator<String> fancyItr = friends.listIterator();
        while (fancyItr.hasNext()) {
            String name = fancyItr.next();
            System.out.println(name);
        }
        System.out.println();
        while (fancyItr.hasPrevious()) {
            String name = fancyItr.previous();
            System.out.println(name);
        }
        //

    }
}