import edu.greenriver.sdev333.ArrayList;
import edu.greenriver.sdev333.List;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<String> friends = new ArrayList<>();
        System.out.println("Initial size is: " + friends.size());

        friends.add("Jess");
        friends.add("Kuma");
        friends.add("Jazmin");
        friends.add("Jess");
        friends.add("Mint");
        friends.add("John");
        friends.add("John");
        friends.add("K");
        friends.add("A");
        friends.add("f");
        friends.add("e");
        friends.add(2,"Wednesday");
        System.out.println("Size is now " + friends.size());

        System.out.println("John is at: " + friends.lastIndexOf("Dee"));
        System.out.println("Last index of John: " + friends.lastIndexOf("John"));
        //printing out everything in our list
        for (int i = 0; i < friends.size(); i++) {
        System.out.println(friends.get(i));
    }


//        //printing out friends name
//        for (int i = 0; i < friends.size(); i++) {
//            System.out.println(friends.get(i));
//        }


        //iterator is
        Iterator<String> itr = friends.iterator();
        while (itr.hasNext()){
            String name = itr.next();
            System.out.println(name);
        }

        for (String name : friends){
            System.out.println(name);
        }

    }
}