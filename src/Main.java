import edu.greenriver.sdev333.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<String> friends = new ArrayList<String>();
        System.out.println("initial size is " + friends.size());

        friends.add("Jose");
        friends.add("Jesse");
        friends.add("Jesus");
        friends.add("Derek");
        friends.add("Stephen");
        friends.add("Binal");
        friends.add("Simon");
        friends.add("Herb");
        friends.add("Roman");
        friends.add("Kye");
        friends.add("Matt");
        friends.add("Cullen");

        System.out.println("size is now" + friends.size());
    }
}