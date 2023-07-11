package Java.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class GroupAnagrams {
    private void addToMap(Map<String, Integer> m, String s) {
        Integer tmp = m.get(s);
        if(tmp == null) {
            m.put(s, Integer.valueOf(1));
        } else {
             m.put(s, Integer.valueOf(tmp + 1));
        }
    }

    private Map<String, Integer> wordToMap(String s) {
        Map<String, Integer> m = new HashMap<String, Integer>();

        for(int i = 0; i < s.length(); i++){
            addToMap(m, s.charAt(i) + "");
        }

        return m;
    }

    private Boolean haveTheSameElements(Set<String> ss, Set<String> ts) {
        boolean samSize = ss.size() == ts.size();
        boolean ssContainAllElementOfTs = ss.containsAll(ts);

        return samSize && ssContainAllElementOfTs;
    }

    private Boolean numberOfApperanceIsTheSame(String c, Map<String, Integer> s, Map<String, Integer> t) {
        return s.get(c).equals(t.get(c));
    }

    private boolean areAnagram(Map<String, Integer> s, Map<String, Integer> t) {
        Set<String> ss = s.keySet();
        Set<String> ts = t.keySet();

        if(ss.size() != ts.size()){
            return false;
        } else if(haveTheSameElements(ss, ts)){
            return ss.stream().allMatch(c -> numberOfApperanceIsTheSame(c, s, t));
        } else {
            return false ;
        }
        
    }

    /*
    * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    */
    public boolean isAnagram(String s, String t) {
        return areAnagram(wordToMap(s), wordToMap(t));
    }
    
    public List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        Arrays.stream(strings).forEach(t -> {
            if (!map.containsKey(t)) {
                for (String key : map.keySet()) {
                    if (isAnagram(key, t)) {
                        map.get(key).add(t);
                        return;
                    }
                }
                map.put(t, new ArrayList<>(Arrays.asList(t)));
            } else {
                map.get(t).add(t);
            }
        });

        return map.values().stream().collect(Collectors.toList());
    }

    public String getSortedVersion(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /*
     * anagrams words become the same when sorted: 
     * eat -> aet
     * tea -> aet
     */

    public List<List<String>> groupAnagramsSecondSolution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            String sortedWord = getSortedVersion(word);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }

}
