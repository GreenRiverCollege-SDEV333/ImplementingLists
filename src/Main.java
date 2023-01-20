import edu.greenriver.sdev333.*;

import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<String> friends = new ArrayList<>();
        System.out.println("Initial size is " + friends.size());

        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add("Susan");
        friends.add("Tyler");
        friends.add("Dee");
        friends.add("Joe");
        friends.add("Sam");
        friends.add("Mark");
        friends.add("Joey");
        friends.add("Bart");

        System.out.println("size is now " + friends.size());

//        for (int i = 0; i < friends.size(); i++) {
//            System.out.println(friends.get(i));
//        }

        Iterator<String> itr = friends.iterator();
        while (itr.hasNext()){
            String name = itr.next();
            System.out.println(name);
        }

        for (String name: friends) {
            System.out.println(name);
        }
    }
}