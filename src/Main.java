import edu.greenriver.sdev333.*;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args)
    {
/*        System.out.println("Hello world!");

        List<String> friends = new ArrayList<String>();
        System.out.println("Initial size is " + friends.size());
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
        friends.add(2,"Wednesday");
        System.out.println("size is now " + friends.size());
        //for (int i = 0; i < friends.size(); i ++)
        // System.out.println(friends.get(i))
        Iterator<String> itr = friends.iterator();
        while(itr.hasNext())
        {
            String name = itr.next();
            System.out.println(name);
        }
        for(String name : friends)
        {
            System.out.println(name);
        }*/

        //test (Method main (or jUnit tests) need to be present to demonstrate that you have tested what you have wrote)

        //Constructor: ArrayList()
        List<String> friends = new ArrayList<String>();

        //public void add(ItemType item)
        friends.add("Jack");

        //public int size() Should return 1
        System.out.println("Size of the Array : " + friends.size());

        //public boolean isEmpty() Should return false
        System.out.println("Is the Array Empty? " + friends.isEmpty());

        //public boolean contains(ItemType item) - hint: this method can use indexOf to do its work
        System.out.println("Does the Array contain Jack? " + friends.contains("Jack"));

        //public int indexOf(ItemType item)
        System.out.println("Index of 'Jack' is " + friends.indexOf("Jack"));

        //public void add(int index, ItemType item)
        friends.add(0,"Ken");
        System.out.println("Check if Ken is added to my frendsList, Ken's index is " + friends.indexOf("Ken"));
        System.out.println("Index of 'Jack' is " + friends.indexOf("Jack"));

        //public void remove(int index)
        friends.remove(1);
        //test this method
        System.out.println("Is Jack still in the List? " + friends.contains("Jack"));

        //public ItemType get(int index)
        System.out.println(friends.get(0));

        //public void set(int index, ItemType item)
        friends.set(0,"Jack");
        System.out.println("Now Ken changed to " + friends.get(0));

        //public void clear()
        friends.clear();
        System.out.println("Nothing in the Array List, the size of Friends is " + friends.size());

        //public Iterator<ItemType> iterator()
        friends.add("Jack");
        friends.add("Ken");
        friends.add("Brandon");
        Iterator<String> itr = friends.iterator();
        while(itr.hasNext())
        {
            String name = itr.next();
            System.out.println(name);
        }

        //Level 2 Requirements (to earn beyond 75-80% credit, up to 100%, if working properly)
        //Second constructor: ArrayList(int capacity) - allows the client to ask for an initial capacity for the underlying data array (instead of using our default of 10)
        List<String> friend = new ArrayList<String>(5);
        friend.add("JackOne");
        System.out.println("Is JackOne in the List? " + friend.contains("JackOne"));

        //public void remove(ItemType item) - hint: this method can use indexOf, then remove(index) to do its work
        friend.remove("JackOne");
        System.out.println("Is JackOne in the List? " + friend.contains("JackOne"));

        //**public int lastIndexOf(ItemType item)
        friends.add("Jack");
        System.out.println("the last index of Jack should be 3: which is : " + friends.lastIndexOf("Jack"));

        //**public void addAll(Collection<ItemType> otherCollection)
        friend.add("Jack");
        friend.add("Ken");
        friend.add("Brandon");
        friends.addAll(friend);

        //**public boolean equals(Object otherObject)
        System.out.println("Are they equal?" + friends.equals(friend));
        friend.clear();
        friends.clear();
        System.out.println("Are they equal?" + friends.equals(friend));
        friends.add("Jack");
        friend.add("Jack");
        System.out.println("Are they equal?" + friends.equals(friend));
        //public ListIterator<ItemType> listIterator()
        friends.add("Ken");
        friends.add("Brandon");
        ListIterator<String> itrL = friends.listIterator();
        while(itrL.hasNext())
        {
            String name = itrL.next();
            System.out.println(name);
            System.out.println(itrL.nextIndex());
        }
        while(itrL.hasPrevious())
        {
            String name = itrL.previous();
            System.out.println(name);
            System.out.println(itrL.previousIndex());
        }

        //**Move resizing code into its own private method, something like: private void resize(int newSize)
        //Move code to validate indexes into its own private method, something like: private boolean isValidIndex(int index)
        // those two methods are written in ArrayList.


    }

}