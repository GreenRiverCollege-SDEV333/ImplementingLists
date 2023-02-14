package map_client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello");

        // keys | Value
        // domain names | IP address
        // green.edu | 128.....
        // zack.com | 128..

        Map<String, String> dnsTable = new TreeMap<>();
        // tree map, key comes out in order
        // hash map, keys appears to be random

        // put a few items into map
        dnsTable.put("greenriver.edu", "128.104.20.204");
        dnsTable.put("superbowl.net", "201.120.100.3");
        dnsTable.put("google.com", "101.101.101.101");

        System.out.println(dnsTable);

        // get: ask for key, get value. Return null if cant find key. Only can get key
        String answer = dnsTable.get("superbowl.net");
        System.out.println(answer);

        // change the value, update the value associated with the key
        dnsTable.put("greenriver.edu", "1.2.3.4.5");
        System.out.println(dnsTable.get("greenriver.edu"));


        Map<String, Integer> wordCounts = new TreeMap<>();

        Scanner scan = new Scanner(new File("src/notes.txt"));

        while (scan.hasNext()) {
            String word = scan.next();
            int i = 1;

            // check to see if the word is in the map
            if(wordCounts.containsKey(word)) {

                int value = wordCounts.get(word); // get current value
                value++; // increment by one
                wordCounts.put(word,value); // update key and return increment value

                // create hash set for max value
                int maxValue = value;

                Map<String, Integer> maxSet = new HashMap<>();
                if(wordCounts.containsValue(value)) {
                    maxSet.put(word,maxValue);
                }

            }
            // put key word and value in tree map
            wordCounts.put(word, i);
        }

        // write a loop to walk through (visit) items in the map
        for (String key : wordCounts.keySet()) {
            int value = wordCounts.get(key);
            System.out.println("word "+key
            + " appears " + value + " times.");
        }

        for (int value : wordCounts.values()) {
            System.out.println(value);
        }


        LinkedMap<String, Integer> smallEx = new LinkedMap<>();
        smallEx.put("S",0);
        smallEx.put("E",1);
        smallEx.put("A",2);


    }
}
