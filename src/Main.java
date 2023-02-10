import edu.greenriver.sdev333.*;

public class Main {
    public static void main(String[] args)
    {
        //construct singlylinkedlists of friends and students
        List<String> friends = new SinglyLinkedList<>();
        List<String> students = new SinglyLinkedList<>();
        List<String> otherPeople = new SinglyLinkedList<>();

        //test size=empty (because I haven't added anyone yet)yep
//        System.out.println("friends is empty: " + friends.isEmpty());//sb true
        //size should be 0 for same reason as above yep
 //       System.out.println("initial size is " + friends.size());//sb 0

        //add a friend
        friends.add("Katie");
        //check size = 1 yep
//        System.out.println("size is now " + friends.size());//sb 1
        //add more friends
        friends.add("Marcus");
        friends.add("Mel");
        friends.add("Deb");
        friends.add("Luis");
        friends.add("Andres");
        friends.add("Tyler");
        //test indexOf
//        System.out.println("Tyler is at index " + friends.indexOf("Tyler"));//here it should be 6
//        System.out.println("Size should be 7: " + friends.size());
        //add more friends
        friends.add("Kevan");
        friends.add("Carlos");
        friends.add("Melissa");
        friends.add("Trudy");
        friends.add("Melanie");
        //check index of non-existent entry--should return -1
//        System.out.println("Where is Dee? " + friends.indexOf("Dee"));//sb -1

        //Print out what is in my friends list and it's size
//        System.out.println("Size is now " + friends.size());//sb 12

        //add Gwen in at 3 and move everyone else down--check Gwen index, view arrayList, check size
        friends.add(3, "Gwen");
//        System.out.println("Gwen " + friends.indexOf("Gwen"));//sb 3

//        System.out.println("New size after adding Gwen is " + friends.size());//sb 13
//
//        //also check to see if everyone has moved to the correct position by checking before and after
//        System.out.println("Tyler is now at: " + friends.indexOf("Tyler"));//sb 7
//        System.out.println("Marcus is still at " + friends.indexOf("Marcus"));//sb 1

        //Try to add someone at invalid index
        //friends.add(16, "Person");//this works but commented out to test more code

        //Check who is at index 5 and remove (Luis)
//        System.out.println("Who is at index 5? " + friends.get(5));//sb Luis
        friends.remove(5);
        //Make sure Luis has been removed and that list is re-sized and test index before and after
//        System.out.println("friends: " + friends);
//        System.out.println("Size after index 5 is removed is now " + friends.size());//sb 12
//        System.out.println("Deb is now at: " + friends.indexOf("Deb"));//sb 4 no change
//        System.out.println("Trudy is now at " + friends.indexOf("Trudy"));//sb 10

        //Try an invalid index
        //friends.remove(22);//this works but commented out to test more code

        //remove a friend by name and check list
        friends.remove("Melanie");
//        System.out.println("friends with Melanie removed " + friends);
//        System.out.println("Size after Melanie removed: " + friends.size());//sb 11--its' saying 12
//
//        //check contains method
//        System.out.println("Mel is on the list " + friends.contains("Mel"));
//        System.out.println("Dee is on the list " + friends.contains("Dee"));

        //check setter method:
        //set friend at index 4 to "DJ" and print out
        friends.set(4, "DJ");
//        System.out.println("Changed index 4 to DJ: " + friends);//yep
//        System.out.println("Size should still be what it was last time: " + friends.size());//size should not change using setter method

        //add a duplicate and check both index methods
        friends.add("Carlos");
        friends.add("Susan");
//        System.out.println(friends);

//        System.out.println("indexOf Carlos: " + friends.indexOf("Carlos"));//sb 8
//        System.out.println(("lastIndexOf Carlos " + friends.lastIndexOf("Carlos")));//sb 11


        System.out.println("student list is: " + students.size());//should be 0
        System.out.println(friends.containsAll(students));//should be true
        //add some students that are friends
        students.add("Marcus");
        students.add("Mel");

//        otherPeople.add("Marcus");
//        otherPeople.add("Mel");
//        System.out.println("Students and otherPeople are equal " + students.equals(otherPeople));//sb true
        //check again

        friends.add(0,"Wednesday");
        ((SinglyLinkedList<String>) friends).addToFront("Dee");

        System.out.println("All students are friends: " + friends.containsAll(students));//should still be true
        //add a student who is not a friend
        students.add("Jessica");
        //check again
        System.out.println("All students are friends: " + friends.containsAll(students));//should be false

        System.out.println("Friends list before adding students " + friends);
        System.out.println("Students list: " + students);
        friends.addAll(students);
        System.out.println("Friends list with students added " + friends);

//        otherPeople.add("Jazmin");
        System.out.println("Students and otherPeople are equal " + students.equals(otherPeople));//sb false
        System.out.println("friends and students are equal " + friends.equals(students));//sb false
        friends.removeAll(students);
        System.out.println("Friends list with students removed " + friends);
        System.out.println("students: " + students);



        //check lazy deletion method: clear
        friends.clear();
        System.out.println("friends: " + friends);//should print just the word friends
    }//end main method
}//end class


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

            public int indexOf(ItemType item) throws NullPointerException{
        boolean nextNodeExists = true;
        //start at index 0
        int counter = 0;
        //instantiate new node
        Node current = head;

        if(head==null){
            nextNodeExists = false;
            return -1;
        }
        //check the first node
        while (nextNodeExists){
            if(current.data.equals(item)){
                return counter;
            }else {
                if(current.next!=null) {
                    current = current.next;
                    counter++;
                }else{
                nextNodeExists = false;
            }
        }
        return -1;
    }


    public int indexOf(ItemType item) throws NullPointerException{
        //start at index 0
        int counter = 0;
        //instantiate new node
        Node current = head;
        //check the first node
        do{
            //compare data against item parameter
            if (current.data.equals(item)) {
                //if it's there, return the count
                return counter;
                //if not, increment the counter and go back into the loop
                } else {
                current = current.next;
                counter++;
             }
            //as long as there is another node to go to
        }while(current.next!=null);
        //if you get to the end of the loop, it's not there so return -1
        return -1;
    }




        */
