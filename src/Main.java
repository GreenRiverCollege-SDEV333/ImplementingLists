import edu.greenriver.sdev333.*;

import java.sql.SQLOutput;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<String> friends = new ArrayList<String>();
        System.out.println("initial size is " + friends.size());

        friends.add("Jose");
        friends.add("Jesse");
        friends.add("Jesus");
        friends.add("Derek");
        friends.add("Stephen");
        friends.add("Binal");
        friends.add("Simon");
        friends.add("Herb");
        friends.add("Roman");
        friends.add("Kye");
        friends.add("Matt");
        friends.add("Cullen");

        System.out.println("size is now" + friends.size());

//        for (int i = 0; i < friends.size(); i++) {
//            System.out.println(friends.get(i));
//
//        }
        Iterator<String> itr = friends.iterator();
        while(itr.hasNext()){
            String name = itr.next();
            System.out.println(name);
        }

        for(String name : friends) {
            System.out.println(name);
        }

        System.out.println("the size of my friends arraylist right now is "
        + friends.size() + ", " + "and the " + friends.isEmpty() + " means its not empty.");
        System.out.println(friends.contains("Jesse") + " ,my friend Jesse is in the array");
        System.out.println("the index of my friend jesse in the array is " + friends.indexOf("Jesse"));
        friends.add("Todd");
        friends.add(3, "Jack");
        friends.remove(0);
        System.out.println("my friend is " + friends.get(6) + " at index 6.");
        friends.set(0, "Jesse");
        System.out.println("Now my friend at the top spot index 0 is " + friends.get(0));
        System.out.println("Is Todd in my Array true or false?... " + friends.contains("Todd"));
        //friends.clear();




    }
}