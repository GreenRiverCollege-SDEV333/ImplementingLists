import edu.greenriver.sdev333.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<String> friends = new ArrayList<String>();
        System.out.println("Initial size is " + friends.size());

        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add("Susan");
        friends.add("Tyler");
        friends.add("Dee");
        friends.add("Joe");
        friends.add("Sam");
        friends.add("Mark");
        friends.add("Joey");
        friends.add("Bart");
        System.out.println("size is now " + friends.size());
    }
}