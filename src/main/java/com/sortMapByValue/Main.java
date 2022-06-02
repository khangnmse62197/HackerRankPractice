package main.java.com.sortMapByValue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<String, MyObj> myMap = new HashMap<>();
        MyObj myObj = new MyObj("aaaa", 1);
        MyObj myObj2 = new MyObj("abz", 1);
        MyObj myObj3 = new MyObj("aab", 1);

        myMap.put("1", myObj2);
        myMap.put("2", myObj);
        myMap.put("3", myObj3);

        System.out.println(myMap);


        Map<String, MyObj> myMap2 = new TreeMap<>(new MyComparator(myMap));
        myMap2.putAll(myMap);
        System.out.println(myMap2);


    }

    static class MyComparator implements Comparator<String> {

        Map<String, MyObj> map;

        public MyComparator(Map<String, MyObj> map) {
            this.map = map;
        }

        public int compare(String o1, String o2) {

            if (map.get(o2) == map.get(o1))
                return 1;
            else
                return (map.get(o2)).compareTo(
                        map.get(o1));

        }
    }
}
