package edu.greenriver.sdev333;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void size() {
        List<String> friends = new ArrayList<String>();
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
        List<String> friends = new ArrayList<String>();
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
        List<String> friends = new ArrayList<String>();
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
    //not sure what to use for a test here
    }

    @Test
    void add() {
        List<String> friends = new ArrayList<String>();
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
    }

    @Test
    void remove() {
        List<String> friends = new ArrayList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.remove("Tina");
        assertEquals(2, friends.size());
        assertEquals("Jess", friends.get(0));
        assertEquals("Josh", friends.get(1));
    }

    @Test
    void clear() {
        List<String> friends = new ArrayList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals(3, friends.size());
        friends.clear();
        assertEquals(0, friends.size());
    }

    @Test
    void containsAll() {
        List<String> nemeses = new ArrayList<String>();
        nemeses.add("BR");
        nemeses.add("H2");
        List<String> friends = new ArrayList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals(false,friends.containsAll(nemeses));
        nemeses.clear();
        nemeses.add("Jess");
        assertEquals(true,friends.containsAll(nemeses));
    }

    @Test
    void addAll() {
        List<String> nemeses = new ArrayList<String>();
        nemeses.add("BR");
        nemeses.add("H2");
        List<String> friends = new ArrayList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals(3,friends.size());
        friends.addAll(nemeses);
        assertEquals(5,friends.size());
    }

    @Test
    void removeAll() {
        List<String> nemeses = new ArrayList<String>();
        nemeses.add("BR");
        nemeses.add("H2");
        List<String> friends = new ArrayList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add("BR");
        friends.add("H2");
        assertEquals(5,friends.size());
        friends.removeAll(nemeses);
        assertEquals(3,friends.size());
    }

    @Test
    void retainAll() {
    }

    @Test
    void get() {
        List<String> friends = new ArrayList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals("Jess", friends.get(0));
        assertEquals("Tina", friends.get(1));
        assertEquals("Josh", friends.get(2));
    }

    @Test
    void set() {
        List<String> friends = new ArrayList<String>();
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
        List<String> friends = new ArrayList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.add(1,"Thomas");
        assertEquals("Jess", friends.get(0));
        assertEquals("Thomas", friends.get(1));
        assertEquals("Tina", friends.get(2));
        assertEquals("Josh", friends.get(3));
        friends.add(4,"Thomas");
        assertEquals("Thomas", friends.get(4));
    }

    @Test
    void testRemove() {
        List<String> friends = new ArrayList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        friends.remove(1);
        assertEquals("Jess", friends.get(0));
        assertEquals("Josh", friends.get(1));
        assertEquals(false, friends.contains("Tina"));
    }

    @Test
    void indexOf() {
        List<String> friends = new ArrayList<String>();
        friends.add("Jess");
        friends.add("Tina");
        friends.add("Josh");
        assertEquals(1, friends.indexOf("Tina"));
        assertEquals(-1, friends.indexOf("Thomas"));
    }

    @Test
    void lastIndexOf() {
        List<String> friends = new ArrayList<String>();
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
        //not sure how to test this
    }
}