import edu.greenriver.sdev333.ArrayList;
import edu.greenriver.sdev333.List;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        List<String> friends = new ArrayList<String>();
        System.out.println("Initial size is: " + friends.size());
        friends.add("Jess");
        System.out.println("Size is now: " + friends.size());
        friends.add("John");
        friends.add("Jake");
        friends.add("Jenny");
        friends.add("Joey");
        friends.add("Jordan");
        friends.add("Justin");
        friends.add("Jill");
        friends.add("Joe");
        friends.add("Johnny");
        friends.add("Jacobi");
        friends.add("Juliet");
        friends.add("Jeremy");
        System.out.println("Size is now: " + friends.size());

        //test add at index
        friends.add(1, "Hello");
        //test add with errors
//        friends.add(-1, "Hello");

        //test remove by item
        friends.remove("Hello");
        //test remove by index
        friends.remove(0);


        List<String> friends2 = new ArrayList<String>();
        friends2.add("John");
        friends2.add("Jak");
        friends2.add("Jenny");
        friends2.add("Joey");
        friends2.add("Jordan");
        friends2.add("Justin");
        friends2.add("Jill");
        friends2.add("Joe");

        List<String> friends3 = new ArrayList<String>();
        friends3.add("Jose");
        friends3.add("Jun");
        friends3.add("Jeremiah");


        //test iterator
        Iterator<String> itr = friends.iterator();
        while(itr.hasNext()){
            String name = itr.next();
            System.out.println(name);
        }

        //test isEmpty method
        System.out.println("Is this array empty: " + friends.isEmpty());

        //test contains method
        System.out.println("This array contains John: " + friends.contains("John"));
        System.out.println("This array contains Joh: " + friends.contains("Joh"));
//        System.out.println("This method catches null parameter: " + friends.contains(null));

        //test containsAll
        System.out.println(friends.containsAll(friends2));

        //test retainsAll
        friends.retainAll(friends2);
        for(int i=0; i< friends.size(); i++){
            System.out.println(friends.get(i));
        }

        //test size method
        System.out.println("Size is now: " + friends.size());
        System.out.println();

        //test addAll
        friends.addAll(friends3);
        for(int i=0; i< friends.size(); i++){
            System.out.println(friends.get(i));
        }
        System.out.println();

        //test removeAll
        friends.removeAll(friends3);
        for(int i=0; i< friends.size(); i++){
            System.out.println(friends.get(i));
        }
        System.out.println();

        //test set
        friends.set(0, "Jesus");
        for(int i=0; i< friends.size(); i++){
            System.out.println(friends.get(i));
        }

        //test indexOf
        System.out.println("Index of Jesus: " + friends.indexOf("Jesus"));

    }
}