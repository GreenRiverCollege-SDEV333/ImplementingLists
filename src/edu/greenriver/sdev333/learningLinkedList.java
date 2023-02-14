package edu.greenriver.sdev333;

import java.util.LinkedList;

public class learningLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        /*
        list.push("A");
        list.push("B");
        list.push("C");
        list.push("D");
        list.push("F");
        list.pop();
         */

        list.offer("A");
        list.offer("B");
        list.offer("C");
        list.offer("D");
        list.offer("F");
        list.poll();
        list.add(4,"E");
        list.remove("E");
        System.out.println(list.indexOf("B"));
        list.addFirst("0");
        list.addLast("Z");
        System.out.println(list.peekFirst() + "---" +list.peekLast());
        System.out.println(list);
        System.out.println(list.get(3));
    }


}
