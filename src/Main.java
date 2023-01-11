import edu.greenriver.sdev333.*;

public class Main {
    public static void main(String[] args) {

        List<String> friends = new ArrayList<String>();
        System.out.println("initial size is " + friends.size());

        friends.add("Jess");
        friends.add("Tina");
        friends.add("Susan");
        friends.add("Tyler");
        friends.add("Usman");
        friends.add("Dee");
        friends.add("Rose");

        System.out.println(friends.get(0));
        System.out.println("Size is now " + friends.size());
    }
}