import edu.greenriver.sdev333.ArrayList;
import edu.greenriver.sdev333.List;

import java.util.Iterator;

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
        friends.add(2,"Wednesday");
        System.out.println("size is now " + friends.size());
        System.out.println("________________________");
        
//        for (int i = 0; i < friends.size(); i++) {
//            System.out.println(friends.get(i));
//        }

        // above: import java.util.Iterator;
        Iterator<String> itr = friends.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }
        System.out.println("________________________");

        for (String name : friends) {
            System.out.println(name);
        }

        List<String> secFriends = new ArrayList<>();
    }
}