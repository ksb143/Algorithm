import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int equalNum = s / n;
        int restNum = s % n;

        if (equalNum == 0) {
            int[] exception = {-1};
            return exception;
        } else {
            int[] answer = new int[n];
            Arrays.fill(answer, equalNum);
            for (int i = 0; i < restNum; i++) {
                answer[i % n] += 1;
            }
            Arrays.sort(answer);
            return answer;

        }
    }
}