import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;  // 초단위
        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int curr = prices[i];
            if (stack.isEmpty()) {
                stack.push(new int[] {curr, i});
            } else {
                // 현재 가격보다 작거나 같을 때까지 pop 후 떨어진 시간 계산
                while (!stack.isEmpty() && stack.peek()[0] > curr) {
                    int[] priceInfo = stack.pop();
                    answer[priceInfo[1]] = i - priceInfo[1];
                }
                stack.push(new int[] {curr, i});
            }
        }
        
        while (!stack.isEmpty()) {
            int[] priceInfo = stack.pop();
            answer[priceInfo[1]] = n - 1 - priceInfo[1];
        }

        
        return answer;
    }
}