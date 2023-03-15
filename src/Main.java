import edu.greenriver.sdev333.*;
import java.util.Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<String>();

        System.out.println("Initial size is " + friends.size());
        System.out.println(" ");
        friends.add("Brandon");
        friends.add("Paris");
        friends.add("Sean");
        friends.add("Jeff");
        friends.add("Tom");
        friends.add("Shannon");
        friends.add("Kody");
        friends.add("Kevin");
        friends.add("Jimmy");
        friends.add("Bob");
        friends.add("Gene");
        friends.add("Louise");
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }
        System.out.println(" ");
        //add friend @ index
        friends.add(7,"JEEBUS");
        //works

        Iterator<String> itr = friends.iterator();
        while(itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }
        System.out.println(" ");

        //Number of friends in array
        System.out.println("Size is " + friends.size());
        //works

        //Find last occurrence of friend with name at index
        System.out.println("JEEBUS is at index: " + friends.indexOf("JEEBUS"));
        //works
        System.out.println(" ");

        //Remove friend at index
        friends.remove(7);
        //works

        for (String name : friends) {
            System.out.println(name);
        }
        //re-adding removed friend
        friends.add(7,"JEEBUS");
        System.out.println(" ");

        //remove friend by name
        friends.remove("Gene");
        //works

        for (String name : friends) {
            System.out.println(name);
        }

    }
}