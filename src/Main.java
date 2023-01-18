import edu.greenriver.sdev333.ArrayList;
import edu.greenriver.sdev333.List;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        List<String> friends = new ArrayList<String>();
        //System.out.println("Initial size is " + friends.size());
        friends.add("1");
        friends.add("2");
        friends.add("3");
        friends.add("4");
        friends.add("5");
        friends.add("6");
        friends.add("7");
        friends.add("8");
        friends.add("9");
        friends.add("10");
        friends.add("11");

        System.out.println("Size before add: " + friends.size());
        friends.add(10, "test");
        System.out.println("Size AFTER add: " + friends.size());
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        // import java.util.Iterator;
        // iterator test code
//        Iterator<String> itr = friends.iterator();
//        while (itr.hasNext()){
//            String name = itr.next();
//            System.out.println(name);
//        }
//
//        for (String name : friends) {
//            System.out.println(name);
//        }
    }
}