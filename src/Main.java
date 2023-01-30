import edu.greenriver.sdev333.Arraylist;
import edu.greenriver.sdev333.List;
import edu.greenriver.sdev333.SinglyLinkedList;

import java.util.Iterator;
import java.util.ListIterator;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");


        List<String> friends = new SinglyLinkedList<String>();

        System.out.println();
        System.out.println(friends);
        System.out.println("Friends SingleyLinkedList initial size is " + friends.size());
        System.out.println("Is friends SingleyLinkedList currently empty:"+friends.isEmpty());

        System.out.println("Adding friends...");
        System.out.println();


        friends.add("Jess");
        friends.add("adam");
        friends.add("kevin");
        friends.add("carl");
        friends.add("alex");
        friends.add("tony");
        friends.add("meadow");

        System.out.println("Is friends SingleyLinkedlist still empty:"+friends.isEmpty());
        System.out.println();

        Iterator<String> itr = friends.iterator();
            while(itr.hasNext()){
                String name = itr.next();
                System.out.println(name);
            }

        // this is not implemented yet!
        ListIterator<String> fancyItr = friends.listIterator();
        while(itr.hasNext()){
            String name = itr.next();
            System.out.println(name);
        }
        System.out.println();
            while(fancyItr.hasPrevious()){
                String name = fancyItr.previous();
                System.out.println(name);
            }


//        nemesis.add("Jess");
//        nemesis.add("adam");
//        nemesis.add("de");
//        nemesis.add("tony");
//        nemesis.add("kevin");
//        nemesis.add("carl");
//        nemesis.add("alex");
//        nemesis.add("tony");
//        nemesis.add("meadow");

      //  System.out.println("the last occurance of tony in nemesis is index " +nemesis.lastIndexOf("tony"));
        System.out.println("The friends SingleyLinkedList returns true if Jess in found within: " +friends.contains("Jess"));
       // System.out.println("The nemesis Array list returns true if kevin in found within: " +nemesis.contains("Kevin"));

       // System.out.println("are all my friends my enemies?:"+nemesis.containsAll(friends));
        System.out.println();
        System.out.println("friends:"+friends);
       // System.out.println("nemesis:"+nemesis);
        System.out.println();
        System.out.println("size is now " + friends.size());
        System.out.println("The index of Jess is " +friends.indexOf("Jess"));

//        System.out.println();
//        System.out.println("adding friend karly to index 4");
//        friends.add(4,"karly");
//        System.out.println(friends);
//        System.out.println("size is now " + friends.size()+" and it should be 9");
//
//        System.out.println();
//        System.out.println("adding frank to index 0");
//       friends.add(0,"frank");
//        System.out.println(friends);
//        System.out.println("size is now " + friends.size()+" and it should be 10");
//        System.out.println();
//
//        System.out.println( "aye, some body get "+friends.get(4));
//
//
//        System.out.println("kevin is at index "+friends.indexOf("kevin"));
//        friends.set(4,"parker");
//        System.out.println("wait actually " +friends.get(4) +" is at index 4, i forgot");
//        System.out.println();
//        System.out.println("removing friend at index 0, and de has got to go!");
//        friends.remove(0);
//        friends.remove("de");
//        System.out.println(friends);
//        System.out.println("size is now " + friends.size());
//        System.out.println();
//
//        friends.add(7,"tanner");
//        System.out.println(friends);
//        System.out.println("size is now " + friends.size());
//        System.out.println("adding a few more friends");
//        friends.add("Tasha");
//        friends.add("Ozzy");
//        System.out.println("friends now has a size of "+friends.size());
//        for (int i = 0; i < 50; i++) {
//            friends.add(" all the homies");
//
//        }
//        System.out.println("Oh snap, all the homies came through!");
//        System.out.println("friends now has a size of "+ friends.size());
//        System.out.println("friends:"+friends);
//        nemesis.clear();
//        System.out.println("");
//        System.out.println("oh crap, you just said you liked pineapple on pizza.");
//    //    nemesis.addAll(friends);
//        System.out.println("nemesis:"+nemesis);
//        friends.removeAll(nemesis);
//        System.out.println("friends:"+friends);
//
//        System.out.println();// seperation space
//        System.out.println("all right parties over! clear out" );
//        friends.clear();
//        System.out.println("The friends array list now has a size of "+friends.size()+" because of your pizza peccadilloes");
//
//        // demoing how the iterator object is basically an enhanced forloop
////        for (int i = 0; i < friends.size(); i++) {
////            System.out.println(friends.get(i));
////
////        }
////        */
////        System.out.println();
////
////         Iterator<String> itr = friends.iterator();
////        while(itr.hasNext()){
////            String name= itr.next();
////            System.out.println(name);
////        }
////        System.out.println();
////        for( String name: friends){
////            System.out.println(name);
////        }
////       // friends.addAll(); will throw exception..fail fast
    }
}