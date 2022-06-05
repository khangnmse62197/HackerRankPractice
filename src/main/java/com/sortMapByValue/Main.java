package main.java.com.sortMapByValue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<String, MyObj> myMap = new HashMap<>();
        MyObj myObj = new MyObj("aaaa", 1);
        MyObj myObj2 = new MyObj("abz", 3);
        MyObj myObj3 = new MyObj("aab", 2);

        myMap.put("1", myObj2);
        myMap.put("2", myObj);
        myMap.put("3", myObj3);

        System.out.println(myMap);


        Map<String, MyObj> myMap2 = new TreeMap<>(new MyComparator(myMap));
        myMap2.putAll(myMap);
        System.out.println(myMap2);


    }

    static class MyComparator<K, V extends Comparable<V>> implements Comparator<K> {

        Map<K, V> map;

        public MyComparator(Map<K, V> map) {
            this.map = map;
        }

        @Override
        public int compare(K o1, K o2) {
            return(map.get(o2)).compareTo(map.get(o1));
        }
    }
}
