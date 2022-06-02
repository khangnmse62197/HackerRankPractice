package main.java.com.intermidiate.nonDivisibleSubset;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution2 {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        List<Integer> remainders = s.stream()
                .map(item -> item % k)
                .collect(Collectors.toList());

        Map<Integer, Long> frequencyMap = remainders.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));


        Set<Integer> willBeRemoved = new HashSet<>();
        for (Integer key1 : frequencyMap.keySet()) {
            boolean caseDoubleRemainder = (key1 == 0 || key1 * 2 == k) && frequencyMap.get(key1) > 1;
            if (caseDoubleRemainder) {
                frequencyMap.put(key1, 1L);
            }

            for (Integer key2 : frequencyMap.keySet()) {
                boolean caseTwoRemainderPlusEqualsK = !key1.equals(key2) && (key1 + key2 == k);
                if (caseTwoRemainderPlusEqualsK) {
                    if (frequencyMap.get(key1) > frequencyMap.get(key2)) {
                        willBeRemoved.add(key2);
                    }

                    if (frequencyMap.get(key1) < frequencyMap.get(key2)) {
                        willBeRemoved.add(key1);
                    }

                    if (Objects.equals(frequencyMap.get(key1), frequencyMap.get(key2))) {
                        willBeRemoved.add(Math.max(key1, key2));
                    }
                }

            }
        }
        willBeRemoved.forEach(frequencyMap::remove);

        return frequencyMap.values()
                .stream()
                .map(Long::intValue)
                .reduce(0, Integer::sum);
    }




    public static void main(String[] args) {
        System.out.println(nonDivisibleSubset(4, new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10
        ))));
    }
}
