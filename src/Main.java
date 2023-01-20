import edu.greenriver.sdev333.*;

public class Main {
    public static void main(String[] args)
    {
        //default constructor
        List<String> friends = new ArrayList<String>();
        //parameterized constructor
        List<String> students = new ArrayList<>(15);

        //should print out true because I haven't added anyone yet
        System.out.println(friends.isEmpty());
        //size should be 0 for same reason as above
        System.out.println("initial size is " + friends.size());

        //add a friend
        friends.add("Katie");
        //check size
        System.out.println("size is now " + friends.size());
        //add more friends
        friends.add("Marcus");
        friends.add("Mel");
        friends.add("Deb");
        friends.add("Luis");
        friends.add("Andres");
        friends.add("Tyler");
        //test indexOf
        System.out.println("Tyler is at index " + friends.indexOf("Tyler"));//here it comes out 6
        //add more friends
        friends.add("Kevan");
        friends.add("Carlos");
        friends.add("Melissa");
        friends.add("Trudy");
        friends.add("Melanie");
        //check index of non-existent entry--should return -1
        System.out.println(friends.indexOf("Dee"));
         /*
         Some ways to print out what is in array list
         I used a toString method
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        import java.util.Iterator
        //long version of for each loop

        Iterator<String> itr = friends.iterator();
        while (itr.hasNext()){
            String name = itr.next();
            System.out.println(name);
        }

        for (String name : friends) {
            System.out.println(name);
        }
        */

        //Print out what is in my friends list and it's size
        System.out.println(friends);
        System.out.println("Size is now " + friends.size());

        //add Gwen in at 3 and move everyone else down--check Gwen index, view arrayList, check size
        friends.add(3, "Gwen");
        System.out.println("Gwen " + friends.indexOf("Gwen"));
        System.out.println(friends.toString());
        System.out.println("New size is " + friends.size());
        //also check to see if everyone has moved to the correct position by checking before and after
        System.out.println("Tyler is now at: " + friends.indexOf("Tyler"));
        System.out.println("Marcus is still at " + friends.indexOf("Marcus"));

        //Try to add someone at invalid index
        //friends.add(16, "Person");//this works but commented out to test more code

        //Check who is at index 5 and remove (Luis)
        friends.get(5);
        friends.remove(5);
        //Make sure Luis has been removed and that list is re-sized and test index before and after
        System.out.println(friends.toString());
        System.out.println("Size is now " + friends.size());
        System.out.println("Deb is now at: " + friends.indexOf("Deb"));
        System.out.println("Trudy is now at " + friends.indexOf("Trudy"));
        //Try an invalid index
        //friends.remove(22);//this works but commented out to test more code

        //remove a friend by name and check list
        friends.remove("Melanie");
        System.out.println(friends);

        //check contains method
        System.out.println("Mel is on the list " + friends.contains("Mel"));
        System.out.println("Dee is on the list " + friends.contains("Dee"));

        //check setter method:
        //set friend at index 4 to "DJ" and print out
        friends.set(4, "DJ");
        System.out.println(friends);


        System.out.println(students.size());//should be 0
        System.out.println(friends.containsAll(students));//should be true
        //add some students that are friends
        students.add("Marcus");
        students.add("Mel");
        //check again
        System.out.println("All students are friends: " + friends.containsAll(students));//should still be true
        //add a student who is not a friend
        students.add("Jessica");
        //check again
        System.out.println("All students are friends: " + friends.containsAll(students));//should be false

        friends.removeAll(students);
        System.out.println("Friends list with students removed" + friends);
        System.out.println("students" + students);

        //add a duplicate and check both index methods
        friends.add("Carlos");
        System.out.println("indexOf Carlos: " + friends.indexOf("Carlos"));
        System.out.println(("lastIndexOf Carlos " + friends.lastIndexOf("Carlos")));

        friends.addAll(students);
        System.out.println("Friends list with students added" + friends);

        //check lazy deletion method: clear
        friends.clear();
        System.out.println("friends" + friends);//should print just the word friends
    }//end main method
}//end class

