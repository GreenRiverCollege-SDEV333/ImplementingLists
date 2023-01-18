import edu.greenriver.sdev333.*;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        List<String> friends = new ArrayList<String>();
        System.out.println("initial size is " + friends.size());

        friends.add("Jess");
        friends.add("Tina");
        friends.add("Susan");
        friends.add(0,"Bob");

        System.out.println(friends.get(0));
        System.out.println("Size is now " + friends.size());

        // friends .add all will cause an intentional crash

//        for (int i = 0; i < friends.size() ; i++) {
//            System.out.println(friends.get(i));
//        }

        // above : import java.util.Itereator;
        Iterator<String> itr = friends.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }

        for(String name:friends) {
            System.out.println(name);
        }
    } // end of main method
 } // end of main class