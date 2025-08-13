import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] arr = new int[2 * n];
        int left = 0;
        int right = n - 1;
        long total = 0;
        long sum = 0;  // queue1 합계
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = queue1[i];
            arr[i + n] = queue2[i];
            sum += queue1[i];
            total += queue1[i] + queue2[i];
            max = Math.max(max, Math.max(queue1[i], queue2[i]));
        }
        if (total % 2 == 1) return -1;  // 애초에 둘 합해서 짝수가 아니면 못 구함
        long target = total / 2;  // 타겟
        // 
        if (max > target) return -1;  // 한 값이 타겟을 넘으면 불가
        int CAP = 3 * n;
        int moves = 0;
        while (moves <= CAP && right < 2 * n) {
            if (sum == target) {
                return moves;
            } else if (sum < target) {
                if (right + 1 == 2 * n) {
                    break;
                }
                sum += arr[++right];
            } else {
                sum -= arr[left++];
            }
            moves++;
        }
        return -1;
    }
}