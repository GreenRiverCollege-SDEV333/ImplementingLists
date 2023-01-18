import edu.greenriver.sdev333.Arraylist;
import edu.greenriver.sdev333.List;
import java.util.Iterator;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");


        List<String> friends = new Arraylist<String>();
        System.out.println("Friends ArrayList initial size is " + friends.size());

        friends.add("Jess");
        friends.add("adam");
        friends.add("de");
        friends.add("kevin");
        friends.add("carl");
        friends.add("alex");
        friends.add("tony");
        friends.add("meadow");
        System.out.println("The Array list returns true if Jess in found within: " +friends.contains("Jess"));
        System.out.println(friends);
        System.out.println("size is now " + friends.size());
        System.out.println("The index of Jess is " +friends.indexOf("Jess"));

        System.out.println();
        friends.add(8,"karly");
        System.out.println(friends);
        System.out.println("size is now " + friends.size()+" and it should be 9");

        System.out.println();
       friends.add(0,"frank");
        System.out.println(friends);
        System.out.println("size is now " + friends.size()+" and it should be 10");

        System.out.println(friends.indexOf("kevin"));
        friends.remove(0);
        System.out.println(friends);
        System.out.println("size is now " + friends.size());

        friends.add(7,"tanner");
        System.out.println(friends);
        System.out.println("size is now " + friends.size());

        System.out.println();// seperation space

        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));

        }

        System.out.println();

    Iterator<String> itr = friends.iterator();
        while(itr.hasNext()){
            String name= itr.next();
            System.out.println(name);
        }
        System.out.println();
        for( String name: friends){
            System.out.println(name);
        }
       // friends.addAll(); will throw exception..fail fast
    }
}