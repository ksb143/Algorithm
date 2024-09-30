import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {

        int left = 0;
        int right = Arrays.stream(cores).max().getAsInt() * n;

        int resultTime = 0;

        while (left <= right) {
            int cnt = cores.length;  // 0시간에 3개 다 일을 한 것이므로 초기화
            int mid = (left + right) / 2;
            for (int core : cores) {
                cnt += mid / core;
            }
            if (cnt >= n) {
                resultTime = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int totalTasks = cores.length;
        for (int core: cores) {
            totalTasks += (resultTime - 1) / core;
        }

        int remainingTasks = n - totalTasks;

        for (int i = 0; i < cores.length; i++) {
            if (resultTime % cores[i] == 0) {
                remainingTasks--;
                if (remainingTasks == 0) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}
