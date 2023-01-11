import edu.greenriver.sdev333.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        List<String> friends = new ArrayList<String>();
        System.out.println("initial size is " + friends.size());

        friends.add("Katie");
        System.out.println("size is now " + friends.size());

        friends.add("Marcus");
        System.out.println("new size is " + friends.size());
        friends.add("Melanie");
        friends.add("Deb");
        friends.add("Luis");
        friends.add("Andres");
        friends.add("Tyler");
        friends.add("Kevin");
        friends.add("Carlos");
        friends.add("Melissa");
        friends.add("Trudy");
        friends.add("Mel");
        System.out.println("Yay! I have " + friends.size() + " friends!");
    }//end main method
}//end class