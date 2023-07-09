package Java.solutions;

import java.util.*;

public class TopK_Frequent_Elements {

    /**
     * cont the number of apparition for every element, then return a map containing the elements and their
     * number of apparition
     *
     * key -> element
     * value -> number of apparition
     *
     */
    Map<Integer, Integer> getCountingMap(int[] nums) {
        Map<Integer, Integer> countingMap = new HashMap<>();
        for(int i: nums){
            countingMap.put(i, countingMap.getOrDefault(i,0) + 1);
        }

        return countingMap;
    }

    /**
     * swap the keys and the values
     *
     * key -> old Value
     *
     * value -> List of all keys from sourceMap that had that value(wich is key is the nes map)
     *
     */
    Map<Integer, List<Integer>> swapKeyValueOfMap(Map<Integer, Integer> sourceMap){
        Map<Integer, List<Integer>> swappedMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : sourceMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            List<Integer> keys = swappedMap.getOrDefault(value, new ArrayList<>());
            keys.add(key);
            swappedMap.put(value, keys);
        }

        return swappedMap;
    }

    void addFromListToArray( int startFrom, int numberOfElementToAdd, int[] arrayToAddTo, List<Integer> listToAddFrom){
        int runner = startFrom;
        for (int j = 0; j < numberOfElementToAdd; j++) {
            arrayToAddTo[runner++] = listToAddFrom.get(j);
        }
    }

    List<Integer> orderSetElementInDescendingOrder(Set<Integer> sourceSet) {

        List<Integer> list = new ArrayList<>(sourceSet);
        Collections.sort(list, Collections.reverseOrder());

        return list;
    }

    /**
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     *
     * the K element that are the most frequent
     */
    public int[] topKFrequent(int[] nums, int k) {

        // count the number of apparition for every element
        Map<Integer, Integer> countingMap = getCountingMap(nums);

        Map<Integer, List<Integer>> swappedMap = swapKeyValueOfMap(countingMap);

        List<Integer> valuesList = orderSetElementInDescendingOrder(swappedMap.keySet());

        int[] result = new int[k];
        int secondRunner = 0;


        for(Integer i :valuesList){
            int tmpListLength = swappedMap.get(i).size();
            if(secondRunner + tmpListLength < k){
                addFromListToArray(secondRunner, tmpListLength, result, swappedMap.get(i));
                secondRunner += tmpListLength;
            } else {
                int numberOfElementToAdd = k - secondRunner;
                addFromListToArray(secondRunner, numberOfElementToAdd, result, swappedMap.get(i));
                secondRunner += numberOfElementToAdd;
            }

            if(secondRunner > k - 1) {
                break;
            }
        }

        return result;
    }
}