package Java.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private Deque<Integer> privateDeque;
    private int min;

    public MinStack() {
        privateDeque = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        min = Integer.min(min, val);
        privateDeque.push(val);
    }

    private void updateMin() {
        min = privateDeque.stream().min(Comparator.comparing(Integer::intValue)).orElse(Integer.MAX_VALUE);
    }
    public void pop() {
        int tmp = privateDeque.pollFirst().intValue();

        if(tmp == min) updateMin();
    }

    public int top() {
        return privateDeque.peek();
    }

    public int getMin() {
        return min;
    }

    public String toString(){
        return Arrays.toString(privateDeque.toArray());
    }

    public static void main(String[] args) {

         // Your MinStack object will be instantiated and called as such:
        MinStack obj = new MinStack();
        obj.push(2);
        obj.pop();

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assert minStack.getMin() == -3: "the Correct answer -3" ;
        minStack.pop();
        assert minStack.top() == 0: "the Correct answer 0" ;
        assert minStack.getMin() == -2: "the Correct answer -2" ;


        MinStack minStack_1 = new MinStack();
        minStack_1.push(2);
        minStack_1.push(0);
        minStack_1.push(3);
        minStack_1.push(0);
        assert minStack_1.getMin() == 0: "the Correct answer 0" ;
        minStack_1.pop();
        assert minStack_1.getMin() == 0: "the Correct answer 0" ;
        minStack_1.pop();
        assert minStack_1.getMin() == 0: "the Correct answer 0" ;
        minStack_1.pop();
        assert minStack_1.getMin() == 2: "the Correct answer 2" ;

        MinStack minStack_2 = new MinStack();
        minStack_2.push(1);
        minStack_2.push(2);
        assert minStack_2.top() == 2: "the Correct answer 2" ;
        assert minStack_2.getMin() == 1: "the Correct answer 1" ;
        minStack_2.pop();
        assert minStack_2.getMin() == 1: "the Correct answer 2" ;
        assert minStack_2.top() == 1: "the Correct answer 1" ;

    }
}
