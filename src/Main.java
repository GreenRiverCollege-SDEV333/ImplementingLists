import edu.greenriver.sdev333.*;
import java.util.Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<String>();

        System.out.println("Initial size is " + friends.size());

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
        friends.add(7,"JEEBUS");



//        for (int i = 0; i < friends.size(); i++) {
//            System.out.println(friends.get(i));
//        }


        Iterator<String> itr = friends.iterator();
        while(itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }

        System.out.println("Size is " + friends.size());

//        for (String name : friends) {
//            System.out.println(name);
//        }

    }
}