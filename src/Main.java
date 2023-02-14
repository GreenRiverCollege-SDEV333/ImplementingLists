import edu.greenriver.sdev333.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        List<String> friends = new ArrayList<>();
        System.out.println("initial size is " + friends.size());

        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add("Susan");
        friends.add("Tyler");
        friends.add("Usman");
        friends.add("Dee");
        friends.add("Rose");
        friends.add("Blanche");
        friends.add("Dorothy");
        friends.add("Sophia");
        System.out.println("size is now " + friends.size());

        //for (int i = 0; i < friends.size(); i++) {
        //    System.out.println(friends.get(i));
        //}

        // above: import java.util.Iterator;
        Iterator<String> itr = friends.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }


        for (String name : friends) {
            System.out.println(name);
        }

        List<Integer> numbers = new ArrayList<>(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.print("numbers list: ");
        for (Integer number : numbers){
            System.out.print(number + " ");
        }

        System.out.println("\n Last index of 5 is: " + numbers.lastIndexOf(5));
        System.out.println("Last index of Josh is: " + friends.lastIndexOf("Josh"));

        List<String> Friend2 = new ArrayList<String>(2);
        Friend2.add("Rover");
        Friend2.add("Ronaldo");

        List<String> Friend3 = new ArrayList<String>(2);
        Friend3.add("Rover");
        Friend3.add("Ronaldo");


        System.out.println("\n Equal: " + Friend2.equals(Friend3) + " (Should be true)");
        System.out.println("\n Equal: " + friends.equals(Friend3) + " (Should be false)");

        Friend2.addAll(friends);
        Iterator<String> itr2 = Friend2.iterator();
        System.out.print("All friends (addAll method): ");
        while (itr2.hasNext()) {
            String name = itr2.next();
            System.out.print(name + " ");
        }

        ListIterator<Integer> numbersIterator = numbers.listIterator();

        // Traversing elements
        System.out.print("\n Forward Direction Iteration: ");
        while(numbersIterator.hasNext()){
            System.out.print(numbersIterator.next()+ " ");
        }

        // Traversing elements, the iterator is at the end at this point
        System.out.print("\n Backward Direction Iteration: ");
        while(numbersIterator.hasPrevious()){
            System.out.print(numbersIterator.previous() + " ");
        }
        //resize testing [1,2,3,4,5] <- length = 5, double length to 10 add 6 to array ->
        //[1,2,3,4,5,6,null,null,null,null] size is 6 now
        numbers.add(6);

        //index 6 is out of bound to test method isValidIndex throw index is beyond size
        //uncomment line 96 to test.
        //System.out.println("\n \n" + numbers.get(6));

        //-------------> Singly LinkedList  <------------------------
        List<String> numString = new SinglyLinkedList<>();

        System.out.println("");
        //check empty method
        System.out.println("Empty: " + numString.isEmpty() + " Expected: true");

        //check 2 different add methods
        numString.add("two");
        numString.add("three");
        numString.add(0, "one");
        numString.add("five");
        numString.add(3, "four");

        //check size method
        System.out.println("Size: " + numString.size() + " Expected: 2");

        //check contains method
        System.out.println("Contain two?: "+ numString.contains("two") + " Expected: true");

        //check index of method
        System.out.println("Index of One: "+ numString.indexOf("two") + " Expected: 1");

        //check remove item method
        numString.remove("one");
        Iterator<String> numLetter = numString.iterator();
        while (numLetter.hasNext()) {
            String name = numLetter.next();
            System.out.print(name + " ");
        }

        System.out.println("----> Expected: two three four five");

        //Check get method
        System.out.println("Get index 0 is: " + numString.get(0) + " Expected: two");

        //add another four to LinkedList to test lastIndexOf
        numString.add("four");
        System.out.println("Last index/occurrence of four " + numString.lastIndexOf("four") + " Expected: 4");

        SinglyLinkedList<String> numString2 = new SinglyLinkedList<>();
        numString2.add("five");
        numString2.add("six");
        numString2.add("seven");

        //Check addAll and iterator method
        System.out.print("Before addALL: ");
        Iterator<String> item1 = numString.iterator();
        while (item1.hasNext()) {
            String name = item1.next();
            System.out.print(name + " ");
        }
        System.out.println("");
        System.out.print("After addAll: ");
        numString.addAll(numString2);
        Iterator<String> item = numString.iterator();
        while (item.hasNext()) {
            String name = item.next();
            System.out.print(name + " ");
        }
        System.out.println("");

        //Check equals method
        System.out.println("numString1 is not equal numString2 -- " + numString.equals(numString2) + " Expected: false");
        SinglyLinkedList<String> numString3 = new SinglyLinkedList<>();
        numString3.add("five");
        numString3.add("six");
        numString3.add("seven");
        System.out.println("numString2 is equal numString3 -- " + numString2.equals(numString3) + " Expected: true");
        //check containsAll method part 1 - true case
        System.out.println("numString2 is contain all element of numString3 -- " + numString2.containsAll(numString3) + " Expected: true");

        //test set method will change five to One
        numString3.set(0, "One");

        //test listIterator
        System.out.print("Expected: One six seven (five was replaced by One) -- result: ");
        ListIterator<String> word = numString3.listIterator();
        while (word.hasNext()) {
            String name = word.next();
            System.out.print(name + " ");
        }

        //check remove index
        numString3.remove(2);
        System.out.print("\n this will remove the index number 2, which is seven. --> ");
        System.out.print("result: ");
        for (String i : numString3)
        {
            System.out.print(i + " ");
        }

        //add seven again to test remove all
        System.out.println("");
        numString3.add("seven");
        //numString2 {five, six, seven}
        //numString3 {One, six, seven}
        //Removes all of numString2 collection's items that are also contained in the
        //specified numString3
        numString2.removeAll(numString3);
        System.out.print("Expected: five --> result: ");
        for (String x : numString2)
        {
            System.out.print(x + " ");
        }

        System.out.println("");

        //check containsAll method part 2 - false case because element of numString3 is different now
        System.out.println("numString2 is contain all element of numString3 -- " + numString2.containsAll(numString3) + " Expected: false");

        //test hashcode
        System.out.println("Hashcode of numString2 list is: " + numString2.hashCode());

        //Check clear method
        numString.clear();
        System.out.println("Clear Linked List, size will be " + numString.size() + " -- Expected: 0");

        // test retainAll method -- Tried but not working don't know why
        SinglyLinkedList<String> numString4 = new SinglyLinkedList<>();
        numString4.add("One");
        numString4.add("seven");
        for (String i : numString3){
            System.out.println(i);
        }

        numString3.retainAll(numString4);
        for (String i : numString3){
            System.out.println(i);
        }
    }
}