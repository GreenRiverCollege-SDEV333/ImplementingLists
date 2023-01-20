import edu.greenriver.sdev333.*;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        List<String> friends = new ArrayList<String>();
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
        //System.out.println("size is now " + friends.size());

//        for (int i = 0; i < friends.size(); i++) {
//            System.out.println(friends.get(i));
//        }


        //above: import java.util.Iterator;
        Iterator<String> itr = friends.iterator();
        while(itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }
        System.out.println("size is now " + friends.size());

        //remove wednesday from list
        System.out.println("Test index remove");
        friends.remove(2);

        for (String name : friends) {
            System.out.println(name);
        }
        System.out.println("size is now " + friends.size());

        System.out.println("Index of Rose: " + friends.indexOf("Rose"));
        //test indexOf for item that doesn't exist in list
        System.out.println("Index of Casper: " + friends.indexOf("Casper"));

        //friends.addAll(...) will cause
    }
}