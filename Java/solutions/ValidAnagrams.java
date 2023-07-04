package Java.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class ValidAnagrams {
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
}