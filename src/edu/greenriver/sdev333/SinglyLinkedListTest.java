package edu.greenriver.sdev333;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void size() {
        List<String> friends = new SinglyLinkedList<String>();
        assertEquals(0,friends.size());
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
        assertEquals(11,friends.size());
    }

    @Test
    void isEmpty() {
        List<String> friends = new SinglyLinkedList<String>();
        assertEquals(true,friends.isEmpty());
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
        assertEquals(false,friends.isEmpty());
    }

    @Test
    void contains() {
        List<String> friends = new SinglyLinkedList<String>();
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
        assertEquals(true,friends.contains("Tyler"));
        assertEquals(false,friends.contains("Thomas"));
    }

    @Test
    void iterator() {
        List<String> friends = new SinglyLinkedList<String>();
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
        for (String friend : friends
             ) {
            System.out.println(friend);
        }
    }

    @Test
    void add() {
        List<String> friends = new SinglyLinkedList<String>();
        assertEquals(0, friends.size());
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
        assertEquals(11, friends.size());
        friends.add(5,"Sophia");
        assertEquals(12, friends.size());
        assertEquals("Sophia", friends.get(5));
        assertEquals("Tyler", friends.get(4));
        assertEquals("Usman", friends.get(6));
        friends.add(6,"Dorothy");
        friends.add(7,"Sophia");
        assertEquals("Sophia", friends.get(7));
        assertEquals("Dorothy", friends.get(6));
        friends.add(0,"Sophia");
        assertEquals("Sophia", friends.get(0));
    }

    @Test
    void remove() {
        List<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess"); //change next //previous
        friends.add("Tina"); //current
        friends.add("Josh"); // to here //current.next
        friends.remove(1);
        System.out.println(friends.toString());
        assertEquals(2, friends.size());
        assertEquals("Jess", friends.get(0));
        assertEquals("Josh", friends.get(1));
        friends.remove(0);
        assertEquals("Josh", friends.get(0));


    }
    @Test
    void equalsAll(){
        SinglyLinkedList<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess"); //change next //previous
        friends.add("Tina"); //current
        friends.add("Josh"); // to here //current.next
        SinglyLinkedList<String> friends2 = new SinglyLinkedList<String>();
        friends2.add("Jess"); //change next //previous
        friends2.add("Tina"); //current
        friends2.add("Josh"); // to here //current.next
        assertEquals(true, friends.equalsAll(friends2));
        friends2.add("Thomas");
        assertEquals(false, friends.equalsAll(friends2));


    }
    @Test
    void clear() {
        List<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals(3, friends.size());
        friends.clear();
        assertEquals(0, friends.size());
    }

//    @Test
//    void containsAll() {
//        List<String> nemeses = new SinglyLinkedList<String>();
//        nemeses.add("BR");
//        nemeses.add("H2");
//        List<String> friends = new SinglyLinkedList<String>();
//        friends.add("Jess");
//        friends.add("Tina");
//        friends.add("Josh");
//        assertEquals(false,friends.containsAll(nemeses));
//        nemeses.clear();
//        nemeses.add("Jess");
//        assertEquals(true,friends.containsAll(nemeses));
//    }

    @Test
    void addAll() {
        List<String> nemeses = new SinglyLinkedList<String>();
        nemeses.add("BR");
        nemeses.add("H2");
        List<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals(3,friends.size());
        friends.addAll(nemeses);
        assertEquals(5,friends.size());
    }

//    @Test
//    void removeAll() {
//        List<String> nemeses = new SinglyLinkedList<String>();
//        nemeses.add("BR");
//        nemeses.add("H2");
//        List<String> friends = new SinglyLinkedList<String>();
//        friends.add("Jess");
//        friends.add("Tina");
//        friends.add("Josh");
//        friends.add("BR");
//        friends.add("H2");
//        assertEquals(5,friends.size());
//        friends.removeAll(nemeses);
//        assertEquals(3,friends.size());
//    }

    @Test
    void retainAll() {
    }

    @Test
    void get() {
        List<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals("Jess", friends.get(0));
        assertEquals("Tina", friends.get(1));
        assertEquals("Josh", friends.get(2));
    }

    @Test
    void set() {
        List<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.set(1,"Thomas");
        assertEquals("Jess", friends.get(0));
        assertEquals("Thomas", friends.get(1));
        assertEquals("Josh", friends.get(2));

    }

    @Test
    void testAdd() {
        List<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add(1,"Thomas");
        assertEquals("Jess", friends.get(0));
        assertEquals("Thomas", friends.get(1));
        assertEquals("Tina", friends.get(2));
        assertEquals("Josh", friends.get(3));
    }

    @Test
    void testRemove() {
        List<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.remove(1);
        assertEquals("Jess", friends.get(0));
        assertEquals("Josh", friends.get(1));
        assertEquals(false, friends.contains("Tina"));
        friends.remove("Josh");
        assertEquals(false, friends.contains("Josh"));
    }

    @Test
    void indexOf() {
        List<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals(1, friends.indexOf("Tina"));
        assertEquals(-1, friends.indexOf("Thomas"));
    }

    @Test
    void lastIndexOf() {
        List<String> friends = new SinglyLinkedList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals(4, friends.lastIndexOf("Tina"));
        assertEquals(-1, friends.lastIndexOf("Thomas"));
    }

    @Test
    void listIterator() {
        //not sure how to test this (print out in for each loop)
    }



}
