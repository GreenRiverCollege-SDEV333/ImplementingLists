import edu.greenriver.sdev333.ArrayList;
import edu.greenriver.sdev333.List;
import edu.greenriver.sdev333.RecursiveLinkedList;
import edu.greenriver.sdev333.SinglyLinkedList;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        List<String> friends = new SinglyLinkedList<>();
        System.out.println("Initial size is: " + friends.size()); //0
        friends.add("Jess");
        System.out.println("Size is now: " + friends.size()); //1
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
        System.out.println("Size is now: " + friends.size()); //13

        //test add at index
        friends.add(1, "Hello");
        //test add with errors
//        friends.add(-1, "Hello");
        System.out.println("Index of Hello = 1? " + friends.indexOf("Hello"));

        //below prints with hello after Jess
//        for(int i=0; i< friends.size(); i++){
//            System.out.println(friends.get(i));
//        }
        //test remove by item
        friends.remove("Hello"); //remove Hello
        //test remove by index
        friends.remove(0); //remove Jess


        List<String> friends2 = new SinglyLinkedList<>();
        friends2.add("John");
        friends2.add("Jake");
        friends2.add("Jenny");
        friends2.add("Joey");
        friends2.add("Jordan");
        friends2.add("Justin");
        friends2.add("Jill");
        friends2.add("Joe");

        List<String> friends3 = new SinglyLinkedList<>();
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
        System.out.println("Is this array empty: " + friends.isEmpty()); //false

        //test contains method
        System.out.println("This array contains John: " + friends.contains("John")); //true
        System.out.println("This array contains Joh: " + friends.contains("Joh")); //false
//        System.out.println("This method catches null parameter: " + friends.contains(null));

        //test containsAll
        System.out.println("Friends array contains all of friends2? " + friends.containsAll(friends2)); //true
        System.out.println("retains all below, should have 8 names");

        //test retainsAll
        friends.retainAll(friends2); //
        for(int i=0; i< friends.size(); i++){
            System.out.println(friends.get(i));
        }
        System.out.println();
        //test size method
        System.out.println("Size is now: " + friends.size()); //now 8
        System.out.println();

        //test addAll
        friends.addAll(friends3); //adds 3 names
        for(int i=0; i< friends.size(); i++){
            System.out.println(friends.get(i));
        }
        System.out.println();

        //test removeAll
        friends.removeAll(friends3); //removes the 3 that were added
        for(int i=0; i< friends.size(); i++){
            System.out.println(friends.get(i));
        }
        System.out.println();

        //test set
        friends.set(0, "Jesus"); //adds Jesus to front
        for(int i=0; i< friends.size(); i++){
            System.out.println(friends.get(i));
        }

        //test indexOf
        System.out.println("Index of Jesus: " + friends.indexOf("Jesus"));
        System.out.println( );


        List<String> friends4 = new RecursiveLinkedList<>();
        System.out.println("List size before add: " + friends4.size());

        friends4.add("John");
        friends4.add("Jake");
        friends4.add("Jenny");
        friends4.add("Joey");
        friends4.add("Jordan");
        friends4.add("Justin");
        friends4.add("Jill");
        friends4.add("Joe");

        System.out.println("List size after add: " + friends4.size());

    }
}