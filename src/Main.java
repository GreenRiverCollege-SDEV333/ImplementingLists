import edu.greenriver.sdev333.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
/*
        List<String> friends = new ArrayList<>();

        System.out.println("initial size is " + friends.size());

        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add("Susan");
        friends.add("Dee");
        friends.add("Tyler");
        friends.add("Usman");
        friends.add("Rose");
        friends.add("Blanche");
        friends.add("Dorothy");
        friends.add("Sophia");

        System.out.println("size is now " + friends.size());
 */
        System.out.println();
        System.out.println("Create list of integers, adding 10 elements, 1 .. 10");
        List<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        intList.add(8);
        intList.add(9);
        intList.add(10);

        System.out.println("Size: " + intList.size());
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Adding 20 to list");
        intList.add(20);
        System.out.println("Size: " + intList.size());
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i) + " ");
        }
        System.out.println();
        System.out.println();


        System.out.println("Setting index 8 (#9) to 90");
        intList.set(8, 90);
        System.out.println("Size: " + intList.size());
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Set 40 at index 4");
        intList.add(4,40);
        System.out.println("Size: " + intList.size());
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Testing indexOf(item), index of 90 should be 9.");
        System.out.println(intList.indexOf(90));
        System.out.println("Testing indexOf(item), index of 3 should be 2.");
        System.out.println(intList.indexOf(3));
        System.out.println();
        System.out.println();


        System.out.println("Adding 5, then 30, then 35 to list");
        intList.add(5);
        intList.add(30);
        intList.add(35);
        System.out.println("Size: " + intList.size());
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Finding last index of 5, should be 12");
        System.out.println("Calculated lastIndex of 5: " + intList.lastIndexOf(5));
        System.out.println();
        System.out.println();

    }
}