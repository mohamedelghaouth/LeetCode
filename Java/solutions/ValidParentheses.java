package Java.solutions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {

    private static final Map<Character, Character> BRACKETS_MAP = 
        Map.of(
            '(',')', 
            '[', ']', 
            '{', '}'
        );


    public boolean isAnOpeningBracket(Character currentElement) {
        return currentElement != null && BRACKETS_MAP.containsKey(currentElement);
    }

    public boolean  isNotTheClosingBracketForTheLastElement(Character lastElement, Character currentElement) {
        return !BRACKETS_MAP.get(lastElement).equals(currentElement);
    }

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     *
     * @format
     */
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            Character currentElement = s.charAt(i);
            if (isAnOpeningBracket(currentElement)) {
                deque.push(currentElement);
            } else {

                Character lastElement = deque.pollFirst();
                if (!isAnOpeningBracket(lastElement) || isNotTheClosingBracketForTheLastElement(lastElement, currentElement)) {
                    deque.push(lastElement);
                    deque.push(currentElement);
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {

        ValidParentheses validParentheses = new ValidParentheses();
        
        boolean answer1 = validParentheses.isValid("[()]");
        boolean answer2 = validParentheses.isValid("(])");
        boolean answer3 = validParentheses.isValid("]");
        boolean answer4 = validParentheses.isValid("()");
        
        assert answer1 : "The Correct answer is true";
        assert !answer2 : "The Correct answer is false";
        assert !answer3 : "The Correct answer is false";
        assert answer4 : "The Correct answer is true";
        

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
       
    }
    
}
