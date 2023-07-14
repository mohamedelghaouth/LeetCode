package Java.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Example1
 *
 * Input: ["lint","code","love","you"]
 * Output: ["lint","code","love","you"]
 * Explanation:
 * One possible encode method is: "lint:;code:;love:;you"
 *
 * Example2
 * Input: ["we", "say", ":", "yes"]
 * Output: ["we", "say", ":", "yes"]
 * Explanation:
 * One possible encode method is: "we:;say:;:::;yes"
 *
 * */
public class EncodeDecodeStrings {

    private static  final char PATTERN = '@';

    /**
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        // write your code here
        StringBuilder encodedString = new StringBuilder();

        strs.forEach( (str) -> encodedString.append(encode(str)) );

        return encodedString.toString();
    }

    /**
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {

        List<String> res = new ArrayList<>();
        char[] charsArray = str.toCharArray();
        int i = 0;
        while(i < str.length()) {
            String word = detectWord(i, charsArray);
            res.add(word);
            i+= (word.length() + 2);
        }
        return res;
    }
    public static String detectWord(int start, char[] charsArray) {
        StringBuilder res = new StringBuilder();
        int worldLength = Character.getNumericValue(charsArray[start + 1]);

        res.append(Arrays.copyOfRange(charsArray, start + 2, start + 2 + worldLength));
        return res.toString();
    }

    public static String encode(String str) {
        StringBuilder encodedString = new StringBuilder();
        return encodedString.append(PATTERN).append(str.length()).append(str).toString();
    }

    public static void main(String[] args) {
        //      System.out.println("-----------Encode-------------");
//        System.out.println(encode("@m@@e@d@"));
//        System.out.println(encode("med@"));
//        System.out.println(encode("m@ed"));
//        System.out.println(encode("@med"));
//        System.out.println(encode("med"));
//        System.out.println(encode("@med@"));
        System.out.println("-----------Array-------------");
        String[] s = {"@m@@e@d@","@med", "3m&ed@4", "3m&ed@", "m&ed@", "@m@ed@", "m@ed", "@med", "med", "@med@"};
        System.out.println(Arrays.asList(s));
        System.out.println("-----------Encoded Array-------------");
        String encodeString = encode(Arrays.asList(s));
        System.out.println(encodeString);
        System.out.println("-----------Decode-------------");
        System.out.println(decode(encodeString));
    }
}
