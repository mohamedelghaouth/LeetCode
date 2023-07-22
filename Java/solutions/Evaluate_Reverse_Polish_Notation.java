package Java.solutions;

import java.util.ArrayDeque;
import java.util.Deque;
public class Evaluate_Reverse_Polish_Notation {
    static final private String OPERATORS = "+-*/";

    private boolean isOperator(String key) {
        return OPERATORS.contains(key);
    }

    private Integer doOperation(String token, Integer secondOperand, Integer firstOperand) {
        switch (token) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return firstOperand / secondOperand;
            default:
                return Integer.parseInt(token);
        }
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (String token : tokens) {

            if(isOperator(token))  stack.push(doOperation(token, stack.pop(), stack.pop()));
            else  stack.push(Integer.parseInt(token));
            
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        Evaluate_Reverse_Polish_Notation solution = new Evaluate_Reverse_Polish_Notation();

        int respond1 = solution.evalRPN(new String[]{ "2", "1", "+", "3", "*" });
        int respond2 = solution.evalRPN(new String[]{ "4", "13", "5", "/", "+" });
        int respond3 = solution.evalRPN(new String[]{ "10","6","9","3","+","-11","*","/","*","17","+","5","+" });

        System.out.println(respond1);
        System.out.println(respond2);
        System.out.println(respond3);

        assert respond1 == 9  : "the wright answer is 9";
        assert respond1 == 6  : "the wright answer is 6";
        assert respond1 == 22 : "the wright answer is 22";
    }
}
