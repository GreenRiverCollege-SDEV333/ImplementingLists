import edu.greenriver.sdev333.Arraylist;
import edu.greenriver.sdev333.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        List<String> friends = new Arraylist<String>();
        System.out.println("Initial size is " + friends.size());

        friends.add("Jess");
        friends.add("adam");
        friends.add("de");
        friends.add("kevin");
        friends.add("carl");
        friends.add("alex");
        friends.add("tony");
        friends.add("meadow");
        friends.add("aj");
        friends.add("Jess");
        friends.add("Jess");


        System.out.println("size is now " + friends.size());

       // friends.addAll(); will throw exception..fail fast
    }
}