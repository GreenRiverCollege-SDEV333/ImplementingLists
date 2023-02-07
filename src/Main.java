import edu.greenriver.sdev333.ArrayList;
import edu.greenriver.sdev333.List;
import edu.greenriver.sdev333.RecursiveLinkedList;
import edu.greenriver.sdev333.SinglyLinkedList;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        List<String> friends = new SinglyLinkedList<>();
        System.out.println("The initial size is: " + friends.size());
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
        ((SinglyLinkedList<String>) friends).addToFront("Friday");
        //((ArrayList<String>) friends).addToBack("Friday");
        System.out.println("The size is now: " + friends.size());


        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

//        ListIterator<String> fancyItr = friends.listIterator();
//        System.out.println("Testing listIterator<>");
//        while (fancyItr.hasNext()) {
//            String name = fancyItr.next();
//            System.out.println(name);
//        }
//        System.out.println();
//        while (fancyItr.hasPrevious()) {
//            String name = fancyItr.previous();
//            System.out.println(name);
//        }




    }


    public void testArrayListClass(ArrayList friends) {
                // contains test code
        System.out.println("");
        System.out.println("CONTAINS TEST CODE............");
        System.out.println("");
        //String stringToTest = null;
        String stringToTest = "10";
        System.out.println("Does our list contain " + stringToTest + "? " +
                friends.contains(stringToTest));

        // add( item ) test code
        // add( index, item ) test code
        System.out.println("");
        System.out.println("ADD TEST CODE............");
        System.out.println("");
        System.out.println("Size before add: " + friends.size());
        int indexToTest = 10;
        String stringToAddWithIndex = " added this string";
        String stringToAddWithoutIndex = "This should be added at the end";

        friends.add(indexToTest, stringToAddWithIndex);
        friends.add(stringToAddWithoutIndex);
        System.out.println("Size AFTER adds: " + friends.size());
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }


        // remove test code
        System.out.println("");
        System.out.println("REMOVE TEST CODE............");
        System.out.println("");
        System.out.println("Size BEFORE remove: " + friends.size());
        int indexToRemove = 0;
        friends.remove(indexToRemove);
        System.out.println("Size AFTER remove: " + friends.size());
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        // get test code
        // set test code
        System.out.println("");
        System.out.println("GET/SET TEST CODE............");
        System.out.println("");
        int indexToGet = 0;
        System.out.println("Get item at index " + indexToGet +
                            " = " + friends.get(indexToGet) );
        int indexToSet = 0;
        String newStringToSet = "Set this at index " + indexToSet;
        friends.set(indexToSet, newStringToSet);
        System.out.println("After set at index " + indexToGet + ": "
                            + friends.get(indexToSet));
    }

}