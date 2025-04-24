import java.util.*;

class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    boolean turn = true;

    public MyQueue() {
    }
    
    public void push(int x) {
        if (turn) {
            stack1.push(x);
        } else {
            stack2.push(x);
        }
    }
    
    public int pop() {
        int popNum;
        if (turn) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            popNum = stack2.pop();  
        } else {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            popNum = stack1.pop();  
        }
        turn = !turn;
        return popNum;
        
    }
    
    public int peek() {
        if (turn) {
            return stack1.get(0);
        } else {
            return stack2.get(0);
        }
    }
    
    public boolean empty() {
        if (turn) {
            return stack1.isEmpty();
        } else {
            return stack2.isEmpty();
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */