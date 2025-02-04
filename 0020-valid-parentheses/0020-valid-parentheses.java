import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {  // 여는 괄호일 경우
                stack.push(c);
            } else {  // 닫는 괄호의 경우
                if (stack.size() == 0){
                    return false;
                }
                char open = stack.pop();
                // 짝이 맞지 않는다면 false
                if (c == ')' && open != '(') {
                    return false;
                } else if (c == '}' && open != '{') {
                    return false;
                } else if (c == ']' && open != '[') {
                    return false;
                }
            }
        }
        // 스택에 괄호가 남아 있는 경우 false
        if (stack.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}