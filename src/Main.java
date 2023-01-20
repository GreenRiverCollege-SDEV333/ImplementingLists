import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Constructor test
        List<String> friends = new ArrayList<String>();

        //testing size()
        System.out.println("initial size is " + friends.size());

        //testing isEmpty()
        System.out.println("it is empty: " + friends.isEmpty());

        //testing add(ItemType item)
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

        //above: import java.util.iterator
        //testing iterator
        Iterator<String> itr = friends.iterator();
        while(itr.hasNext()){
            String name = itr.next();
            System.out.println(name);
        }

        for(String name : friends){
            System.out.println(name);
        }

        //testing add(int index, ItemType item)
        friends.add(2, "Wednesday");
        for(String name : friends){
            System.out.println(name);
        }

        //testing indexOf
        System.out.println(friends.indexOf("Wednesday"));

        //testing contains
        System.out.println(friends.contains("Wednesday"));

        //testing remove(int index)
        friends.remove(2);
        for(String name : friends){
            System.out.println(name);
        }

        //testing ItemType get(int index)
        System.out.println(friends.get(0));

        //testing set(int index, ItemType item)
        friends.set(0, "Pugsley");
        System.out.println(friends.get(0));

        //testing clear()
        friends.clear();
        System.out.println(friends.isEmpty());

        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add("Susan");
        friends.add("Tyler");
        friends.add("Usman");

        //testing remove(itemType item)
        friends.remove("Susan");
        for(String name : friends){
            System.out.println(name);
        }



    }
}